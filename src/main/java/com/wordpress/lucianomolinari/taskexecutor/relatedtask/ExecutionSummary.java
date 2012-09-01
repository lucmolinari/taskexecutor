package com.wordpress.lucianomolinari.taskexecutor.relatedtask;

/**
 * 
 * @author Luciano Molinari
 * 
 */
public class ExecutionSummary {
	private int numberOfOk;
	private int numberOfError;

	public void addOk() {
		numberOfOk++;
	}

	public void addError() {
		numberOfError++;
	}

	public void addExecutionSummary(ExecutionSummary executionSummary) {
		numberOfOk += executionSummary.getNumberOfOk();
		numberOfError += executionSummary.getNumberOfError();
	}

	public int getNumberOfOk() {
		return numberOfOk;
	}

	public int getNumberOfError() {
		return numberOfError;
	}

	@Override
	public String toString() {
		return "ExecutionSummary [numberOfOk=" + numberOfOk + ", numberOfError=" + numberOfError + "]";
	}

}
