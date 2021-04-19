package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.BookDAOImpl;

public class ShowAllBookController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		try {
			request.getSession().setAttribute("list", BookDAOImpl.getInstance().showAllBook());
			path = "book/bookList.jsp";
		}catch ( Exception e ) {
			
		}
		
		
		return path;
	}

}
