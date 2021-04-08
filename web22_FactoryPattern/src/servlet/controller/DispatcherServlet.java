package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "*.do", loadOnStartup = 1) // /*.do 로 하면 에러난다 *.do 로 사용해야한다.
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. command 값 받아서
		// 2. 공장한테 command 값 준다...Controller 타입을 반환
		// 3. Controller의 메소드를 호출하면 Component의 메소드가 호출된다(Overriding)...path를 리턴
		// 4. path를 갖고 페이지 이동
		//	String command = request.getParameter("command");
		// 		hidden 값으로 들어온 요청을 받지 않고, 들어온 요청의 전체 주소를 직접 받아온다. 앞부분만잘라서 사용.
		
		String requestURI = request.getRequestURI(); // 전체주소 가져오는 Method --> web22_FactoryPattern/find.do
		System.out.println("RequestURI : " +requestURI);
		
		String contextPath = request.getContextPath(); // web22_FactoryPattern
		System.out.println("contextPath : " + contextPath);
		
		String command = requestURI.substring(contextPath.length()+1); //  /find.do , find.do ?
		System.out.println("command : " + command);
		
		
		

		String path = "index.jsp"; // default : error page || home
		ModelAndView mv = null;
		
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try {
			mv = controller.execute(request, response); // isredirect 가 true 면 --> redirect 로, false는 forward로
			path = mv.getPath();
			
		} catch (Exception e) {
			
		} if (mv!=null) {
			if(mv.isRedirect()) response.sendRedirect(path);
			else request.getRequestDispatcher(path).forward(request, response);

		}
			}
}