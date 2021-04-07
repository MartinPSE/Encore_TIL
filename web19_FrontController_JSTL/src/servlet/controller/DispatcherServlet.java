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

@WebServlet(urlPatterns = "/front.do", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
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
		String path = "index.html"; // default : error page || home
		
		if (command.equals("register")) { // 회원가입
			// 1. RegisterServlet의 doProcess() 안에 있는 코드를 여기에 작성...가독성이 떨어지는 방법
			// 2. method로 하나 뽑아내서 그 메소드에 RegisterServlet의 doProcess() 안에 있는 코드를 작성..이 방법으로
			path = register(request, response);
		} else if (command.equals("find")) { // 회원검색
			path = find(request, response);
		} else if (command.equals("login")) { // 로그인
			path = login(request, response);
		} else if (command.equals("allmember")) { // 모든회원
			path = allmember(request, response);
		} else if (command.equals("logout")) { // 로그아웃
			path = logout(request, response);
		} else if (command.equals("update")) { // 회원정보수정
			path = update(request, response);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	protected String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			path = "register_result.jsp";
		} catch(SQLException e) {
			
		}
		
		return path;
	}
	
	protected String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "find_fail.jsp"; // 보수적으로 안 된 경우를 초기화
		
		String id = request.getParameter("id");
		
		try {
			MemberVO rvo = MemberDAOImpl.getInstance().findByIdMember(id);
			
			if (rvo != null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
		} catch(SQLException e) {
			
		}
		
		return path;
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		try {
			MemberVO rvo = MemberDAOImpl.getInstance().login(id, password);

			HttpSession session = request.getSession();
			if (rvo != null) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID : " + session.getId());
				
				path = "login_result.jsp";
			}
		} catch(SQLException e) {
			
		}
		
		return path;
	}
	
	protected String allmember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		try {
			ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			
			path = "allView.jsp";
		} catch(SQLException e) {
			
		}
		
		return path;
	}
	
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		
		HttpSession session = request.getSession();
		if (session.getAttribute("vo") != null) {
			session.invalidate();
			path = "logout.jsp";
		}
		
		return path;
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		try {
			MemberDAOImpl.getInstance().updateMember(pvo);
			
			HttpSession session = request.getSession();
			if (session.getAttribute("vo") != null) {
				session.setAttribute("vo", pvo);
				
				path = "update_result.jsp";
			}
		} catch(SQLException e) {
			
		}
		
		return path;
	}
	
}