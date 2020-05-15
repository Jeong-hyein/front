package co.yedam.app.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.common.Controller;
import co.yedam.app.member.model.MemberService;
import co.yedam.app.member.model.MemberVO;

public class MemberList implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 파라미터 생략
		//2,3. 서비스 로직 처리(memberService..), 결과 저장(request에 set)
		//ArrayList<MemberVO> list = MemberService.getInstance().getMemberList(); //memberservice에서 memberlist결과 조회
		request.setAttribute("list", 
									MemberService.getInstance().getMemberList());
		//4. 뷰페이지로 이동
		return "/member/memberList.jsp";
	}

}
