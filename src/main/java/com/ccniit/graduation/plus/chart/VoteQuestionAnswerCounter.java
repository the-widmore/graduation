package com.ccniit.graduation.plus.chart;

import java.util.Map;

public class VoteQuestionAnswerCounter {

	private String question;
	private Map<String, Integer> answerCounter;

	public VoteQuestionAnswerCounter() {
		super();
	}

	public VoteQuestionAnswerCounter(String question, Map<String, Integer> answerCounter) {
		super();
		this.question = question;
		this.answerCounter = answerCounter;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Map<String, Integer> getAnswerCounter() {
		return answerCounter;
	}

	public void setAnswerCounter(Map<String, Integer> answerCounter) {
		this.answerCounter = answerCounter;
	}

}
