package thread.kr.or.ddit.basic;

/**
 * 싱글스레드 프로그램
 * @author JayAl
 *
 */
public class T01ThreadTest {
	public static void main(String[] args) {
		for (int i = 1; i < 200; i++) {
			System.out.print("*");
		}
		for (int i = 1; i < 200; i++) {
			System.out.print("$");
		}
	}
}
