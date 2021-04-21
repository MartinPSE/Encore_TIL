package com.encore.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.Item;
import com.encore.model.ItemDao;

public class itemListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		// 브라우저의 모든 쿠키 정보를 받아오는 로직을 작성 //
		/* 1) Cookie[] cookies = request.getCookies(); 
		   2) 그 중에서 내가 원하는 쿠키 정보를 뽑아서 바인딩
		   3) 
		 
		  
		 */
		ArrayList<String> fruits = new ArrayList<String>();
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie c : cookies) {
				if(c.getName().startsWith("fruitshop")) {
					fruits.add(c.getValue()); // 해당 삼품의 이미지들 추가.
				} //
			} // for
			
		} // if
		
		request.setAttribute("fruits", fruits); // 2. 
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		ArrayList<Item> item;
		item = ItemDao.getInstance().getAllItem();
		request.setAttribute("item", item);
			
			
		
		
		
		return new ModelAndView("resultView.jsp");
	}

}
