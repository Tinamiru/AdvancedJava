package genericenum.kr.or.ddit.basic;

import java.sql.Array;
import java.util.*;

public class WildCardExam {
	public static void main(String[] args) {
		Mem3 wc = new Mem3(null, 0);

		List<?> memList = new ArrayList<>();
	}

	public void printmemberInfo(List<? extends Mem3> list) {

//		extends 키워드를 이용한 상한 제한(Upper Bounds) 예제
//		list 안의 객체는 반드시 Member 타입의 객체임을 보장 할 수 있다.

		for (Mem1 mem : list) {// mem 클래스의 상위 클래스만 가능
			System.out.println(mem);
		}
		for (Mem2 mem : list) {// mem 클래스의 상위 클래스만 가능
			System.out.println(mem);
		}
		for (Mem3 mem : list) {// mem 클래스의 상위 클래스만 가능
			System.out.println(mem);
		}
//		for (Mem4 mem : list) {
//			System.out.println(mem);
//		}
//		for (Mem5 mem : list) {
//			System.out.println(mem);
//		}
	}

	public void printmemberInfo2(Mem3<? super List> list) {

//		super 키워드를 이용한 하한 제한(Lower Bounds)
//		member 타입의 변수를 이용하여 List로부터 객체를 꺼내올 수 없다.
//		for (Mem1 mem : list) {
//			System.out.println(mem);
//		}
//		for (Mem2 mem : list) {
//			System.out.println(mem);
//		}
//		for (Mem3 mem : list) {
//			System.out.println(mem);
//		}
//		for (Mem4 mem : list) {
//			System.out.println(mem);
//		}
//		for (Mem5 mem : list) {
//			System.out.println(mem);
//		}
	}

	public void registerMemberInfo(Mem3<? extends Mem3> list) {

//		Member 타입의 객체라고 항상 list에 추가할 수 있음을 보장할 수 없다.
//		(Member타입 또는 Member를 상속한 그 어떤 타입을 의미
//				하므로 아직 구체적인 타입이 정해지지 않았다. => 컴파일 에러 발생)

		Mem1 m1 = new Mem1("홍길동", 33);
		Mem2 m2 = new Mem2("홍길동", 33);
		Mem3 m3 = new Mem3("홍길동", 33);
		Mem4 m4 = new Mem4("홍길동", 33);
		Mem5 m5 = new Mem5("홍길동", 33);
		list.add1(m1);
		list.add2(m2);
		list.add3(m3);
//		list.add4(m4);
//		list.add5(m5);
	}

	public void registerMemberInfo2(List<? super Mem3> list) {

//		super 키워드를 이용한 하한 제한 (Lower Bound) 예제
//		list는 Member타입의 객체를 포함한다는 것을 보장할 수 있다.
//		=> Member타입 또는 Member타입의 슈퍼타입을 담은 리스트를 의미하기 떄문에..

		Mem1 m1 = new Mem1("홍길동", 33);
		Mem2 m2 = new Mem2("홍길동", 33);
		Mem3 m3 = new Mem3("홍길동", 33);
		Mem4 m4 = new Mem4("홍길동", 33);
		Mem5 m5 = new Mem5("홍길동", 33);
//		list.add(m1);
//		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
	}
}

class Mem5<T> extends Mem4 {

	public Mem5(String name, int age) {
		super(name, age);
	}

	public void add5(Mem5 a) {
	}

}

class Mem4<T> extends Mem3 {

	public Mem4(String name, int age) {
		super(name, age);
	}

	public void add4(Mem4 a) {
	}

}

class Mem3<T> extends Mem2 {

	public Mem3(String name, int age) {
		super(name, age);
	}

	public void add(Mem3 m3) {

	}

	public void add3(Mem3 a) {
	}
}

class Mem2<T> extends Mem1 {

	public Mem2(String name, int age) {
		super(name, age);
	}

	public void add2(Mem2 m2) {
	}
}

class Mem1<T> {
	private String name;
	private int age;

	public Mem1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void add1(Mem1 a) {
	}

	public int method(Mem1 a) {
		return 0;
	}

}