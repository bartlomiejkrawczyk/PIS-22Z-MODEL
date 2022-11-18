package com.example.model.exam.answer

import spock.lang.Specification

class BlankAnswerTest extends Specification {

	def 'Should correctly determine whether selected answer is correct'() {
		expect:
		answer.isCorrectSelected() == correct

		where:
		answer                                                                         || correct
		new BlankAnswer()                                                              || true
		BlankAnswer.builder().build()                                                  || true
		BlankAnswer.builder().answer("").entered(null).build()                         || false
		BlankAnswer.builder().answer("").entered("").build()                           || true
		BlankAnswer.builder().answer("1").entered("").build()                          || false
		BlankAnswer.builder().answer("1").entered("1").build()                         || true
		BlankAnswer.builder().answer("1").entered(new String("1")).build()             || true
		BlankAnswer.builder().answer(new String("1")).entered(new String("1")).build() || true
	}
}
