package com.example.model.exam

import spock.lang.Specification

class FlashCardTest extends Specification {

	def 'Should correctly determine whether answer is correct'() {
		expect:
		exercise.isCorrectlyAnswered() == correct

		where:
		exercise                    || correct
		new FlashCard()             || true
		FlashCard.builder().build() || true
	}
}