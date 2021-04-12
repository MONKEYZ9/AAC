package com.lsm.aacs.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsm.aacs.DataManager;
import com.lsm.aacs.temp.Temp;
import com.lsm.aacs.temp.TempDAO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private TempDAO tDAO;

	@RequestMapping(value = "/member.join.go", method = RequestMethod.GET)
	public String memberGoJoin(Member m, HttpServletRequest req) {
		DataManager.getCurYear(req);
		req.setAttribute("logoPage", "logoPage/logo.jsp");
		req.setAttribute("contentPage", "contentPage/join.jsp");
		req.setAttribute("loginPage", "loginPage/join_ing.jsp"); // 회원가입동안은 빈거로 내비뒀습니다.
		return "index";
	}

	@RequestMapping(value = "/member.join", method = RequestMethod.POST)
	public String memberJoin(HttpServletRequest req, Member m) {
		mDAO.memberJoin(req, m);
		tDAO.showNowWeather(req);
		req.setAttribute("logoPage", "logoPage/logo.jsp");
		req.setAttribute("contentPage", "contentPage/nowStatue.jsp");
		req.setAttribute("loginPage", "loginPage/login.jsp");
		return "index";
	}
	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String memberLogin(HttpServletRequest req, Member m) {
		tDAO.showNowWeather(req);
		mDAO.memberlogin(req, m);
		if (mDAO.loginCheck(req, m)) {
			req.setAttribute("logoPage", "logoPage/logo.jsp");
			req.setAttribute("contentPage", "contentPage/nowStatueAfterJoin.jsp");
			req.setAttribute("loginPage", "loginPage/showInfoLogout.jsp");
		}
		req.setAttribute("logoPage", "logoPage/logo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.logout.go", method = RequestMethod.GET)
	public String memberLogout(Member m, HttpServletRequest req) {
		tDAO.showNowWeather(req);
		mDAO.logout(req);
		req.setAttribute("logoPage", "logoPage/logo.jsp");
		req.setAttribute("contentPage", "contentPage/nowStatue.jsp");
		req.setAttribute("loginPage", "loginPage/login.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.info.go", method = RequestMethod.GET)
	public String memberInfo(Member m, HttpServletRequest req) {
		tDAO.showNowWeather(req);
		mDAO.showInfo(req, m);
		req.setAttribute("logoPage", "logoPage/logo.jsp");
		req.setAttribute("contentPage", "contentPage/info.jsp");
		req.setAttribute("loginPage", "loginPage/showDataSetLogout.jsp");
		return "index";
	}
	@RequestMapping(value = "/member.info.upadate", method = RequestMethod.GET)
	public String memberInfoUpdate(Member m, HttpServletRequest req) {
		tDAO.showNowWeather(req);
		mDAO.updateInfo(req, m);
		req.setAttribute("logoPage", "logoPage/logo.jsp");
		req.setAttribute("contentPage", "contentPage/info.jsp");
		req.setAttribute("loginPage", "loginPage/showDataSetLogout.jsp");
		return "index";
	}
	@RequestMapping(value = "/member.dropout", method = RequestMethod.GET)
	public String memberDropOut(Member m, HttpServletRequest req) {
		tDAO.showNowWeather(req);
		mDAO.dropOut(req, m);
		req.setAttribute("logoPage", "logoPage/logo.jsp");
		req.setAttribute("contentPage", "contentPage/nowStatue.jsp");
		req.setAttribute("loginPage", "loginPage/login.jsp");
		return "index";
	}
	
//	아이디 체크하기
	@RequestMapping(value = "/member.email.check", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Members memberGetJSON(HttpServletRequest request, HttpServletResponse res, Member m) {
		return mDAO.memberEmailCheck(m);
	}
	
	
//	@RequestMapping(value = "/memberJSON.get", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
//	public @ResponseBody Members memberGetJSON(HttpServletRequest request, HttpServletResponse res, Member m) {
//		res.addHeader("Access-Control-Allow-Origin", "*");
//		return mDAO.getMemberJSON(m);
//	}
	
}
