package com.wordpress.lucianomolinari.taskexecutor.relatedtask;

import java.util.List;

/**
 * 
 * @author Luciano Molinari
 * 
 */
public class TransactionExecutorSequential implements TransactionExecutor {

	@Override
	public ExecutionSummary execute(List<Transaction> transactions) {
		ExecutionSummary summary = new ExecutionSummary();
		for (Transaction transaction : transactions) {
			if (transaction.process()) {
				summary.addOk();
			} else {
				summary.addError();
			}
		}
		return summary;
	}

}
