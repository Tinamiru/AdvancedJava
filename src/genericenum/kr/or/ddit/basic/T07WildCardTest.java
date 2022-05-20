package genericenum.kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T07WildCardTest {

	public void printmemberInfo(List<? extends Member> list) {

//		extends 키워드를 이용한 상한 제한(Upper Bounds) 예제
//		list 안의 객체는 반드시 Member 타입의 객체임을 보장 할 수 있다.

		for (Member mem : list) {
			System.out.println(mem);
		}
	}

	public void printmemberInfo2(List<? super Member> list) {

//		super 키워드를 이용한 하한 제한(Lower Bounds)
//		member 타입의 변수를 이용하여 List로부터 객체를 꺼내올 수 없다.
		for (Member obj : list) { // 컴파일 에러 발생
			System.out.println(obj);
		}
	}

	public void registerMemberInfo(List<? extends Member> list) {

//		Member 타입의 객체라고 항상 list에 추가할 수 있음을 보장할 수 없다.
//		(Member타입 또는 Member를 상속한 그 어떤 타입을 의미
//				하므로 아직 구체적인 타입이 정해지지 않았다. => 컴파일 에러 발생)

		Member m = new Member("홍길동", 33);
		list.add(m); // 등록불가
	}

	public void registerMemberInfo2(List<? super Member> list) {

//		super 키워드를 이용한 하한 제한 (Lower Bound) 예제
//		list는 Member타입의 객체를 포함한다는 것을 보장할 수 있다.
//		=> Member타입 또는 Member타입의 슈퍼타입을 담은 리스트를 의미하기 떄문에..

		Member m = new Member("홍길동", 33);
		list.add(m);
	}

	public static void main(String[] args) {
		T07WildCardTest wc = new T07WildCardTest();

		List<Member> memList = new ArrayList<Member>();

		wc.registerMemberInfo2(memList);
		wc.printmemberInfo(memList);

	}
}

class Member {
	private String name;
	private int age;

	/**
	 * @param name
	 * @param age
	 */
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("Member [name=%s, age=%s]", name, age);
	}
}