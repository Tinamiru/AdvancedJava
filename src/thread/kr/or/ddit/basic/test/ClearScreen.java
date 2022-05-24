package thread.kr.or.ddit.basic.test;

class Foo {
	public static void main(String args[]) {

		clearScreen();

	}

	public static void clearScreen() {
		for (int i = 0; i < 80; i++)
			System.out.println("");
	}

}