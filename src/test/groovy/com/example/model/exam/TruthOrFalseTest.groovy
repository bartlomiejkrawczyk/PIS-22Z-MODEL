package com.example.model.exam

import spock.lang.Specification

class TruthOrFalseTest extends Specification {

	def 'Should correctly determine whether answer is correct'() {
		expect:
		exercise.isCorrectlyAnswered() == correct

		where:
		exercise                                                    || correct
		new TruthOrFalse()                                          || true
		TruthOrFalse.builder().correct(false).chosen(false).build() || true
		TruthOrFalse.builder().correct(true).chosen(true).build()   || true
		TruthOrFalse.builder().correct(false).chosen(true).build()  || false
		TruthOrFalse.builder().correct(true).chosen(false).build()  || false
	}
}
