package test.thread;

public class Application extends Thread {
	
	public static void main(String[] args) {
		Application application = new Application();
		application.setDaemon(true); // 데몬 쓰레드 설정 
		application.start();
		
		// 쓰레드 start 후 데몬 쓰레드 설정을 하면 IllegalThreadStateException이 발생할 수 있음 
	}
	
	@Override
	public void run() {
		if(Thread.currentThread().isDaemon()) { // 데몬 쓰레드인지 확
			System.out.println("데몬 쓰레드 입니다.");
		}
		else {
			System.out.println("사용자 쓰레드 입니다.");
		}
	}
}
