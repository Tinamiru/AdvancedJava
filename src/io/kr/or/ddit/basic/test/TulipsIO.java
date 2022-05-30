package io.kr.or.ddit.basic.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TulipsIO {
	public static void main(String[] args) throws IOException {
		File tulips = new File("D:/D_Other/Tulips.jpg");
		File tulipsCopy = new File("D:/D_Other/복사본_Tulips.jpg");

		FileInputStream input = new FileInputStream(tulips);
		FileOutputStream output = new FileOutputStream(tulipsCopy);

		byte[] buffer = new byte[1024];

		int readData;
		while ((readData = input.read(buffer)) > 0) {
			output.write(buffer, 0, readData);
		}
		input.close();
		output.close();
	}
}
