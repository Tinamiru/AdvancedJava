package test.hotel.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class HotelExam {

	private Scanner sc;
	private Map<Integer, Hotel> roomInfo;

	public HotelExam() {
		sc = new Scanner(System.in);
		roomInfo = new TreeMap<Integer, Hotel>();
	}

	public static void main(String[] args) throws InterruptedException {
		HotelExam he = new HotelExam();
		he.view();
	}

	public void view() throws InterruptedException, NumberFormatException {
		sc = new Scanner(System.in);
		System.out.println("호텔 시스템을 시작합니다.");
		System.out.println();
		Thread.sleep(500);
		System.out.println("시스템을 불러옵니다.");
		System.out.println();
		Thread.sleep(500);
		System.out.print("로딩중");
		for (int i = 0; i < 25; i++) {
			Thread.sleep(80);
			System.out.print(".");
		}
		System.out.println();
		System.out.println();
		picOfHotel();
		System.out.println();
		System.out.println("***********************************************************");
		System.out.println("                        환영합니다.");
		System.out.println("***********************************************************");
		System.out.println();
		front();
	}

	public void front() throws InterruptedException {

		while (true) {
			try {
				Thread.sleep(1000);
				System.out.println();
				System.out.println("***********************************************************");
				System.out.println("어떤 업무를 하시겠습니까?");
				System.out.println("1. 체크인  2. 체크아웃 3. 객실상태 4. 업무종료");
				System.out.println("***********************************************************");
				System.out.println();
				System.out.print("메뉴선택 => ");
				int input = Integer.parseInt(sc.nextLine());
				switch (input) {
				case 1:
					checkIn();
					break;
				case 2:
					checkOut();
					break;
				case 3:
					state();
					break;
				case 4:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("메뉴에 해당하는 숫자만 입력 해 주십시오.");
					System.out.println();
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하여 주십시오.");
				System.out.println();
			}
		}
	}

	private void checkIn() throws InterruptedException, NumberFormatException {
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");

		Integer num = Integer.parseInt(sc.nextLine());

		if (roomInfo.get(num) != null) {
			System.out.println(num + "번 방은 이미 체크인 되었습니다.");
			return;
		} else {
			System.out.println();
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.print("이름입력 => ");

			String name = sc.nextLine();

			roomInfo.put(num, new Hotel(num, name));
		}
		System.out.println("체크인 되었습니다.");
		System.out.println();
		return;
	}

	private void checkOut() throws InterruptedException, NumberFormatException {
		System.out.println();
		System.out.println("삭제할 방번호를 입력하세요");
		System.out.print("방번호 입력 => ");

		Integer num = Integer.parseInt(sc.nextLine());

		if (roomInfo.remove(num) == null) {
			System.out.println(num + "번 방에는 체크인한 사람이 없습니다.");
			return;
		} else {
			System.out.println(num + "번 방을 체크아웃합니다.");
			Thread.sleep(1000);
		}
		System.out.println("체크아웃 되었습니다.");
		return;
	}

	private void state() {
		Set<Integer> roomSet = roomInfo.keySet();

		if (roomSet.size() == 0) {
			System.out.println("모든 방이 비어있습니다.");
		} else {
			Iterator<Integer> it = roomSet.iterator();
			while (it.hasNext()) {
				Integer name = it.next();
				Hotel h = roomInfo.get(name);
				System.out.println("방번호: " + h.getRoomNum() + "\t" + "투숙객: " + h.getName());
			}
		}
		return;
	}

	private void picOfHotel() throws InterruptedException {

		int num = 30;
		System.out.println(".     i77SWX            .W                                  ");
		Thread.sleep(num);
		System.out.println("     X; 7.  :            ,          0,         0,           ");
		Thread.sleep(num);
		System.out.println(".    B  2    X        :8.B:   :            .,          i2");
		Thread.sleep(num);
		System.out.println(".    ;r  X80ZX        W. .B.               ,;           r");
		Thread.sleep(num);
		System.out.println("      ,XX ;S.    X,  8;   r0   :MS  7\")                       ");
		Thread.sleep(num);
		System.out.println(".                X, 2r     r2  ;SS  8                   ,i");
		Thread.sleep(num);
		System.out.println("                   :2i0Z0ZB;a  0 ;i  ,;                 SZ");
		Thread.sleep(num);
		System.out.println(".   ;:              r7XXaXSX;  8S0i :ZaX    .,");
		Thread.sleep(num);
		System.out.println("                   i2; rX; iS7XiXXiSB  8r   ra");
		Thread.sleep(num);
		System.out.println(".          r:     aXZ.iiB7i:i      Z:   B.");
		Thread.sleep(num);
		System.out.println("           .     SX7Z7.Xi2iZi     SS ,: .0");
		Thread.sleep(num);
		System.out.println(".               7aX7X2@SX,;:     ;Z S0@Z.;8       7a");
		Thread.sleep(num);
		System.out.println("   7a          7X...            i0  82Z0; aX            ,:");
		Thread.sleep(num);
		System.out.println(".   .           80M0@8BMWM0@M@MBM.  ,i:i   Zi           ,.");
		Thread.sleep(num);
		System.out.println("                X   S2:   Sa:  S,          .Zi  .0");
		Thread.sleep(num);
		System.out.println(".           a.  2, X::2  X::S  X7MW@0M@@W0MZS:  .S");
		Thread.sleep(num);
		System.out.println("            2,  2: 2 X7, a.77, ,X ;ZX. i2S :2");
		Thread.sleep(num);
		System.out.println(".               S  ir2X  7XaX   7 7rX: Xrr;,S");
		Thread.sleep(num);
		System.out.println("     r,         2Za2aXXSSSSS22a8;r r X:,; S:X           ir");
		Thread.sleep(num);
		System.out.println(".              XS2ZaZX7.       i7 782i rZ2r Z i.        7X");
		Thread.sleep(num);
		System.out.println("              ;Siiiiiir:.:      X,;,i,,;,i,;Z;");
		Thread.sleep(num);
		System.out.println(".            :Z,:,,,,,::i;ii;i;:;X77X7X7XrXr,Zi");
		Thread.sleep(num);
		System.out.println("              ;ZaZ028ZZZZ0288a0a0aXZS82a2ZZSBX      B7");
		Thread.sleep(num);
		System.out.println(".       ;8    ,Z:2i i2  8  ;r .2i7ai ,a  2, 0.");
		Thread.sleep(num);
		System.out.println("           a. ,W.        .ZaZ,  .W          Wi 0:");
		Thread.sleep(num);
		System.out.println(".   aS     7S .B, S0@W,  ZS;2Z  :B rWW0Z@WX W:            ;");
		Thread.sleep(num);
		System.out.println("    :i    .ZB; B, Z  ;;  0;Z78  ,W 2  i;  2 Wi    iaa,    :");
		Thread.sleep(num);
		System.out.println(".         00Z2X8, Z,8:r  02SXZ  ,B S.0:,Z;S @:    BXBS");
		Thread.sleep(num);
		System.out.println("         SBaXXZZ  ,ir;   a,i8B   B  :7i:;7  W: :r7B27i,S,");
		Thread.sleep(num);
		System.out.println(".       X8XXSaaSZ00ZZZ0B@S  ;00W0Z880ZZZZZ080. .rXX. Z;X.");
		Thread.sleep(num);
		System.out.println("   i,:  8aXXX02XaZZaZZaZ0X   r00aXZ088ZZ8Z0ZZi   r, .X  ..: ");
		Thread.sleep(num);
		System.out.println(". ,Z2aa.Z0Xr2XSS;.2Xi,7S72ZZ8Zr:rarir;ii;iir8X2S;2    8 ZZ0");
		Thread.sleep(num);
		System.out.println("   i. ;82SXZMMSa77SSXXXS7Z0WB8:rXa7ri;i7ri77Z;i,,7 ;i:X ,ra");
		Thread.sleep(num);
		System.out.println(". .Z7,,SaZB7SrS88@22WWZXWSXS22:77.iXX.Xr;Xr :S; ;.i08i i7Sa");
		Thread.sleep(num);
	}
}

class Hotel {
	private Integer roomNum;
	private String name;

	public Hotel(Integer roomNum, String name) {
		super();
		this.name = name;
		this.roomNum = roomNum;
	}

	public String getName() {
		return name;
	}

	public Integer getRoomNum() {
		return roomNum;
	}
}