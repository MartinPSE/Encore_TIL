package com.encore.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.Item;
import com.encore.model.ItemDao;

public class itemViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int itemid = Integer.parseInt(request.getParameter("itemnumber"));
		
		// 조회수 증가 !
		boolean result = ItemDao.getInstance().updateRecordCount(itemid);
		System.out.println("Count check  :: " + result);
		
		Item item = ItemDao.getInstance().getItem(itemid);
		System.out.println("Item : " +item);
		
		/* 오늘 본 상품정보를 Cookie에 저장하는 로직을 추가 !! 
		 1. 쿠키 생성 ("key", "value") 둘다 String으로 저장.
		  	= Cookie( "key" , "value" )
		  			   고유값    ,  보여지는 값 
		 2. 쿠키 저장 시간을 (60*24*24) 24시간으로 지정.
			= setMaxAge()
		 3. 정보가 저장된 쿠키를 Client로 보낸다.
		*/ 
	
		// String + nonString == String 
		// Technic 이용 
		// Server를 구분할 수 있는 key값을 적어준다.
		Cookie cookie = new Cookie("fruitshop"+itemid, item.getUrl()); // 1.
		cookie.setMaxAge(24*60*60); // 2.
		response.addCookie(cookie); // 3. 
		
		
		
		request.setAttribute("item", item);
		return new ModelAndView("itemView.jsp");
	}

}
