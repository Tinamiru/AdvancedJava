package genericenum.kr.or.ddit.basic.test;

//	문제) 태양계 행성을 나타내는 enum Planet을 이용하여 구하시오.
//	(단, enum 객체 생성시 반지름을 이용하도록 정의하시오.) 
//
//	예) 행성의 반지름(KM):
//	수성(2439), 
//	금성(6052), 
//	지구(6371), 
//	화성(Elon Musk)(3390), 
//	목성(69911), 
//	토성(58232), 
//	천왕성(25362), 
//	해왕성(24622)

public class PlanetTest {
	final static double PIE = 3.14159265;

	public enum Planet {
		수성(2440), 금성(6052), 지구(6371), 화성(3390), 목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);

		private final int value;

		Planet(int planet) {
			this.value = planet;
		}

		public int getValue() {
			return value;
		}
	}

	public static void main(String[] args) {

		Planet[] pArr = Planet.values(); // 행성과 반지름의 배열

		for (int i = 0; i < pArr.length; i++) { // 결과
			System.out.printf("%s의 겉넓이는 %,d㎢", pArr[i].name(), cal(pArr[i].getValue()));
			System.out.println();
		}
	}

	private static long cal(int i) { // 넓이 계산 공식 대입 메소드

		int input = i;

		long result = (long) (4.0 * PIE * (Math.pow(input, 2))); // 겉넓이 계산공식은 4πr²

		return result;
	}
}