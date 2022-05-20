package test;

import java.util.*;

public class RussianRollet {

	public static void main(String[] args) throws InterruptedException {
		String[] array = { "성겸", "민수", "동석", "재린", "수빈", "건영", "민혁", "재열",
				"은정", "재훈", "재혁", "정현", "지영", "미정", "혜림",
				"수현", "희진", "성우", "태훈", "상권", "형주", "유미", "재웅", "금규" };

		System.out.println("발표자 선택을 시작합니다.");
		System.out.println();
		Thread.sleep(500);
		System.out.print("추첨중");
		for (int i = 0; i < 60; i++) {
			Thread.sleep(80);
			System.out.print(".");
		}
		System.out.println();
		List<String> list = Arrays.asList(array);

		Collections.shuffle(list);
		list.toArray(array);

		System.out.println();
		System.out.println("발표자 : " + array[0] + "씨");

		Thread.sleep(1500);
		pepe();
	}

	private static void pepe() {
		System.out.println("                        .7SX0X0XS7i     :r77277.                      ");
		System.out.println("                      :X0X2277722SX07i20XXSS2SX87                     ");
		System.out.println("                     7Z2277722222227X0277777777702                    ");
		System.out.println("                    20777222227772222X722222222228i                   ");
		System.out.println("                   7077722777777777722277777777722X27                 ");
		System.out.println("                  207777777777222227772222722222222S0MS               ");
		System.out.println("                i0X7777777722227777i77SS00S2SSX277777XBB.             ");
		System.out.println("              .XZX77777722222S22r2ZM2. ..rZ27r. 2BBB7 .7B.            ");
		System.out.println("             :822777777722S7::. 7X2BZB.   .    8XMriBr  i             ");
		System.out.println("             822777777777722i. .B827 BB :0.   rBBBS2BB7X              ");
		System.out.println("            2X77777777777772S0XX8X080X0002XXX22222X0XS:               ");
		System.out.println("           i027777777777777777777777727277722S77772.                  ");
		System.out.println("          :0277777777777777777777727277777772227772:                  ");
		System.out.println("         .82777777777777777777777777777777777777777XX.                ");
		System.out.println("         2X777777777777777777777777777777777777777772X                ");
		System.out.println("         7X7777777777777722S2222222277777777777777777ZS               ");
		System.out.println("         .M7777777777777X22222222222S222222222S22222X8B.              ");
		System.out.println("          2X777777777772X2222S222222222222222222222XMr                ");
		System.out.println("           SS77777777227222222222222S222222222222X807                 ");
		System.out.println("            rX77777777227777777777777222222222S080:                   ");
		System.out.println("           .MM822777777777777777777777777772SXS7.                     ");
		System.out.println("           rBXX0XX2222777272727277727777772:.                         ");
		System.out.println("           :BSXSXX0XXXXS2222777777777222S0Z7.                         ");
	}

}
