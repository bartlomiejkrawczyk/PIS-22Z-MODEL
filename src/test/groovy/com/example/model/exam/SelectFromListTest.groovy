package com.example.model.exam


import com.example.model.exam.answer.ListAnswer
import spock.lang.Shared
import spock.lang.Specification

class SelectFromListTest extends Specification {

	@Shared
	def correctAnswer = Mock(ListAnswer) {
		isCorrectSelected() >> true
	}

	@Shared
	def incorrectAnswer = Mock(ListAnswer) {
		isCorrectSelected() >> false
	}

	def 'Should correctly determine whether answer is correct'() {
		expect:
		exercise.isCorrectlyAnswered() == correct

		where:
		exercise                                                                   || correct
		new SelectFromList()                                                       || true
		SelectFromList.builder().answers([correctAnswer, incorrectAnswer]).build() || false
		SelectFromList.builder().answers([correctAnswer]).build()                  || true
		SelectFromList.builder().answers([correctAnswer, correctAnswer]).build()   || true
		SelectFromList.builder().answers([]).build()                               || true
	}
}
