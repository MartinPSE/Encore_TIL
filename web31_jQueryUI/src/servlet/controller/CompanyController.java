package servlet.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompanyController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("CompanyComponent !! 진입 !!");
		// 비지니스 로직 돌았다 치고
		
		String result ="<ul><li> Tomato System </li><br>"+
				"<li> NCsoft Coporation </li><br>"+
				"<li> KAKAO </li><br>"+
				"<li> Encore System </li><br>"+
				"<li> Jennifr Soft </li><br></ul>";
				
		request.setAttribute("result", result);
		
		
		return new ModelAndView("Result.jsp");
	}

}
