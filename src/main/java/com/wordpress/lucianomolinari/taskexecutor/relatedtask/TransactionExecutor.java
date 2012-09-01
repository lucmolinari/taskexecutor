package com.wordpress.lucianomolinari.taskexecutor.relatedtask;

import java.util.List;

/**
 * 
 * @author Luciano Molinari
 * 
 */
public interface TransactionExecutor {

	/**
	 * Executes a {@link List} of {@link Transaction} and returns its execution
	 * summary, containing the number of transactions which were executed with
	 * success and with error
	 * 
	 * @param transactions
	 * @return
	 */
	ExecutionSummary execute(List<Transaction> transactions);

}
