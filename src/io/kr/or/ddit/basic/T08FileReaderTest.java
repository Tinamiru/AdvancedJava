package io.kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T08FileReaderTest {
	public static void main(String[] args) {

//		FileReader fr = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;

		try {
			fis = new FileInputStream("d:/D_Other/testChar.txt");
//			fr = new FileReader("d:/D_Other/testChar.txt");
			isr = new InputStreamReader(fis);

			int data = 0;
			while ((data = isr.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}