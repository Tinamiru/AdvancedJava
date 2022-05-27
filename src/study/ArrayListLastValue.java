package study;

import java.util.ArrayList;
import java.util.List;

public class ArrayListLastValue {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			list.add(i);
		}
		System.out.println("list의 사이즈 : " + list.size());
		System.out.println("값 : " + list.get(list.size() - 1));
	}
}
