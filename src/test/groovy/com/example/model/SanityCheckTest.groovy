package com.example.model

import spock.lang.Specification

class SanityCheckTest extends Specification {

	def 'Should perform simple addition correctly'() {
		expect:
		2 + 2 == 4
	}
}
