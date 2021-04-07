package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

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
		
		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response);;
	}
}