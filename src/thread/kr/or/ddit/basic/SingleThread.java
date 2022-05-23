package thread.kr.or.ddit.basic;

public class SingleThread {
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		System.out.println("startTime: " + startTime);

		long sum = 0L;
		for (long i = 1L; i <= 2000000000L; i++) {
			sum += i;
		}
		long endTime = System.currentTimeMillis();

		System.out.println("endTime: " + endTime);
		System.out.println("단독으로 처리할 때의 처리시간: " + (endTime - startTime) + "(ms)");
	}
}
