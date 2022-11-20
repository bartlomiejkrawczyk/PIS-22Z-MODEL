package com.example.model.exam

import spock.lang.Specification

class ChoiceTest extends Specification {

	def 'Should correctly determine whether answer is correct'() {
		expect:
		exercise.isCorrectlyAnswered() == correct

		where:
		exercise                                                                                    || correct
		new Choice()                                                                                || false
		Choice.builder().correctAnswer("correct").possibleAnswers(["correct"]).selected(0).build()  || true
		Choice.builder().correctAnswer("correct").possibleAnswers(["false"]).selected(0).build()    || false
		Choice.builder().correctAnswer("correct").possibleAnswers(["correct"]).selected(-1).build() || false
		Choice.builder().correctAnswer("correct").possibleAnswers(["correct"]).selected(2).build()  || false
	}
}
