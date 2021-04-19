package servlet.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Member;


@WebServlet(
		urlPatterns = { "/MainServlet" }, 
		initParams = { 
				@WebInitParam(name = "path", value = "C:\\encore_ohs\\eclipse\\03_webWorkspace\\Workshop04\\WebContent\\WEB-INF\\member.txt")
		},
		loadOnStartup= 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String path;
	private ServletContext cont;
	private ArrayList<Member> list;
	
	
	@Override
	public void init() throws ServletException {
			System.out.println(" << init() call >>");
			cont = getServletContext();
			
			path = cont.getInitParameter("path");
			BufferedReader br = null;
			InputStream is = null;
			
			try {
				list = new ArrayList<Member>();
				is = cont.getResourceAsStream(path);
				br = new BufferedReader(new InputStreamReader(is));
				String str = null;
				
				while( (str = br.readLine()) != null) {
					String[] temp = str.split(" \\| ");
					list.add(new Member(temp[0], temp[1]));
					
					
				}
				System.out.println(list);
				br.close();
				
			} catch (Exception e) {
				
			}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String dest="<a href ='loginSuccess.jsp'> 로그인 JSP 페이지로 이동합니다.</a>";
		
		
		
		cont.setAttribute("members", new Member(id,password));
		for ( Member user : list) {
			if( ( user.getId().equals(id) ) && (user.getPassword().equals(password))){
				out.println("<a href='error.jsp'> LoginSuccess JSP페이지로 이동합니다.</a>");
				cont.setAttribute("members", null);
				cont.setAttribute("error", "login Error");
				break;
			}
		
		}
		
		out.println(dest);
		}
}


