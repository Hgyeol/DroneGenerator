package test.thread;

public class Application2 extends Thread {

	public static void main(String[] args) {
		Application2 application2 = new Application2();
		application2.setDaemon(true);
		application2.start();
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("메인 쓰레 실행 : " + i);
		}
		System.out.println("메인 쓰레드 종료");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("데몬 쓰레드 실행");
		}
	}
}
