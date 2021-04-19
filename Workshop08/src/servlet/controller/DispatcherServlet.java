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
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DispatcherServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Command 값 받자
		String command = request.getParameter("command");
		String path = "login.html";
		
		// 2. 공장한테 주자고 --> 맞는 차를 만들어야지
		Controller controller = ControllerFactory.getInstance().createController(command);
		
		// 3. 받은 응답을 --> Controller에게 보내서 차 만들기
		try {
			path = controller.execute(request, response);
		}catch ( Exception e ) {
			
		}
		
		// 4. 그리고 이제 페이지 이동
		request.getRequestDispatcher(path).forward(request, response);
		
		
				
		
	}

}
