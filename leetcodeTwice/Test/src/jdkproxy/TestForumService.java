package jdkproxy;

import java.lang.reflect.Proxy;

public class TestForumService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FormInterface forumService = new ForumServiceImp();// 希望代理的业务目标对象
		PerformamceHandler performamceHandler = new PerformamceHandler(forumService);
		FormInterface serviceImpProxy = (ForumServiceImp) Proxy.newProxyInstance(
				forumService.getClass().getClassLoader(), forumService.getClass().getInterfaces(), performamceHandler);
		serviceImpProxy.removeForum(10);
		serviceImpProxy.removeTopic(123);
	}
}
