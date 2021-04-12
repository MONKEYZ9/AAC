package com.lsm.aacs.temp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsm.aacs.member.Member;
import com.lsm.aacs.member.MemberDAO;

import oracle.net.aso.i;

@Controller
public class TempController {
	@Autowired
	private TempDAO tDAO;
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/temp.data.set", method = RequestMethod.GET)
	public String tempDataSet(HttpServletRequest req, Temp t, Member m) {
		tDAO.showNowWeather(req);
		if (mDAO.loginCheck(req, m)) {
			tDAO.getAIDataNShowresultLogin(req, m);
			req.setAttribute("logoPage", "logoPage/logo.jsp");
			req.setAttribute("contentPage", "contentPage/nowStatueWhileUserSet.jsp");
			req.setAttribute("loginPage", "loginPage/showInfoLogout.jsp");
		}
		req.setAttribute("logoPage", "logoPage/logo.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/temp.userData.get", method = RequestMethod.GET)
	public String memberJoin(HttpServletRequest req, Temp t, Member m) {
		tDAO.showNowWeather(req);
		if (mDAO.loginCheck(req, m)) {
			tDAO.getAIDataNShowresultLogin(req, m);
			tDAO.regData(req, m, t);
			req.setAttribute("logoPage", "logoPage/logo.jsp");
			req.setAttribute("contentPage", "contentPage/nowStatueWhileUserSet.jsp");
			req.setAttribute("loginPage", "loginPage/showInfoLogout.jsp");
		}
		req.setAttribute("logoPage", "logoPage/logo.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/member.serial.check", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Temps serialNumberCheck(Temp t) {
		return tDAO.serialCheck(t);
	}
	
	
}
