package collectionframework.kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class T01ArrayListTest {
	public static void main(String[] args) {

//		List list1 = new ArrayList();
//		List list1 = new LinkedList();
		List list1 = new Vector(); // 상위 인터페이스 사용에 의해 수정없이 사용 가능.

		// add()메서드를 사용해서 데이터를 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);
		list1.add('k');
		list1.add(true);
		list1.add(12.34);

//		// size() => 데이터의 객수
//		System.out.println("size => " + list1.size());
//
//		// get()으로 데이터 꺼내오기. 인덱스 기입 필수
//		System.out.println("1번째 자료 : " + list1.get(0));
//
		// 데이터 끼워넣기도 같다.
		list1.add(0, "zzz");
		System.out.println("list1 => " + list1);

		// 데이터변경하기(set메서드)
		String temp = (String) list1.set(0, "yyy");
		System.out.println("temp => " + temp);
		System.out.println("list1 => " + list1);

		temp = (String) list1.set(1, "ooo");
		System.out.println("list1 => " + list1);
		System.out.println(temp);

//		// 삭제하기도 같다.
//		list1.remove(0);
//		System.out.println("삭제 후 : " + list1);
//
//		list1.remove("bbb");
//		System.out.println("bbb 삭제 후 : " + list1);
//
//		list1.remove(new Integer(111)); // 객체화된 정수를 생성하여야 한다. 아니면 인덱스값 111이 기입된다.
//		System.out.println("111 삭제 후 : " + list1);
//
//		System.out.println("================================");
//
//		// 제너릭을 지정하여 선언 할 수 있다.
//		List<String> list2 = new ArrayList<String>();
//		list2.add("AAA");
//		list2.add("BBB");
//		list2.add("CCC");
//		list2.add("DDD");
//		list2.add("EEE");
//
//		for (int i = 0; i < list2.size(); i++) {
//			System.out.println(i + " : " + list2.get(i));
//		}
//		System.out.println("--------------------------------");
//
//		// 리스트에서 사용할 수 있는 몇몇 유용한 메서드.
//
//		// contains(비교객체); => 리스트에 '비교객체'가 있으면 true
//		// 그렇지 않으면 false가 반환됨.
//		System.out.println(list2.contains("DDD"));
//		System.out.println(list2.contains("ZZZ"));
//
//		// indexOf(비교객체); => 리스트에서 '비교객체'를 찾아 '비교객체'가
//		// 존재하는 index값을 반환한다.
//		// 리스트에 존재하지않으면 -1을 반환한다.
//		System.out.println("DDD의 index값 : " + list2.indexOf("DDD"));
//		System.out.println("ZZZ의 index값 : " + list2.indexOf("ZZZ"));
//		System.out.println("-------------------------------------");
//
//		// toArray() => 리스트안의 데이터들을 배열로 변환하여 반환한다.
//		// => 기본적으로 Object형 배열로 반환한다.
//		Object[] strArr = list2.toArray();
//		String[] strArr1 = list2.toArray(new String[0]);
//		System.out.println("배열의 갯수 : " + strArr.length);
//		System.out.println("배열의 갯수 : " + strArr1.length);
//
//		for (int i = 0; i < list2.size(); i++) {
//			list2.remove(i);
//		}
//		System.out.println("list2의 크기 : " + list2.size());
//
//		// C= .add()
//		// R= .get()
//		// U = .set()
//		// D = .remove()

	}
}
