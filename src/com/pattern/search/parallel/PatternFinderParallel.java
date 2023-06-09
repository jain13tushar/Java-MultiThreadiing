package com.pattern.search.parallel;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.file.pattern.finder.util.Finder;

public class PatternFinderParallel {

	public static void main(String[] args) throws Exception {

		String pattern = "public";

		File dir = new File("./src/sample");
		File[] files = dir.listFiles();

		Finder finder = new Finder();

		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Map<String, Object> resultMap = new HashMap<String, Object>();

		long startTime = System.currentTimeMillis();

		for (File file : files) {
			Future<List<Integer>> future = executorService.submit(new Callable<List<Integer>>() {
				public List<Integer> call() {
					List<Integer> lineNumbers = finder.find(file, pattern);
					return lineNumbers;
				}
			});

			resultMap.put(file.getName(), future);
		}

		waitForAll(resultMap);

		for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
			System.out.println(pattern + " found at - " + entry.getValue() + " in file " + entry.getKey());
		}

		// Parallel - 1007
		System.out.println("Time taken for search - " + (System.currentTimeMillis() - startTime));

	}

	private static void waitForAll(Map<String, Object> resultMap) throws Exception {

		Set<String> keys = resultMap.keySet();

		for (String key : keys) {
			@SuppressWarnings("unchecked")
			Future<List<Integer>> future = (Future<List<Integer>>) resultMap.get(key);
			while (!future.isDone()) {
				Thread.yield();
			}
			resultMap.put(key, future.get());
		}

	}

}
