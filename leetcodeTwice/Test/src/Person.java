
public class Person {
	public int x;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		int number = []{1,2,3};
		Thread t=new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("2");
            }
        });
        t.start();
         
        t.join();
        System.out.print("1");
	}

}
