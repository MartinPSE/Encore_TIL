package com.encore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String command = request.getParameter("command");
		System.out.println("Command : " + command);
		if (command.equals("wordCount")) {
			wordCount(request,response);
			
		}else if(command.equals("kickCount")) {
			kickCount(request,response);
		}
	} // doProcess

	private void kickCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname= request.getParameter("fname");
		// contextpath !! 가져오자고!
		String path = request.getServletContext().getRealPath("/res");	
		System.out.println("path : " +path);
		
		File file = new File(path,fname);
		
		int count = new Kickboard().execute(file);
		request.setAttribute("result", count);
		request.getRequestDispatcher("Result.jsp").forward(request, response);
		
	}

	// 해당 module 안에서만 사용되고 다른 module에서는 불려지는 일이 없을때, 함수 앞에 private을 붙인다.
	private void wordCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String words = request.getParameter("words");
		// Count 클래스 객체 생성후 -> 알고리즘 자바 클래스의 execute 함수를 호출하자. 
		// count.java 에게 줘야해.
		
		String result = new Count().execute(words);
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("Result.jsp").forward(request, response);
		
		
	}


}
