package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller { // 작명 : command가 find라서 FindController

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
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
	
}