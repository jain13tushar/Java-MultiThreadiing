package com.pattern.search.searial;

import java.io.File;
import java.util.List;

import com.file.pattern.finder.util.Finder;

public class PatternFinderSerial {

	public static void main(String[] args) {

		String pattern = "public";

		File dir = new File("./src/sample");
		File[] files = dir.listFiles();

		Finder finder = new Finder();

		long startTime = System.currentTimeMillis();

		for (File file : files) {
			List<Integer> lineNumbers = finder.find(file, pattern);
			if (!lineNumbers.isEmpty()) {
				System.out.println(pattern + "; found at " + lineNumbers + " in the file - " + file.getName());
			}
		}

		// Serial - 3040
		System.out.println("Time taken for search - " + (System.currentTimeMillis() - startTime));

	}

}
