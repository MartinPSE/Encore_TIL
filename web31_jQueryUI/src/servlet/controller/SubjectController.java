package servlet.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("SubjectComponent... 진입...");
		// 비지니스 로직... 엔코아 주요 과목.. 이수과목을 DB에서 꺼내온다.
		
		String result = "Big Data | Maching Learning | DeepLearning | Python | Restful API Service | Vue CLI";
		
		request.setAttribute("result", result);
		
		
		
		
		return new ModelAndView("Result.jsp"); // forwarding 방식으로 이동.
	}

}
