package com.filecopy.implementation;

import java.io.IOException;

public class FileCopyUsingThreads {

	public static void main(String[] args) throws IOException {
		String sourceFile1 = "a.txt";
		String sourceFile2 = "b.txt";

		String destFile1 = "c.txt";
		String destFile2 = "d.txt";

		new Thread(new CopyTask(sourceFile1, destFile1)).start();

		new Thread(new CopyTask(sourceFile2, destFile2)).start();

		System.out.println("Done");
	}

}
