package pattern.action;

public class UpdateController implements Controller {

	@Override
	public String requestHandle() {
		System.out.println("UpdateController...register logic...");
		/*
		 * 1. 폼 값 받아서
		 * 2. VO 객체 생성
		 * 3. DAO리턴받아서
		 * 4. 비지니스 로직 호출
		 * 5. 바인딩
		 * 6. PATH리턴
		 */
		return "update_result.jsp";
	}

}