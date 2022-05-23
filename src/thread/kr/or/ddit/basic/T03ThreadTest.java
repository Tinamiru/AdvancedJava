package thread.kr.or.ddit.basic;

/**
 * 스레드의 수행시간 계산하기
 * 
 * @author JayAl
 *
 */
public class T03ThreadTest {

	public static void main(String[] args) {

		Runnable r = new MyRunner();

		Thread th = new Thread(r);

		// UTC(Universal Time Coordinated 협정 세계 표준시) 를 사용하여
		// 1970년 1월 1일 0시 0분 0초를 기준으로 경과한 시간을
		// 밀리세컨드 단위로 나타낸다

		long startTime = System.currentTimeMillis();
		System.out.println("startTime: " + startTime);

		th.start();

		try {
			th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();

		System.out.println("endTime: " + endTime);
		System.out.println("경과 시간: " + (endTime - startTime));
	}
}

// 1~1000000000까지의 합계를 구하는 스레드
class MyRunner implements Runnable {
	@Override
	public void run() {
		long sum = 0;
		for (long i = 1; i < 100000000000L; i++) {
			sum += i;
		}
		System.out.println("합계: " + sum);
	}

}
