package com.example.model.exam.answer

import spock.lang.Specification

class ChoiceAnswerTest extends Specification {

	def 'Should correctly determine whether selected answer is correct'() {
		expect:
		answer.isCorrectSelected() == correct

		where:
		answer                                                       || correct
		new ChoiceAnswer()                                           || true
		ChoiceAnswer.builder().checked(false).build()                || true
		ChoiceAnswer.builder().correct(true).checked(true).build()   || true
		ChoiceAnswer.builder().correct(true).checked(true).build()   || true
		ChoiceAnswer.builder().correct(true).checked(null).build()   || false
		ChoiceAnswer.builder().correct(true).checked(false).build()  || false
		ChoiceAnswer.builder().correct(false).checked(false).build() || true
	}
}
