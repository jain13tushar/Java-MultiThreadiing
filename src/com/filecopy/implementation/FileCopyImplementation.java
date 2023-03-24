package com.filecopy.implementation;

import java.io.IOException;

import com.filecopy.utils.IOUtils;

public class FileCopyImplementation {

	public static void main(String[] args) throws IOException {

		String sourceFile1 = "a.txt";
		String destFile1 = "b.txt";

		String sourceFile2 = "c.txt";
		String destFile2 = "d.txt";

		IOUtils.copy(sourceFile1, destFile1);

		IOUtils.copy(sourceFile2, destFile2);

		System.out.println("Done");

	}

}
