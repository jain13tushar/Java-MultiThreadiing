package com.filecopy.implementation;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileCopyImplementationUsingThreadPool {

	public static void main(String[] args) throws IOException {
		String sourceFile1 = "a.txt";
		String sourceFile2 = "b.txt";

		String destFile1 = "c.txt";
		String destFile2 = "d.txt";

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.submit(new CopyTask(sourceFile1, destFile1));
		executorService.submit(new CopyTask(sourceFile2, destFile2));

		System.out.println("Done");
	}

}