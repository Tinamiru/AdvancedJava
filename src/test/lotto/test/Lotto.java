package test.lotto.test;

import java.util.*;

public class Lotto {
	private int inputPrice;
	private int change;
	private int purchaseNum;
	private final static int LOTTO_PRICE = 1000;

	Scanner scanner = new Scanner(System.in);

	public void menu() {

		while (true) {
			System.out.println("==========================");
			System.out.println("      Lotto 프로그램");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==========================");
			System.out.print("메뉴 선택 : ");
			try {
				int input = Integer.parseInt(scanner.next());
				if (input > 2 || input < 0) {
					throw new Exception();
				}
				switch (input) {
				case 1:
					run();
					break;

				case 2:
					end();
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해야합니다.");
			} catch (Exception e) {
				System.out.println("메뉴에 지정된 숫자를 입력해주십시오.");
			}
		}

	}

	public void run() {
		System.out.println();
		System.out.println("Lotto 구입 시작");
		System.out.println();
		System.out.println("(1000원에 로또번호 하나 입니다.)");
		System.out.println();
		while (true) {
			try {
				System.out.print("금액 입력: ");
				System.out.println();

				int price = Integer.parseInt(scanner.next());
				if (price < 1000) {
					throw new Exception("1000원 이하의 금액입니다.");// 예외 발생시 메세지 입력.
				}
				setInputPrice(price);
				setChange(price % LOTTO_PRICE);
				setPurchaseNum(price / LOTTO_PRICE);

				LottoList lottoList = new LottoList();
				lottoList.lottoList(getPurchaseNum());
				System.out.println();
				System.out.printf("받은금액은 %,d원이고 거스름돈은 %,d원이며 구매장수는 %d장입니다", getInputPrice(), getChange(),
						getPurchaseNum());
				System.out.println();
				menu();
			} catch (NumberFormatException e) {
				System.out.println("금액을 입력해야합니다.");
			} catch (Exception e) {
				System.out.println("금액이 너무 적습니다.");
			}
		}
	}

	public void end() {
		System.out.println("프로그램을 종료합니다.");
	}

	public int getInputPrice() {
		return inputPrice;
	}

	public void setInputPrice(int inputPrice) {
		this.inputPrice = inputPrice;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	public int getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
}
