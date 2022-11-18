package com.example.model.exam

import com.example.model.exam.answer.ChoiceAnswer
import spock.lang.Shared
import spock.lang.Specification

class MultipleTruthOrFalseTest extends Specification {

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
		exercise                                                                       || correct
		new MultipleTruthOrFalse()                                                     || true
		MultipleTruthOrFalse.builder().tasks([correctAnswer, incorrectAnswer]).build() || false
		MultipleTruthOrFalse.builder().tasks([correctAnswer]).build()                  || true
		MultipleTruthOrFalse.builder().tasks([correctAnswer, correctAnswer]).build()   || true
		MultipleTruthOrFalse.builder().tasks([]).build()                               || true
	}
}
