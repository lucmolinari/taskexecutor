package com.wordpress.lucianomolinari.taskexecutor.unrelatedtask;

/**
 * Execute {@link SimpleTask} in a sequential manner
 * 
 * @author Luciano Molinari
 */
public class SimpleTaskExecutorSequential implements SimpleTaskExecutor {

	@Override
	public void execute(final SimpleTask simpleTask) {
		simpleTask.execute();
	}

}