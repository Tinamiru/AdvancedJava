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

        Trigger trigger = new Trigger();
        Horse[] horses = new Horse[]{new Horse("적토마", trigger), new Horse("강건마", trigger), new Horse("하지마", trigger),
                new Horse("구루마", trigger), new Horse("검정말", trigger), new Horse("조랑말", trigger),
                new Horse("이런말", trigger), new Horse("저런말", trigger), new Horse("말말말", trigger),
                new Horse("그짓말", trigger),

        };
        RailConnect rail = new RailConnect(horses, trigger);

        ready(horses);
        countDown();


        for (Horse horse : horses) {
            horse.start();
        }
        rail.start();

        for (Horse horse : horses) {
            horse.join();

        }
        rail.join();

        Arrays.sort(horses);

        Thread.sleep(1300);
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
        for (Horse h : horses) {
            System.out.println(h);
            Thread.sleep(300);
        }
    }

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

class Horse extends Thread implements Comparable<Horse> {

    private final String horseName;
    private final Trigger trigger;

    private int location;
    private int rank;

    public Horse(String horseName, Trigger trigger) {
        this.horseName = horseName;
        this.trigger = trigger;
    }

    @Override
    public String toString() {
        return String.format("%s등 : %s", rank, horseName);
    }

    @Override
    public int compareTo(Horse o) {
        return Integer.compare(this.rank, o.rank);
    }

    ///////////////////////// 생성자, 필드/////////////////////////////

    @Override
    public void run() {
        Random r = new Random();
        trigger.ready = false;

        for (int i = 1; i < 50; i++) {
            setLocation(i);
            try {
                Thread.sleep(r.nextInt(10) * 50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        rank = ++trigger.rank;

        if (rank == 10) {
            trigger.horseStop = true;
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

}

class Trigger {
    public volatile boolean horseStop = false;
    public volatile boolean ready = true;

    public int rank;

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
            if (!trigger.ready) {
                break;
            }
        }
//////////////////////////////////출발선///////////////////////////////
        while (true) {
            try {
                if (trigger.horseStop) {
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
