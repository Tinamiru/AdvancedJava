package collectionframework.kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T04ListSortTest {
	public static void main(String[] args) {
		List<Member> memList = new ArrayList<Member>();

		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "변학도", "010-2222-1111"));
		memList.add(new Member(9, "성춘향", "010-3333-1111"));
		memList.add(new Member(3, "이순신", "010-4444-1111"));
		memList.add(new Member(6, "강감찬", "010-5555-1111"));
		memList.add(new Member(2, "일지매", "010-6666-1111"));

		System.out.println("정렬 전 : ");
		for (Member member : memList) {
			System.out.println(member);
		}
		System.out.println("--------------------------");

		Collections.sort(memList); // 정렬하기

		System.out.println("정렬 후(이름의 오름차순) : ");
		for (Member member : memList) {
			System.out.println(member);
		}
		System.out.println("--------------------------");

		Collections.sort(memList, new SortNumDesc());

		System.out.println("정렬 후(번호의 내림차순) : ");
		for (Member member : memList) {
			System.out.println(member);
		}
	}
}

/**
 * 외부정렬자 클래스
 * <p>
 * (Member의 번호(Num)의 내림차순으로 정렬하기
 * 
 * @author 재린!
 *
 */

class SortNumDesc implements Comparator<Member> {

	@Override
	public int compare(Member mem1, Member mem2) {

//		if (mem1.getNum() > mem2.getNum()) {
//			return -1;
//		} else if (mem1.getNum() < mem2.getNum()) {
//			return 1;
//		} else {
//			return 0;
//		}

//		return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * -1;

		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
	}

}

/**
 * 회원의 정보를 저장할 클래스
 * <p>
 * (회원이름을 기준으로 오름차순 정렬이 될 수 있는 클래스 생성하기)
 * 
 * @author 재린!
 *
 */
class Member implements Comparable<Member> {
	private int num; // 번호
	private String name;// 이름
	private String tel; // 전화번호

	public Member(int num, String name, String tel) {
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public int compareTo(Member mem) {

		return this.getName().compareTo(mem.getName()) * 1;
	}

	@Override
	public String toString() {
		return String.format("Member = 번호: %s, 이름: %s, 전화번호: %s", num, name, tel);
	}

}