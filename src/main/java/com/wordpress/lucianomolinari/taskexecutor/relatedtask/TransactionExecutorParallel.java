package com.wordpress.lucianomolinari.taskexecutor.relatedtask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author Luciano Molinari
 * 
 */
public class TransactionExecutorParallel implements TransactionExecutor {

	private final ExecutorService executor = Executors.newFixedThreadPool(10);

	@Override
	public ExecutionSummary execute(List<Transaction> transactions) {
		int numberOfElementsPerList = transactions.size() / 10;
		List<Future<ExecutionSummary>> summariesToBeGet = new ArrayList<Future<ExecutionSummary>>();
		int iniPos = 0;
		for (int i = 0; i < 10; i++) {
			final List<Transaction> subList = transactions.subList(iniPos, iniPos + numberOfElementsPerList);
			Future<ExecutionSummary> future = executor.submit(new Callable<ExecutionSummary>() {
				@Override
				public ExecutionSummary call() throws Exception {
					ExecutionSummary summary = new ExecutionSummary();
					for (Transaction transaction : subList) {
						if (transaction.process()) {
							summary.addOk();
						} else {
							summary.addError();
						}
					}
					return summary;
				}
			});
			summariesToBeGet.add(future);
			iniPos += numberOfElementsPerList;
		}
		ExecutionSummary summaryFinal = new ExecutionSummary();
		for (Future<ExecutionSummary> futureSummary : summariesToBeGet) {
			try {
				summaryFinal.addExecutionSummary(futureSummary.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		return summaryFinal;
	}

}