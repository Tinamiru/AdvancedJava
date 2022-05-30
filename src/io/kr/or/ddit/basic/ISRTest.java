package io.kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class ISRTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		int data;
		
		while ((data = isr.read()) != -1) {
			System.out.print((char) data);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		System.out.println(a);

	}
}
