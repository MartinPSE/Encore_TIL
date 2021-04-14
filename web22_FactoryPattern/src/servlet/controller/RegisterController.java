package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "";	
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			path = "register_result.jsp";
			
		}catch (Exception e) {
			
			
		}
		
		
		
		
		
		return new ModelAndView(path);
		
	}
	

}
