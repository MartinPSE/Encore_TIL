package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.UserDAOImpl;
import servlet.model.UserVO;


// Component를 만들어야지!

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "error.jsp";
		String userId = request.getParameter("userId");
		String password = request.getParameter("userPass");
		
		try {
			UserVO vo = UserDAOImpl.getInstance().login(userId, password);
			HttpSession session = request.getSession();
			
			if(vo!=null) {
				session.setAttribute("vo", vo);
				path = "loginSucess.jsp";
			} else {
				path = "error.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		return path;
				
		
	}

}
