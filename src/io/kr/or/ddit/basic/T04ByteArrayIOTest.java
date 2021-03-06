package io.kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class T04ByteArrayIOTest {
	public static void main(String[] args) throws Throwable {

		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;

		byte[] buffer = new byte[4];

		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int readBytes; // 읽어온 자료를 저장할 변수

//		 read() 메소드 => 바이트 단위로 자료를 읽어와 int 형으로 반환한다
//			  			  더이상 읽어올 자료가 없으면 -1을 반환.

		while ((readBytes = bais.read(buffer)) != -1) {
			System.out.println("buffer : " + Arrays.toString(buffer));
			baos.write(buffer, 0, readBytes); // 출력
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
