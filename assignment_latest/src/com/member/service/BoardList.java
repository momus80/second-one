package com.member.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.db.BoardDAO;
import com.assignment.db.BoardDTO;

public class BoardList implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardList");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		System.out.println(id);
		BoardDAO manager = BoardDAO.getInstance();
		int kind=Integer.parseInt(request.getParameter("kind"));
		session.setAttribute("kind", kind);
		List<BoardDTO> list = null;
		list = manager.getList(kind);
		session.setAttribute("id", id);
		// 뷰페이지로 공유할 값 설정
		request.setAttribute("list", list);
		request.setAttribute("kind", kind);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./index.jsp");

		return forward;
	}
}
