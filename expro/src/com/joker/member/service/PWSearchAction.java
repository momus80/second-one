package com.joker.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.joker.member.db.MemberDAO;

public class PWSearchAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("PWSearchAction");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String pwd = null;
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		MemberDAO mDao = MemberDAO.getInstance();
		pwd = mDao.PWSearch(id, email);
		
		if(pwd == null) {
			System.out.println("pwd가 null입니다.");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("pwd", pwd);
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/member/PWSearch.jsp");
		return forward;
	}
}
