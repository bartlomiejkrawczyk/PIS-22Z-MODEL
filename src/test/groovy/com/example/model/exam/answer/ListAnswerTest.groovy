package com.example.model.exam.answer

import spock.lang.Specification

class ListAnswerTest extends Specification {

	def 'Should correctly determine whether selected answer is correct'() {
		expect:
		answer.isCorrectSelected() == correct

		where:
		answer                                                                                                   || correct
		new ListAnswer()                                                                                         || false
		ListAnswer.builder().selected(0).build()                                                                 || false
		ListAnswer.builder().selected(1).build()                                                                 || false
		ListAnswer.builder().selected(-1).build()                                                                || false
		ListAnswer.builder().selected(0).build()                                                                 || false
		ListAnswer.builder().correctAnswer("1").possibleAnswers(["1", "2", "3"]).build()                         || false
		ListAnswer.builder().correctAnswer("1").possibleAnswers(["1", "2", "3"]).selected(0).build()             || true
		ListAnswer.builder().correctAnswer("2").possibleAnswers(["1", "2", "3"]).selected(1).build()             || true
		ListAnswer.builder().correctAnswer(new String("1")).possibleAnswers(["1", "2", "3"]).selected(0).build() || true
		ListAnswer.builder().correctAnswer("1").possibleAnswers(["1", "2", "3"]).selected(1).build()             || false
		ListAnswer.builder().correctAnswer("1").possibleAnswers(["1", "2", "3"]).selected(4).build()             || false
		ListAnswer.builder().correctAnswer("1").possibleAnswers(["1", "2", "3"]).selected(-1).build()            || false
	}
}
