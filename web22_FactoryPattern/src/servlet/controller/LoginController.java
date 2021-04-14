package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LoginController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		String path = "";
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		try {
			MemberVO rvo = MemberDAOImpl.getInstance().login(id, password);
			if ( rvo != null ) {
				request.setAttribute("vo", rvo);
				path = "login_result.jsp";
				
			}else {
				path = "loginError.jsp";
			}
			
		}catch(SQLException e) {
			
		}
	
		
		
		return new ModelAndView(path);
	}
	

}
