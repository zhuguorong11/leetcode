package jdkproxy;

public class ForumServiceImp implements FormInterface {
	public void removeTopic(int topicID) {
		//PerformanceMonitor.begin("jdkproxy.ForumServiceImp.removeTopic");
		System.out.println("ģ��ɾ��topic��¼" + topicID);
		try {
			Thread.currentThread().sleep(4000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		//PerformanceMonitor.end();
	}

	public void removeForum(int forumID) {
		//PerformanceMonitor.begin("jdkproxy.ForumServiceImp.removeForum");
		System.out.println("ģ��ɾ��topic��¼" + forumID);
		try {
			Thread.currentThread().sleep(4000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		//PerformanceMonitor.end();
	}

}
