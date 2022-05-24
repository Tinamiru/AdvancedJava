package thread.kr.or.ddit.basic;

import java.util.*;

public class Solution {
	public static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		
		// 작성
		
		return answer;
	}

	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };

		int k = 2;

		for (int i : solution(id_list, report, k)) {
			System.out.println(i + " ");
		}
	}
}