package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;
/*
 * 
 *  ArrayList list = DAO의 모든 ID를 값에 리스트를 가져와야해 ... getIdList();
 *  Attribute에 list라는 이름으로 바인딩.		 
 *  path = show_idList.jsp
 *  
 */

public class IdListController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("list", MemberDAOImpl.getInstance().getIdList());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return new ModelAndView("show_idList.jsp");
	}
}
