package thread.kr.or.ddit.basic.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HorseRacing {

//	10마리의 말들이 경주하는 경마 프로그램 작성하기
//
//	말은 Horse라는 이름의 클래스로 구성하고,
//	이 클래스는 말이름(String), 등수(int)를 멤버변수로 갖는다.
//	그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
//	기능이 있다.( Comparable 인터페이스 구현)
//
//	경기 구간은 1~50구간으로 되어 있다.
//
//	경기 중 중간중간에 각 말들의 위치를 >로 나타내시오.
//	예)
//	1번말 --->------------------------------------
//	2번말 ----->----------------------------------
//	...
//
//	경기가 끝나면 등수를 기준으로 정렬하여 출력한다.

	public static void main(String[] args) throws InterruptedException {

		Trigger trigger = new Trigger();
		Thread raceT = new RaceCountDown(trigger);

		Horse[] h = new Horse[] { new Horse("샘쑹          :", trigger), new Horse("에아뽀으      :", trigger),
				new Horse("모어쌍        :", trigger), new Horse("오링지        :", trigger),
				new Horse("이상해씨      :", trigger), new Horse("조랑말        :", trigger),
				new Horse("호놀룰루      :", trigger), new Horse("라이라이차차차:", trigger), new Horse("돼지왕        :", trigger),
				new Horse("명륜진사갈비  :", trigger) };

		for (int i = 0; i < h.length; i++) {
			h[i].setPriority(i + 1);
		}

		System.out.println("경주를 준비합니다.");
//		Thread.sleep(3000);
		System.out.print("경주마 입장중");

//		for (int i = 0; i < 30; i++) {
//			Thread.sleep(200);
//			System.out.print(".");
//
//		}
		System.out.println();
		System.out.println("===============================================");
		int i = 1;
		for (Horse horse : h) {
			System.out.print(i + "번 레인 : ");
//			Thread.sleep(1000);
			System.out.print(horse.getHorse());
//			Thread.sleep(1000);
			System.out.println();
			i++;
		}

		System.out.println("준비.");
//		Thread.sleep(1500);
		raceT.start();
		for (Thread th : h) {
			th.start();
		}
		for (Thread th : h) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class RaceCountDown extends Thread {

	private Trigger trigger;

	public RaceCountDown(Trigger trigger) {
		this.trigger = trigger;
	}

	public void run() {
		try {
			for (int i = 3; i > 0; i--) {
				for (int j = 0; j < 20; j++) {
					System.out.println();
				}
				System.out.println(i);
				try {
					Thread.sleep(1100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int j = 0; j < 20; j++) {
					System.out.println();
				}
			}
			System.out.print("경");
			Thread.sleep(200);
			System.out.print("주");
			Thread.sleep(200);
			System.out.print("!");
			Thread.sleep(1500);
			for (int j = 0; j < 20; j++) {
				System.out.println();
			}
			System.out.print("시");
			Thread.sleep(150);
			System.out.print("작");
			Thread.sleep(150);
			System.out.print("합");
			Thread.sleep(150);
			System.out.print("니");
			Thread.sleep(150);
			System.out.print("다");
			Thread.sleep(150);
			System.out.print("!");
			Thread.sleep(2200);
			for (int j = 0; j < 20; j++) {
				System.out.println();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		trigger.horseStart = true;
	}

}

class Horse extends Thread implements Comparable<Horse> {
	private Trigger trigger;

	private String horse;
	private int rank;

	public Horse() {
	}

	public Horse(String string, Trigger trigger) {
		this.horse = string;
		this.trigger = trigger;
	}

	public String getHorse() {
		return horse;
	}

	public void setHorse(String horse) {
		this.horse = horse;
	}

	@Override
	public int compareTo(Horse o) {
		return Integer.compare(this.rank, o.rank);
	}

	///////////////////////// 생성자, 필드/////////////////////////////

	public void run() {
		while (true) {
			if (trigger.horseStart) {
				try {
					Random r = new Random();
					Map<String, ArrayList<String>> map = new HashMap();
					ArrayList<String> arrList = new ArrayList<>();
					arrList.add(">");
					
					for (int i = 1; i < 50; i++) {
						arrList.add("-");
					}
					
					map.put(getName(), arrList);
					String horseName = getHorse() + ": ";
					while (trigger.roundOK) {
						String bracketOut = "" + map.get(getName());

						System.out.println(horseName + bracketOut.replaceAll("\\[|\\]|\\ |\\,", ""));
						int rNum = r.nextInt(10) + 1;
						map.put(getName(), arrList);
						Thread.sleep(100);
						if (rNum > 5) {
							arrList// 순서바꾸기
						}

					}
					break;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}

	public void transfer() {

	}
}

class Trigger {
	public volatile boolean isOK = false;
	public volatile boolean horseStart = false;
	public volatile boolean roundOK = true;
}