package test.thread;

public class HelloThread extends Thread{
	
	@Override
	public void run() { // 쓰레드가 수행할 작업을 작성
		System.out.println("hello");
	}
	
	public static void main(String[] args) {
		HelloThread thread = new HelloThread();
		thread.start();
	}
}
