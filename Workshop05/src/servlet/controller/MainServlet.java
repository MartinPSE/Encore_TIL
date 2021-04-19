package servlet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.ProductVO;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 필드 추가 하자.. ArrayList, ServletContext.
	
	// 동시에 접근하는 것을 대비해서 --> List에 락을 걸어 놓는다. 
	// 공유자원(공유Data)를 안전하게 관리하기 위해 . 
	List<ProductVO> list = Collections.synchronizedList(new ArrayList<ProductVO>());

	@Override
	public void init() throws ServletException {
		System.out.println("ServletContext Address ::"+getServletContext());
		getServletContext().setAttribute("list",list);
		System.out.println("ServletContext에 상품정보들을 하나씩 저장할 거..List바인딩 OK");
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");
		
		System.out.println("2. 폼값을 바탕으로 VO (pvo) 객체 형성 ");
		ProductVO pvo = new ProductVO(name, price, desc); // VO를 구분하기 위해 field명 설정시에 pvo, rvo 등등 유의하기.
		
		System.out.println("3. list에 client객체 하나하나 저장해주기. ");
		list.add(pvo);
		
		// 페이지 이동
		request.getRequestDispatcher("register.jsp").forward(request, response);
		
		
		
		}

}
