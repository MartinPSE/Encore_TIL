package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SMS")
public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리 안함
		/*
		 * 1. 폼 값 받아서
		 * 2. dao 리턴 받고
		 * 3. 비지니스 로직 호출한 결과로 vo객체 리턴 받고...id로 나머지 정보들 조회
		 * 4. 리턴받은 값을 Attribute에 바인딩
		 * 5. 네비게이션...서버 내에 있는 jsp로 바로 이동
		 */
		String id = request.getParameter("id");
		
		// dao, 비지니스 로직 호출했다 치고
		
		request.setAttribute("id", id);
//		request.setAttribute("password", password);
//		request.setAttribute("name", name);
//		request.setAttribute("address", address);
		
//		request.getRequestDispatcher("result_view.jsp").forward(request, response); // 이동하고자 하는 페이지를 넣으면 그곳으로 이동된다.
		request.getRequestDispatcher("include_test1.jsp").include(request, response); 
		
//		// 이제 필요 없다...서블릿은 응답과 관련 없다
//		PrintWriter out = response.getWriter();
//		out.println("이 부분 보일까요?");
		/*
		 * RequestDispatcher가 갖고있는 forward(req, res), include(req, res) 방식의 페이지 이동 방법
		 * 1. forward
		 *   forward하려는 페이지로 현재 서블릿의 모든 권한을(req, res) 가지고 서버 내에 있는 다른 페이지로 직접 이동
		 *   이동하는 페이지로 제어권이 완전히 가버리기 때문에 다시 이전 서블릿으로 되돌아오지 않는다.
		 *   그렇기 때문에 서블릿에서 응답 관련된 객체 PrintWriter를 사용할 일이 없다...철저하게 로직 중심으로 작성
		 *   
		 *   또 하나, 결과 페이지의 url 주소를 보면,
		 *   결과 페이지인 jsp 주소가 아니라 이전 서블릿 주소로 출력된다.
		 *   모든 권한(req, res)를 가지고 이동했기 때문에 서블릿 이름으로 주소가 명시되어진다.
		 *   
		 * 2. include
		 *   만약에 서블릿의 PrintWriter 객체를 이용하려 한다면 include 방식으로 페이지 이동할 수 있다.
		 *   include에 담겨있는 모든 내용을 가지고 서블릿에 포함되므로 include한 다음에는 다시 서블릿 이후 과정을 마무리 짓고
		 *   서블릿이 직접 응답할 수 있다.
		 *   
		 *   하지만 이렇게 사용되는 경우는 거의 없고 1번처럼 주로 forward를 사용한다.
		 */
	}
	
}