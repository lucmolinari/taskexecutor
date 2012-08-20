package com.wordpress.lucianomolinari.taskexecutor.unrelatedtask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Execute {@link SimpleTask} in a parallel manner
 * 
 * @author Luciano Molinari
 */
public class SimpleTaskExecutorParallel implements SimpleTaskExecutor {

	/**
	 * Creates a pool with 10 threads to execute jobs
	 */
	private final ExecutorService executor = Executors.newFixedThreadPool(10);

	@Override
	public void execute(final SimpleTask simpleTask) {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				simpleTask.execute();
			}
		});
	}

}
