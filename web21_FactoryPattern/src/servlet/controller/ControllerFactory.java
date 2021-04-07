package servlet.controller;

public class ControllerFactory {
	
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {}
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	// command에 따라서 Component를 생성하는 기능...factory 본연의 역할
	public Controller createController(String command) {
		Controller controller = null;
		
		if (command.equals("find")) {
			controller = new FindController();
		} else if (command.equals("register")) { // 없지만 예를 들어...
			
		} // else if ...
		
		return controller;
	}
	
}
