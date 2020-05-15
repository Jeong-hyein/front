package co.yedam.app.common;

import java.io.IOException;
import java.util.HashMap;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.member.controller.MemberInsert;
import co.yedam.app.member.controller.MemberInsertForm;
import co.yedam.app.member.controller.MemberList;
import co.yedam.app.member.controller.MemberUpdate;
import co.yedam.app.member.controller.MemberUpdateForm;

//@WebServlet("/*.do") //.do로 끝나는 모든게 여기로 올거임, web.xml에서 만들었음
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<String, Controller>();
		//url 요청과 서브컨트롤러 매핑
		list.put("/MemberInsertForm.do", new MemberInsertForm()); //회원등록 폼
		list.put("/MemberInsert.do", 	 new MemberInsert()); //회원정보등록처리
		list.put("/MemberUpdateForm.do", new MemberUpdateForm()); //회원수정 폼
		list.put("/MemberUpdate.do",	 new MemberUpdate()); //회원정보수정처리
		list.put("/MemberList.do", 		 new MemberList());	  //회원목록
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//url 주소를 잘라서 분석 -> 컨트롤러 검색 -> 실행
		String url = request.getRequestURI(); 				// /edu/MemberInsert.do?dddd에서 .do까지 가져옴
		String contextPath = request.getContextPath(); 		//url중에서 edu를 가르킨다.
		String path = url.substring(contextPath.length());  //주소에서 edu제외하고  MemberInsert.do 가져옴
		
		//서브컨트롤러 검색
		Controller subController = list.get(path); 			//list에서 path를 찾는다
		
		if(subController == null) {
			response.getWriter().print("no command.");
			return;
		}
		
		
		
		//로그인 체크, 권한체크(옵션)
		//서브컨트롤러 실행
		String view = subController.execute(request, response);
		
		if(view != null) {
			if(view.startsWith("redirect:")) {
				response.sendRedirect(view.substring(9)); //9번째에서 짜르는거
			} else {
				//뷰페이지로 포워드
				request.getRequestDispatcher(view).forward(request, response);				
			}
		}
		
	}


    
}
