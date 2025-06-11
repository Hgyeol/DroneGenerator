package test.thread;

public class ThreadTest extends Thread {
	
	// start는 스레드를 새로 생성 후 그 스레드에서 run(= 작업)을 수행함
	// run은 스레드를 새로 생성하지 않고 run을 수행한 스레드에서 작업을 수행
	
	public static void main(String[] args) {
		ThreadTest test = new ThreadTest();
		test.start();
		for(int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {
			System.out.println(this.getName() + " : " + i);
		}
	}
}
