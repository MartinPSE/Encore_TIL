package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/RMS")
public class RegisterMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼 값 받아서
		 * 2. pvo 생성
		 * 3. DAO 리턴 받아서
		 * 4. 비지니스 로직 호출
		 * 5. 결과 값...바인딩(Attribute 잘 선택)
		 * 6. 네비게이션
		 * --> Controller 역할
		 */
		// 1.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		// 2.
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		// 3~6...5는 생략
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			
//			request.getRequestDispatcher("AllMember").forward(request, response); // forward?
			response.sendRedirect("AllMember"); // redirect? 이게 더 적합하다
		} catch(SQLException e) {
			
		}
	}
}