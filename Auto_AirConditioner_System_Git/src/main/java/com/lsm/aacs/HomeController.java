package com.lsm.aacs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsm.aacs.member.Member;
import com.lsm.aacs.member.MemberDAO;
import com.lsm.aacs.temp.Temp;
import com.lsm.aacs.temp.TempDAO;

@Controller
public class HomeController {
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private TempDAO tDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String AACSysHome(HttpServletRequest req, Temp t, Member m) {
		tDAO.showNowWeather(req);
		req.setAttribute("contentPage", "contentPage/nowStatue.jsp");
		req.setAttribute("loginPage", "loginPage/login.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String indexDo(HttpServletRequest req, Temp t, Member m) {
		tDAO.showNowWeather(req);
		if (mDAO.loginCheck(req, m)) {
			req.setAttribute("contentPage", "contentPage/nowStatueAfterJoin.jsp");
			req.setAttribute("loginPage", "loginPage/showInfoLogout.jsp");
		}
		req.setAttribute("logoPage", "logoPage/logo.jsp");
		return "index";
	}

}
