package com.joker.board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joker.board.db.BoardDAO;
import com.joker.member.service.Action;
import com.joker.member.service.ActionForward;

public class BoardUpdate implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		// 수정form에서 넘어온 값 저장
		int num = Integer.parseInt(request.getParameter("num"));
		String section = request.getParameter("section");
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String board_subject = request.getParameter("board_subject");
		String board_content = request.getParameter("board_content");
		
		// Map 객체에 db 작업을 위한 값 저장
		Map<String, Object> m = new HashMap<>();
		m.put("board_no", board_no);
		m.put("board_subject", board_subject);
		m.put("board_content", board_content);
		
		BoardDAO manager = BoardDAO.getInstance();
		manager.boardUpdate(m);
		
		// 수정 완료 후 이동할 페이지 설정
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("/expro/BoardContent.do?section="+section+"&num="+num+"&no="+board_no);
		
		return forward;
	}
	
}
