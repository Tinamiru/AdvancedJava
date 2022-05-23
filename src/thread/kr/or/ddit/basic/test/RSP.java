package thread.kr.or.ddit.basic.test;

import java.util.Random;

import javax.swing.JOptionPane;

public class RSP {
	static boolean inputCheck = false;

	public static void main(String[] args) {

		Thread userTh = new UserInput();
		Thread countTh = new CountDown();

		userTh.start();
		countTh.start();
	}
}

class UserInput extends Thread {

	@Override
	public void run() {
		RSPWork rsp = new RSPWork();

		String str = JOptionPane.showInputDialog("가위, 바위, 보를 입력하세요.");
		System.out.println("사용자 입력: " + str);

		RSP.inputCheck = true;

		rsp.setUserRSP(str);

		rsp.comRandom();

		rsp.rsp();
	}
}

class CountDown extends Thread {

	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			System.out.println(i);
			if (RSP.inputCheck) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class RSPWork {

	private String comRSP;
	private String userRSP;

	public void rsp() {

		String user = getUserRSP();
		String com = getComRSP();

		System.out.println("컴터: " + com);

		// 가위바위보 동작
		if (user.equals(com)) {
			System.out.println("비겼습니다.");
		} else if ((user.equals("가위") && com.equals("바위")) || (user.equals("바위") && com.equals("보"))
				|| (user.equals("보") && com.equals("가위"))) {
			System.out.println("사용자의 패배입니다...");
		} else {
			System.out.println("사용자의 승리입니다!");
		}
	}

	public void comRandom() {
		Random r = new Random();
		int rNum = r.nextInt(3)+1;

		switch (rNum) {
		case 1:
			setComRSP("가위");
			break;
		case 2:
			setComRSP("바위");
			break;
		case 3:
			setComRSP("보");
			break;
		}
	}

	public String getComRSP() {
		return comRSP;
	}

	public void setComRSP(String comRSP) {
		this.comRSP = comRSP;
	}

	public String getUserRSP() {
		return userRSP;
	}

	public void setUserRSP(String userRSP) {
		this.userRSP = userRSP;
	}
}
