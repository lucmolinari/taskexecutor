package com.wordpress.lucianomolinari.taskexecutor.unrelatedtask;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 
 * @author Luciano Molinari
 */
public class TestSimpleTaskExecutor {
	private final Logger logger = Logger.getLogger(TestSimpleTaskExecutor.class);

	@Test
	public void testSequential() {
		logger.debug("--------------");
		logger.debug("Executing tasks in a sequential manner...");
		SimpleTaskExecutor executor = new SimpleTaskExecutorSequential();
		for (SimpleTask task : getListToBeExecuted()) {
			executor.execute(task);
		}
	}

	@Test
	public void testParallel() {
		logger.debug("--------------");
		logger.debug("Executing tasks in a parallel manner...");
		SimpleTaskExecutor executor = new SimpleTaskExecutorParallel();
		for (SimpleTask task : getListToBeExecuted()) {
			executor.execute(task);
		}
		// it is necessary to wait for a moment so the threads can finish their
		// jobs
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private List<SimpleTask> getListToBeExecuted() {
		List<SimpleTask> tasks = new ArrayList<SimpleTask>();
		for (int index = 1; index <= 50; index++) {
			tasks.add(new SimpleTask("Message " + index));
		}
		return tasks;
	}

}