package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Book;
import servlet.model.BookDAOImpl;
import servlet.model.UserDAOImpl;
import servlet.model.UserVO;


@WebServlet("/front.do")
public class MainDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MainDispatcher() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String path = "login.html";
		
		if (command.equals("login")) {
			path = login(request, response);
		}
		else if (command.equals("book")) {
			path = book(request,response);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
				
		
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) {
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
	
	protected String book(HttpServletRequest request, HttpServletResponse response) {
		String path = "book/bookError.jsp";
		String[] bookNoList = request.getParameterValues("bookNo");
		String isbn = "";
		HttpSession session = request.getSession();
		for(int i=0; i<bookNoList.length; i++) {
			if(i==bookNoList.length-1) {
				isbn += bookNoList[i];
			} else {
				isbn += bookNoList[i] + "-";
			}
		}
		String title = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publish_date = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price = Integer.parseInt(request.getParameter("bookPrice"));
		String description = request.getParameter("bookSummary");
		
		Book bo = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price, description);
		try {
			BookDAOImpl.getInstance().registerBook(bo);			
			session.setAttribute("bo", bo);
			path = "book/bookSuccess.jsp";
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return path;
				
		
	}

}
