package com.joker.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joker.board.service.BoardContent;
import com.joker.board.service.BoardDelete;
import com.joker.board.service.BoardList;
import com.joker.board.service.BoardUpdate;
import com.joker.board.service.BoardUpdateForm;
import com.joker.board.service.BoardWrite;
import com.joker.board.service.RecCount;
import com.joker.board.service.RecUpdate;
import com.joker.member.service.Action;
import com.joker.member.service.ActionForward;
import com.joker.member.service.IDSearchAction;
import com.joker.member.service.LogOut;
import com.joker.member.service.LoginAction;
import com.joker.member.service.MemberJoin;
import com.joker.member.service.MemberUpdate;
import com.joker.member.service.MemberUpdateForm;
import com.joker.member.service.NewLoginAction;
import com.joker.member.service.PWSearchAction;
import com.joker.member.service.PasswdChange;
import com.joker.member.service.Withdrawal;
import com.joker.reply.service.GetReply;
import com.joker.reply.service.ReplyWriteAction;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println("requestURI : " + requestURI);
		System.out.println("contextPath : " + contextPath);
		System.out.println("command : " + command);

		Action action = null;
		ActionForward forward = null;

		// 회원가입 폼
		if (command.equals("/MemberJoinForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./member/memberJoinForm.jsp");
		}
		// 회원 가입
		else if (command.equals("/MemberJoin.do")) {
			try {
				action = new MemberJoin();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// index 
		else if (command.equals("/Index.do")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./index.jsp");
		}
		// 로그인 폼으로 이동
		else if (command.equals("/LoginForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./member/loginForm.jsp");
		}
		// 로그인
		else if (command.equals("/LoginAction.do")) {
			try {
				action = new LoginAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 새창 로그인 폼
		else if (command.equals("/NewLoginForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./member/newLoginForm.jsp");
		}
		// 새창 로그인
		else if (command.equals("/NewLoginAction.do")) {
			try {
				action = new NewLoginAction();
				action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//  로그아웃
		else if (command.equals("/LogOut.do")) {
			try {
				action = new LogOut();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 정보수정폼 form
		else if(command.equals("/MemberUpdateForm.do")){
			try {
				action = new MemberUpdateForm();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 정보수정
		else if(command.equals("/MemberUpdate.do")){
			try {
				action = new MemberUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 비밀번호 변경 폼
		else if(command.equals("/PasswdChangeForm.do")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/passwdChangeForm.jsp");
		}
		// 비밀번호 변경
		else if(command.equals("/PasswdChange.do")){
			try {
				action = new PasswdChange();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 
		else if (command.equals("/WithdrawalForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/withdrawalForm.jsp");
		}
		// 
		else if (command.equals("/Withdrawal.do")) {
			try {
				action = new Withdrawal();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 게시판 목록
		else if (command.equals("/BoardList.do")) {
			try {
				action = new BoardList();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 게시판 글작성 form
		else if (command.equals("/BoardWriteForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./board/boardWriteForm.jsp?section="+request.getParameter("section"));
		}
		// 게시판 글작성
		else if (command.equals("/BoardWrite.do")) {
			try {
				action = new BoardWrite();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 게시판 상세 페이지
		else if (command.equals("/BoardContent.do")) {
			try {
				action = new BoardContent();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 추천수 업데이트
		else if (command.equals("/RecUpdate.do")) {
			try {
				action = new RecUpdate();
				action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 추천수 검색
		else if (command.equals("/RecCount.do")) {
			try {
				action = new RecCount();
				action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 댓글 등록
		else if (command.equals("/ReplyWriteAction.do")) {
			try {
				action = new ReplyWriteAction();
				action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 댓글 
		else if (command.equals("/GetReply.do")) {
			try {
				action = new GetReply();
				action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 게시판 수정 폼
		else if (command.equals("/BoardUpdateForm.do")) {
			try {
				action = new BoardUpdateForm();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 게시글 수정
		else if (command.equals("/BoardUpdate.do")) {
			try {
				action = new BoardUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 게시글 삭제
		else if (command.equals("/BoardDelete.do")) {
			try {
				action = new BoardDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 아이디 찾기
		else if(command.equals("/IDSearch.do")){
			try {
				action = new IDSearchAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 비밀번호 찾기
		else if(command.equals("/PasswdFind.do")){
			try {
				action = new PWSearchAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 페이지 이동
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		System.out.println("post");
		doProcess(request, response);
	}
}
