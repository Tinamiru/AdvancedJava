package thread.kr.or.ddit.basic.test;

import java.util.*;

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

		Trigger trigger = new Trigger(); // 트리거클래스 생성

		Horse[] horses = new Horse[] { new Horse("적토마", trigger), new Horse("강건마", trigger), new Horse("하지마", trigger),
				new Horse("구루마", trigger), new Horse("검정말", trigger), new Horse("조랑말", trigger),
				new Horse("이런말", trigger), new Horse("저런말", trigger), new Horse("말말말", trigger),
				new Horse("그짓말", trigger),

		}; // 각각의 말과 트리거 생성자를 horse클래스에 대입하여 생성
		RailConnect rail = new RailConnect(horses, trigger); // 말 클래스와 별도로 말들의 위치를 정하는 레일클래스 생성

		// 각각의 생성자 생성시 메인클래스에서 최초로 생성한 트리거 클래스를 인수값으로 대입.

		for (Horse horse : horses) {
//			각각의 말 클래스들에 run 실행(스레드 시작)
//			horseStop 필드로 인해 출발 대기(일종의 출발대기선)
			horse.start();
		}

		ready(horses); // 준비 메소드
		countDown();// 카운트다운 메소드

		rail.start(); // 레일 스레드 시작

		for (Horse horse : horses) {
			horse.join(); // 말들과 메인 조인

		}
		rail.join(); // 레일 조인

		Arrays.sort(horses); // 말들의 등수 정렬

		Thread.sleep(1300); // 순위 출력
		for (int i = 0; i < 20; i++) {
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			System.out.print("-");
			Thread.sleep(50);
		}
		System.out.print("순");
		Thread.sleep(50);
		System.out.print("위");
		Thread.sleep(50);
		for (int i = 0; i < 5; i++) {
			System.out.print("-");
			Thread.sleep(50);
		}
		System.out.print("\n");
		Thread.sleep(300);
		for (Horse h : horses) { // 말들의 순위 출력
			System.out.println(h);
			Thread.sleep(300);
		}
	}

	// 출발 전 말들의 이름과 준비 상황 출력 메소드
	private static void ready(Horse[] horses) throws InterruptedException {
		System.out.println("경주를 준비합니다. ");
		Thread.sleep(2000);
		for (int i = 0; i < 20; i++) {
			System.out.println();
		}
		System.out.println("현재 출력된 글씨가 전부 보이게 창을 조절해 주세요.");
		for (int i = 0; i < 10; i++) {
			System.out.println("----------------------범위-----------------------");
		}
		Thread.sleep(4000);
		System.out.print("경주마 입장중");
		for (int i = 0; i < 15; i++) {
			Thread.sleep(200);
			System.out.print(".");

		}
		System.out.println();
		Thread.sleep(2000);
		for (int i = 0; i < 20; i++) {
			System.out.println();
		}
		for (int i = 0; i < horses.length; i++) {
			System.out.print((i + 1) + "번 레인 : ");
			Thread.sleep(300);
			System.out.print(horses[i].getHorseName() + "🐎");
			Thread.sleep(300);
			System.out.println();
		}
		Thread.sleep(3000);
		for (int i = 0; i < 20; i++) {
			System.out.println();
		}
		System.out.println("=====================Ready========================");
		Thread.sleep(1500);
	}

	// 말 출발 카운트 다운
	private static void countDown() {
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
	}
}

// 말들의 정보를 담는 클래스
class Horse extends Thread implements Comparable<Horse> {

	private final String horseName; // 말의 이름
	private final Trigger trigger; // 트리거

	private int location; // 말의 위치
	private int rank; // 말의 순위

	public Horse(String horseName, Trigger trigger) { // 생성자
		this.horseName = horseName;
		this.trigger = trigger;
	}

	@Override
	public String toString() { // 순위 출력
		return String.format("%s등 : %s", rank, horseName);
	}

	@Override
	public int compareTo(Horse o) { // 순위 정렬
		return Integer.compare(this.rank, o.rank);
	}

	///////////////////////// 생성자, 필드/////////////////////////////

	@Override
	public void run() { // 스레드 run()
		Random r = new Random(); // 랜덤 생성자
		trigger.setReady(false); // 출발

		// 말의 위치를 설정해주는 반복문.
		for (int i = 1; i < 50; i++) {
			setLocation(i); // 위치 전송
			try {
				Thread.sleep(r.nextInt(10) * 50); // 각각의 말들이 다른위치를 가질수 있게 제동시간을 랜덤으로 설정
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
//		rank = ++trigger.rank; // 트리거 클래스의 랭크필드가 public일경우
		int tRank = trigger.getRank(); // 트리거 클래스의 랭크필드가 private일 경우
		setRank(tRank + 1);
		trigger.setRank(getRank());

		if (rank == 10) { // 모든 말들이 도착(랭크 set이 10)이 될 경우 말 레일 클래스의 while문을 break.
			trigger.setHorseStop(true);
		}
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public String getHorseName() {
		return horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}

class Trigger {
	private volatile boolean horseStop = false; // 도착 트리거
	private volatile boolean ready = true; // 출발 트리거

	private int rank; // 랭크 트리거

	public boolean isHorseStop() {
		return horseStop;
	}

	public void setHorseStop(boolean horseStop) {
		this.horseStop = horseStop;
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}

class RailConnect extends Thread {
	private final Horse[] horses;
	private final Trigger trigger;

	public RailConnect(Horse[] horses, Trigger trigger) {
		this.horses = horses;
		this.trigger = trigger;
	}

	@Override
	public void run() {
		while (true) {
			if (!trigger.isReady()) {
				break;
			}
		}
//////////////////////////////////출발선///////////////////////////////
		while (true) {
			try {
				if (trigger.isHorseStop()) {
					break;
				}

				for (int i = 0; i < 20; i++) {
					System.out.println();
				}
				for (Horse hors : horses) {
					System.out.print(hors.getHorseName() + " | ");
					for (int j = 0; j < 50; j++) {
						if (hors.getLocation() == j) {
							System.out.print("🐎");
						} else {
							System.out.print("Ξ");
						}
					}
					System.out.print("▒");
					System.out.println();
				}
				Thread.sleep(100);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
