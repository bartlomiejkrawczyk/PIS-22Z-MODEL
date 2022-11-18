package com.example.model.exam

import com.example.model.exam.answer.ChoiceAnswer
import spock.lang.Shared
import spock.lang.Specification

class MultipleChoiceTest extends Specification {

	@Shared
	def correctAnswer = Mock(ChoiceAnswer) {
		isCorrectSelected() >> true
	}

	@Shared
	def incorrectAnswer = Mock(ChoiceAnswer) {
		isCorrectSelected() >> false
	}

	def 'Should correctly determine whether answer is correct'() {
		expect:
		exercise.isCorrectlyAnswered() == correct

		where:
		exercise                                                                   || correct
		new MultipleChoice()                                                       || true
		MultipleChoice.builder().answers([correctAnswer, incorrectAnswer]).build() || false
		MultipleChoice.builder().answers([correctAnswer]).build()                  || true
		MultipleChoice.builder().answers([correctAnswer, correctAnswer]).build()   || true
		MultipleChoice.builder().answers([]).build()                               || true
	}
}
