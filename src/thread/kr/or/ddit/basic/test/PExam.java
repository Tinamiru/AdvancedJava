package thread.kr.or.ddit.basic.test;

public class PExam {
	public static void main(String[] args) {
		People p = new Student("기민혁", "1234", 1);

		System.out.println(p.getName());
		System.out.println(p.getSnn());

	}
}