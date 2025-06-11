package test.thread;

public class HelloRunnable implements Runnable{
	
	@Override
	public void run() { // 쓰레드가 수행할 작업을 작성
		System.out.println("hello");
	}

	
	public static void main(String[] args) {
		HelloRunnable runnable = new HelloRunnable();
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
