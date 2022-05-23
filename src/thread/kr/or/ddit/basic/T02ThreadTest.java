package thread.kr.or.ddit.basic;

/**
 * 멀티스레드 프로그램
 * 
 * @author JayAl
 *
 */
public class T02ThreadTest {
	public static void main(String[] args) {
		// 방법1: Thread클래스를 상속한 class의 인스턴스를 생성한 후
		// 이 인스턴스의 start() 메서드를 호출한다.

		MyThread1 th = new MyThread1();
		th.start();

		// 방법2: Runnable 인터페이스를 구현한 클래스의 인스턴스를 생성한 후
		// 이 인스턴스를 Thread 객체의 인스턴스를 생성할 때 생성자의
		// 매개변수로 넘겨준다. 이때 생성된 Thread 객체의 인스턴스
		
		Runnable r = new MyThread2();
		Thread th2 = new Thread(r);
		th2.start();

		// 방법3: 익명 클래스를 이용하는 방법
		// Runnable 인터페이스를 구현한 익명 클래스를 이용하여 쓰레드 객체를 생성한다.
		
		Thread th3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i < 200; i++) {
					System.out.print("@");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		th3.start();
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 1; i < 200; i++) {
			System.out.print("*");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i < 200; i++) {
			System.out.print("$");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}