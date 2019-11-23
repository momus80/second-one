package com.member.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.db.BoardDAO;
import com.assignment.db.BoardDTO;
import com.assignment.db.ReplyDAO;
import com.assignment.db.ReplyDTO;

public class BoardContent implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardContent");
		HttpSession session = request.getSession();
		BoardDAO manager = BoardDAO.getInstance();
		ReplyDAO rDao = ReplyDAO.getInstance();
		List<ReplyDTO> list = new ArrayList<ReplyDTO>();
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		int kind = (int)session.getAttribute("kind");
		//댓글 번호
		String start = request.getParameter("replyNum");
		if(start == null) {
			start = "1";
		}
		int cnt = 10; //현 페이지에 출력될 갯수
			
		//댓글 가져오기
		list = rDao.getReply(bno,(Integer.parseInt(start)-1)*cnt,cnt);
		double count = Math.ceil(rDao.getReplyCount(bno)/cnt);
		int count1 = (int)count;
		
		int [] reply = new int[count1];
		for(int i=0; i<=reply.length-1; i++) {
			reply[i] = i+1;
		}
		//게시물 내용 가져오기
		BoardDTO content = manager.getboard(bno);
		
		//댓글 페이지 갯수 set
		request.setAttribute("reply", reply);
		request.setAttribute("count", count);
		request.setAttribute("bno", content);
		session.setAttribute("kind", kind);
		request.setAttribute("list", list);
		
		//Foward방식
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/get.jsp");
		return forward;


	}
}
