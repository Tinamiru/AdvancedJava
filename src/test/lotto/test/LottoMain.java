package test.lotto.test;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoMain {
	public static void main(String[] args) {

		Lotto l = new Lotto();
		l.menu();

	}
}

class LottoList {
	public void lottoList(int number) {
		Set<Integer> list = new TreeSet<Integer>();

		for (int i = 1; i <= number; i++) {
			while (list.size() < 7) {
				Random random = new Random();
				int num = random.nextInt(45) + 1;
				list.add(num);
			}
			System.out.println("로또번호" + i + " : " + list);
			list.clear();
		}

	}
}
