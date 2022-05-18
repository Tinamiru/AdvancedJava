package test.lotto.test;

import java.util.*;

public class Lotto {
	private int inputPrice;
	private int change;
	private int purchaseNum;
	private final static int LOTTO_PRICE = 1000;

	Scanner scanner = new Scanner(System.in);

	public void menu() {

		System.out.println("==========================");
		System.out.println("      Lotto 프로그램");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("==========================");
		System.out.print("메뉴 선택 : ");
		
		int input = Integer.parseInt(scanner.next());
		switch (input) {
		case 1:
			run();
			break;

		case 2:
			end();
			break;
		}

	}

	public void run() {
		System.out.println();
		System.out.println("Lotto 구입 시작");
		System.out.println();
		System.out.println("(1000원에 로또번호 하나 입니다.)");
		System.out.println();
		System.out.print("금액 입력: ");
		System.out.println();

		int price = Integer.parseInt(scanner.next());
		setInputPrice(price);
		setChange(price % LOTTO_PRICE);
		setPurchaseNum(price / LOTTO_PRICE);

		LottoList lottoList = new LottoList();
		lottoList.lottoList(getPurchaseNum());
		System.out.println();
		System.out.printf("받은금액은 %,d원이고 거스름돈은 %,d원이며 구매장수는 %d장입니다", getInputPrice(), getChange(), getPurchaseNum());
		System.out.println();
		menu();
	}

	public void end() {
		System.out.println("감사합니다");
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
