package servlet.controller;

public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();
	
	private ControllerFactory() {}
	
	public static ControllerFactory getInstance() {
		return factory;
		
	}
	
	// 공장에서 
	// Componenet(자동차) 를 생성 --> command를 받아서 --> 자동차를 만들자!
	
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("login")) {
			controller = new LoginController();
		}else if (command.equals("book")) {
			controller = new BookController();
		}else if (command.equals("logout")) {
			controller = new LogoutController();
		}else if (command.equals("allbook")) {
			controller = new ShowAllBookController();
		}
		
		
		return controller;
	}
	
	
	
	
	

}
