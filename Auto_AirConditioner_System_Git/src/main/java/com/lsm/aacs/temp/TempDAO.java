package com.lsm.aacs.temp;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsm.aacs.member.Member;
import com.lsm.aacs.member.MemberMapper;
import com.lsm.aacs.member.Members;
import com.lsm.http.clientnewversion.LSMHttpClientNewVersion;
import com.lsm.ml.lib.LSM_kNN;

@Service
public class TempDAO {

	@Autowired
	private SqlSession ss;

//	중복 시리얼 체크
	public Temps serialCheck(Temp t) {
		return new Temps(ss.getMapper(TempMapper.class).checkSerial(t));
	}

//	기존 해당 시리얼에 들어간 데이터를 가지고 kNN 알고리즘을 통해 오늘 현재 날씨에 맞는 에어컨 설정을 보여주기
//	이건 로그인 했을때
	public void getAIDataNShowresultLogin(HttpServletRequest req, Member m) {

		// knn설정해줘야 해
		HashMap<String, ArrayList> trainData = new HashMap<String, ArrayList>();
		// 날씨 데이터를 넣어주자
		ArrayList<double[]> datas = new ArrayList<double[]>();
		// 날씨에 대한 에어컨의 정도를 넣어주는 정도
		ArrayList<String> sagi = new ArrayList<String>();

		double aac_temp;
		double aac_humidity;
		String aac_statue;

		HttpSession hs = req.getSession();
		m = (Member) req.getSession().getAttribute("loginMember");
		m.getAac_member_serial_number();

		try {
			List<Temp> temps = ss.getMapper(TempMapper.class).getTempNkNNLogin(m);
			for (int i = 0; i < temps.size(); i++) {
				aac_temp = temps.get(i).getAac_temp().doubleValue();
				aac_humidity = temps.get(i).getAac_humidity().doubleValue();
				aac_statue = temps.get(i).getAac_statue();
				datas.add(new double[] { aac_temp, aac_humidity });
				sagi.add(aac_statue);
			}
			// knn에 넣어야 할 데이터는 다 넣었어
			trainData.put("datas", datas);
			trainData.put("labels", sagi);
//			현재 날씨 데이터를 받아오자
			String addr = "http://api.openweathermap.org/data/2.5/weather?q=seoul&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr";

			InputStream is;
			is = LSMHttpClientNewVersion.download(addr);
			String str = LSMHttpClientNewVersion.convert(is, "UTF-8");
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(str);

			// 온도 구하기
			// 습도구하기
//			현재 JSON에서 받은 이것 자체가 Object임 더블로 바꿔주자
			JSONObject a = (JSONObject) jo.get("main");
			JSONObject a2 = (JSONObject) jo.get("main");
			double nowTemp = Double.parseDouble((a.get("feels_like")).toString());
			double nowHumidity = Double.parseDouble((a2.get("humidity").toString()));

			double[] tNh = { nowTemp, nowHumidity };

//			예측할 하나만 뽑자
			String sagiZ = LSM_kNN.do_kNN(tNh, trainData, 9);

//			세션으로 값을 살려서 가자
			req.getSession().setAttribute("sagiZ", sagiZ);
		} catch (

		Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

//	현재 날씨랑 에어컨 설정을 인서트해주기 그래야 그걸 정리하지 
	public void regData(HttpServletRequest req, Member m, Temp t) {
		try {
			HttpSession hs = req.getSession();
			String sagiZ = (String) hs.getAttribute("sagiZ");
			m = (Member) req.getSession().getAttribute("loginMember");
			String aac_serial_number =  m.getAac_member_serial_number();
//		현재 날씨에 대한 상태
//		현재 날씨 데이터를 받아오자
			String addr = "http://api.openweathermap.org/data/2.5/weather?q=seoul&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr";
			InputStream is;
			is = LSMHttpClientNewVersion.download(addr);
			String str = LSMHttpClientNewVersion.convert(is, "UTF-8");
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(str);
//		현재 JSON에서 받은 이것 자체가 Object임 더블로 바꿔주자
			JSONObject a = (JSONObject) jo.get("main");
			JSONObject a2 = (JSONObject) jo.get("main");
			BigDecimal nowTemp = new BigDecimal((a.get("feels_like")).toString());
			BigDecimal nowHumidity = new BigDecimal(((a2.get("humidity").toString())));

			String userSagiz = req.getParameter("rec_option3");
			if (userSagiz != null) {
				BigDecimal userSagiz2 = new BigDecimal(userSagiz);
				BigDecimal tempCha = nowTemp.subtract(userSagiz2);
				double tempChaDouble = tempCha.doubleValue();
//			현재 온도와 내가 설정한 온도의 차이에 따라서 상태를 설정을 하자
//			온도차 변수

				String userStatue;
				if (tempChaDouble > 20) {
					userStatue = "터보";
				} else if (tempChaDouble > 16) {
					userStatue = "최강";
				} else if (tempChaDouble > 12) {
					userStatue = "강";
				} else if (tempChaDouble > 8) {
					userStatue = "중";
				} else if (tempChaDouble > 4) {
					userStatue = "하";
				} else {
					userStatue = "제습";
				}
				System.out.println(userStatue);
				t.setAac_statue(userStatue);
				hs.setAttribute("userSagiz", userStatue);
				
			} else {
				System.out.println(sagiZ);
				t.setAac_statue(sagiZ);
				hs.setAttribute("sagiZ", sagiZ);
				
			}

//		이제 이걸 넣어주자
			t.setAac_serial_number(aac_serial_number);
			t.setAac_temp(nowTemp);
			t.setAac_humidity(nowHumidity);

			if (ss.getMapper(TempMapper.class).regTempkNN(t) == 1) {
				System.out.println("등록완료");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("등록실패");

		}

	}

//	일단 현재날씨를 보여주자 첫 화면이야
	public void showNowWeather(HttpServletRequest req) {
		InputStream is;
		try {
//			현재 날씨 데이터를 받아오자
			String addr = "http://api.openweathermap.org/data/2.5/weather?q=seoul&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr";
			is = LSMHttpClientNewVersion.download(addr);
			String str = LSMHttpClientNewVersion.convert(is, "UTF-8");
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(str);
//			현재 JSON에서 받은 이것 자체가 Object임 더블로 바꿔주자
			JSONObject m = (JSONObject) jo.get("main");
			JSONObject m2 = (JSONObject) jo.get("main");
			BigDecimal nowTemp = new BigDecimal((m.get("feels_like")).toString());
			BigDecimal nowHumidity = new BigDecimal(((m2.get("humidity").toString())));

			req.setAttribute("nowTemp", nowTemp);
			req.setAttribute("nowHumidity", nowHumidity);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
