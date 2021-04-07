package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet(urlPatterns = "/front.do2", loadOnStartup = 1)
public class DispatcherServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 가장 먼저 클라이언트로부터 어떤 요청이 들어온지를 알아야 한다...command 값 받아온다.
		String command = request.getParameter("command");
		
		if (command.equals("register")) { // 회원가입
			// 1. RegisterServlet의 doProcess() 안에 있는 코드를 여기에 작성...가독성이 떨어지는 방법
			// 2. method로 하나 뽑아내서 그 메소드에 RegisterServlet의 doProcess() 안에 있는 코드를 작성..이 방법으로
			register(request, response);
		} else if (command.equals("find")) { // 회원검색
			find(request, response);
		} else if (command.equals("login")) { // 로그인
			login(request, response);
		} else if (command.equals("allmember")) { // 모든회원
			allmember(request, response);
		}
	}
	
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// AllMember로 안 가고 register_result.jsp로 가게
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			
//			response.sendRedirect("AllMember?name=" + name);
			request.getRequestDispatcher("register_result.jsp").forward(request, response);
		} catch(SQLException e) {
			
		}
	}
	
	protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp"; // 보수적으로 안 된 경우를 초기화
		
		try {
			MemberVO rvo = MemberDAOImpl.getInstance().findByIdMember(id);
			
			if (rvo != null) { // SELECT 결과가 있을 때...이 때 path 성공시로 바꿈
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
		} catch(SQLException e) {
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);;
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		try {
			MemberVO rvo = MemberDAOImpl.getInstance().login(id, password);

			// 세션에 저장해야 로그인 동안 인증을 계속 유지할 수 있다.
			HttpSession session = request.getSession();
			if (rvo != null) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID : " + session.getId());
				
				request.getRequestDispatcher("login_result.jsp").forward(request, response);
			}
		} catch(SQLException e) {
			
		}
	}
	
	protected void allmember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("allView.jsp").forward(request, response);
		} catch(SQLException e) {
			
		}
	}
	
}