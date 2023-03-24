package com.filecopy.implementation;

import java.io.IOException;

import com.filecopy.utils.IOUtils;

public class CopyTask implements Runnable {

	private String source;

	private String dest;

	public CopyTask(String source, String dest) {
		this.source = source;
		this.dest = dest;
	}

	public void run() {
		try {
			IOUtils.copy(source, dest);
			System.out.println("Copied from - " + source + " to " + dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}