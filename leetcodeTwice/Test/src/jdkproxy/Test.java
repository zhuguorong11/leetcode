package jdkproxy;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FormInterface service = new ForumServiceImp();
		service.removeForum(10);
		service.removeTopic(12);
	}

}
