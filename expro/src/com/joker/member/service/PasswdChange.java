package com.joker.member.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joker.member.db.MemberDAO;
import com.joker.member.db.MemberDTO;

public class PasswdChange implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String oldPasswd = request.getParameter("oldPasswd");
		String id = request.getParameter("id");
		
		MemberDAO manager = MemberDAO.getInstance();
	
		String checkPasswd = manager.pwCheck(id);
		
		
		if(!oldPasswd.equals(checkPasswd)){
			out.print("<script>");
			out.print("alert('비밀번호가 일치하지않습니다.');");
			out.print("history.go(-1);");
			out.print("</script>");
			out.close();
		}else{ 
			MemberDTO member = new MemberDTO();
			member.setId(id);
			member.setPasswd(request.getParameter("passwd"));
			int result = manager.pwChange(member);
			request.setAttribute("result", result);
		}
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/PasswdChangeForm.do");
		
		return forward;
	}
}
