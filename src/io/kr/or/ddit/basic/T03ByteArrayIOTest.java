package io.kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class T03ByteArrayIOTest {
	public static void main(String[] args) throws Throwable {

		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;

		// 직접 복사하기
//		outSrc = new byte[inSrc.length];
//
//		for (int i = 0; i < inSrc.length; i++) {
//			outSrc[i] = inSrc[i];
//		}

//	arraycopy를 이용한 배열 복사

//		outSrc = new byte[inSrc.length];
//		System.arraycopy(inSrc, 0, outSrc, 0, inSrc.length);

		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int data; // 읽어온 자료를 저장할 변수

//		 read() 메소드 => 바이트 단위로 자료를 읽어와 int 형으로 반환한다
//			  			  더이상 읽어올 자료가 없으면 -1을 반환.

		while ((data = bais.read()) != -1) {
			baos.write(data); // 출력
		}

		// 출력된 스트림 값을 배열로 반환하기
		outSrc = baos.toByteArray();

		System.out.println("inSrc => " + Arrays.toString(inSrc));
		System.out.println("outSrc => " + Arrays.toString(outSrc));

		// 사용한 스트림 객체 닫아주기
		bais.close();
		baos.close();

	}
}
