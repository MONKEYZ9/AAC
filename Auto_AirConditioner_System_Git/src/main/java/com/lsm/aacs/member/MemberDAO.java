package com.lsm.aacs.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;

	public void memberJoin(HttpServletRequest req, Member m) {
		try {
			// 아이디겸 이메일 받고 세팅
			String aac_email1 = req.getParameter("aac_email1");
			String aac_email2 = req.getParameter("aac_email2");
			String aac_email = aac_email1 + aac_email2;
			System.out.println(aac_email1);
			m.setAac_email(aac_email);

			// 주소 받고 세팅
			String aac_addr1 = req.getParameter("aac_join_addr1");
			String aac_addr2 = req.getParameter("aac_join_addr2");
			String aac_addr3 = req.getParameter("aac_join_addr3");
			String aac_addr = aac_addr1 + "!" + aac_addr2 + "!" + aac_addr3;
			m.setAac_addr(aac_addr);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				System.out.println("가입완료");
				String serial = m.getAac_member_serial_number();
				req.getSession().setAttribute("serialNumber", serial);
				req.getSession().setMaxInactiveInterval(10 * 30);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("등록실패");
		}
	}
// 로그인하기전에 내가 먼저 멤버의 모든걸 가져와서 JSON처리해주자 -> JSON을 가져와서 
//	public Members getMemberJSON(Member m) {
//		System.out.println(m.getAac_email());
//		return new Members(ss.getMapper(MemberMapper.class).getMemberNkNNLogin(m));
//	}

//	로그인 하자
	public void memberlogin(HttpServletRequest req, Member m) {
//		jsp에서 받아온 값
		String aac_email = m.getAac_email();
		String aac_password = m.getAac_password();

//		로그인시 기존꺼랑 비교하자 데이터를 가져오는거
		List<Member> members = ss.getMapper(MemberMapper.class).getMemberNkNNLogin(m);
		if (members.isEmpty()) {
			System.out.println("로그인실패");
		} else if (aac_email.equals(members.get(0).getAac_email())
				|| aac_password.equals(members.get(0).getAac_password())) {
			m = members.get(0);
			req.getSession().setAttribute("loginMember", m);
			req.getSession().setMaxInactiveInterval(10 * 10);

		}

//			로그인 아이디가 남게끔 하는걸 쿠키로 해보자
//			Cookie c = new Cookie("lastID", s_id);
//			c.setMaxAge(43200
//			response.addCookie(c);
	}

//	로그인을 체크해주자
	public boolean loginCheck(HttpServletRequest req, Member m) {
		m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) { // 리턴하고 땡치지말고
//			로그인 성공시 보여줄 페이지를 따로 처리해주자
			return true;
		}
//		로그인 실패시 보여줄 페이지를 따로 처리하자
		req.setAttribute("contentPage", "contentPage/nowStatue.jsp");
		req.setAttribute("loginPage", "loginPage/login.jsp");
		return false;
	}

	// 로그아웃하기
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}

//	인포보여주기
	public void showInfo(HttpServletRequest req, Member m) {
		try {
			m = (Member) req.getSession().getAttribute("loginMember");
			req.setAttribute("m", m);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

//	인포수정하기
	public void updateInfo(HttpServletRequest req, Member m) {
		try {
			m = (Member) req.getSession().getAttribute("loginMember");
			req.setAttribute("m", m);
			m.setAac_email(m.getAac_email());
			req.getParameter("aac_member_serial_number");
			if (ss.getMapper(MemberMapper.class).updateSerialByEmail(m) == 1) {
				System.out.println("수정완료");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("수정실패");
		}

	}
	
//	탈퇴하기
	public void dropOut(HttpServletRequest req, Member m) {
		try {
			m = (Member) req.getSession().getAttribute("loginMember");
			req.setAttribute("m", m);
			m.setAac_email(m.getAac_email());
			if (ss.getMapper(MemberMapper.class).dropOutByEmail(m) == 1) {
				System.out.println("탈퇴완료");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("수정실패");
		}
		
	}

//	중복 이메일 체크
	public Members memberEmailCheck(Member m) {
		return new Members(ss.getMapper(MemberMapper.class).getMemberByEmail(m));
	}

}
