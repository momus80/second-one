package com.joker.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.joker.member.db.MemberDAO;

public class IDSearchAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("IDSearchAction");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = null;
		
		String email = request.getParameter("email");
		MemberDAO mDao = MemberDAO.getInstance();
		id = mDao.IDSearch(email);
		
		if(id == null) {
			System.out.println("id가 null입니다.");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/member/IDSearch.jsp");
		return forward;
	}

}
