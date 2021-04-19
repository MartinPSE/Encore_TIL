package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

// Component ! 만들기

public class BookController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

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
