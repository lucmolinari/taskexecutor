package com.wordpress.lucianomolinari.taskexecutor.unrelatedtask;

import org.apache.log4j.Logger;

/**
 * 
 * @author Luciano Molinari
 */
public final class SimpleTask {
	private static final Logger logger = Logger.getLogger(SimpleTask.class);
	private final String message;

	public SimpleTask(String message) {
		this.message = message;
	}

	public void execute() {
		// waits 5 milliseconds
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.debug("Message processed: " + message);
	}

}