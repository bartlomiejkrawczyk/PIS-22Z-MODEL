package com.example.model.exam

import com.example.model.exam.answer.BlankAnswer
import spock.lang.Shared
import spock.lang.Specification

class FillBlanksTest extends Specification {

	@Shared
	def correctAnswer = Mock(BlankAnswer) {
		isCorrectSelected() >> true
	}

	@Shared
	def incorrectAnswer = Mock(BlankAnswer) {
		isCorrectSelected() >> false
	}

	def 'Should correctly determine whether answer is correct'() {
		expect:
		exercise.isCorrectlyAnswered() == correct

		where:
		exercise                                                               || correct
		new FillBlanks()                                                       || true
		FillBlanks.builder().answers([correctAnswer, incorrectAnswer]).build() || false
		FillBlanks.builder().answers([correctAnswer]).build()                  || true
		FillBlanks.builder().answers([correctAnswer, correctAnswer]).build()   || true
		FillBlanks.builder().answers([]).build()                               || true
	}
}
