package io.kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;

public class T06FileStreamTest {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = null;

		try {

			fos = new FileOutputStream("d:/D_Other/out.txt");

			for (char ch = 'a'; ch <= 'z'; ch++) {
				fos.write(ch);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fos.close();
		}
	}
}
