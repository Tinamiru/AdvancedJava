package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import oracle.net.aso.p;

public class T07EqualsHashCodeTest {
	/*
	 * 해시함수(hash function)는 임이의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수이다.
	 * 
	 * 해시함수에 의해 얻어지는 값은 해시값, 해시코드, 해시체크섬 또는 간단하게 해시라고 한다.
	 * 
	 * HashSet, HashMap, Hashtable과 같은지를 비교하기 위해 equals()메서드와 hashCode()메서드를 호출한다.
	 * 그래서 객체가 서로 같은지 여부를 결정하려면 두 메서드를 재정의 해야 한다.
	 * 
	 * 객체가 같은지 여부는 데이터를 추가할때 검사한다.
	 */

//	- equals()메서드는 두 객체의 내용(값)이 같은지 비교하기위한 메서드이고,
//	  hashCode()메서드는 객체에 대한 해시코드 값을 반환하는 메서드다.

//	 - equals()메서드와 hashCode()메서드에 관련된 규칙
//	 1. 두 객체가 같으면 반드시 같은 hashcode를 가져야 한다.
//	 2. 두 객체가 같으면 equals()를 호출했을때 true를 반환해야 한다.
//	    즉, 객체 a, b 가 같다면 a.equals(b)와 b.equals(a) 둘다 true이여야 한다.
//	 3. 두 객체의 hashCode가 같다고 해서 두 객체가 반드시 같은 객체는 아니다.
//	    하지만, 두 객체가 같으면 반드시 hashCode가 같아야한다.
//	 4. equals() 메소드를 override하면 반드시 hashCode()도 override해야한다.
//	 5. hashCode()는 기본적으로 Heap메모리에 있는 각 객체에 대한
//	    메모리 주소 맵핑 정보를 기반으로 한 정수값을 반환한다.
//	    그러므로, 클래스에서 hashCode()메서드를 override하지 않으면
//	    절대로 두 객체가 같은것으로 간주 될 수 없다.
	public static void main(String[] args) {
		// 1.
		Object obj = new Object();
		System.out.println(obj.hashCode() + " : " + obj.hashCode());

		// 2.
		String str1 = "안녕하세요.";
		String str2 = "안녕하세요.";
		System.out.println(str1.equals(str2) + " : " + str2.equals(str1));

		System.out.println(str1.hashCode() + " : " + str2.hashCode());

		// 3.
		System.out.println("Aa".hashCode() + " : " + "BB".hashCode());

		Person p1 = new Person(1, "홍길동");
		Person p2 = new Person(1, "홍길동");
		Person p3 = new Person(1, "이순신");

		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		System.out.println("p1 == p2 : " + (p1 == p2));

		Set<Person> set = new HashSet<Person>();
		set.add(p1);
		set.add(p2);

		System.out.println("p1, p2 등록 후 데이터 : ");
		for (Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}

		System.out.println("add(p3) 성공여부 : " + set.add(p3));
		System.out.println("add(p3) 후 데이터 : ");
		for (Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}

		System.out.println("remove(p2) 성공여부 : " + set.remove(p2));
		System.out.println("remove(p2) 후 데이터 : ");
		for (Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}
	}
}

class Person {
	private int id;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Override
//	public int hashCode() {
//		
//		return super.hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//
//		Person p = (Person) obj;
//
//		return this.id == p.getId() && this.getName().equals(p.getName());
//	}

}