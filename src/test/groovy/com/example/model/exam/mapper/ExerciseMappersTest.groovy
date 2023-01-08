package com.example.model.exam.mapper

import com.example.model.exam.*
import com.example.model.exam.answer.BlankAnswer
import com.example.model.exam.answer.ChoiceAnswer
import com.example.model.exam.answer.ListAnswer
import spock.lang.Specification

class ExerciseMappersTest extends Specification {

	def mapper = new ExerciseMappers()

	def 'Should map from dto to exercise correctly'() {
		expect:
		mapper.dtoToExercise(dto) == exercise
		where:
		dto                                                                                                                                    || exercise
		ExerciseDto.builder().type(ExerciseType.CHOICE).correctAnswer("A").possibleAnswers(["A"]).build()                                      || Choice.builder().correctAnswer("A").possibleAnswers(["A"]).build()
		ExerciseDto.builder().type(ExerciseType.MULTIPLE_CHOICE).choiceAnswers([ChoiceAnswer.builder().correct(true).build()]).build()         || MultipleChoice.builder().answers([ChoiceAnswer.builder().correct(true).build()]).build()
		ExerciseDto.builder().type(ExerciseType.MULTIPLE_TRUTH_OR_FALSE).choiceAnswers([ChoiceAnswer.builder().correct(true).build()]).build() || MultipleTruthOrFalse.builder().tasks([ChoiceAnswer.builder().correct(true).build()]).build()
		ExerciseDto.builder().type(ExerciseType.TRUTH_OR_FALSE).correct(true).build()                                                          || TruthOrFalse.builder().correct(true).build()
		ExerciseDto.builder().type(ExerciseType.FILL_BLANKS).blankAnswers([BlankAnswer.builder().answer("A").build()]).build()                 || FillBlanks.builder().answers([BlankAnswer.builder().answer("A").build()]).build()
		ExerciseDto.builder().type(ExerciseType.SELECT_FROM_LIST).listAnswers([ListAnswer.builder().correctAnswer("A").build()]).build()       || SelectFromList.builder().answers([ListAnswer.builder().correctAnswer("A").build()]).build()
		ExerciseDto.builder().type(ExerciseType.FLASH_CARD).correctAnswer("A").build()                                                         || FlashCard.builder().answer("A").build()
	}

	def 'Should map from exercise to dto correctly'() {
		expect:
		mapper.exerciseToDto(exercise) == dto
		where:
		dto                                                                                                                                    || exercise
		ExerciseDto.builder().type(ExerciseType.CHOICE).correctAnswer("A").possibleAnswers(["A"]).build()                                      || Choice.builder().correctAnswer("A").possibleAnswers(["A"]).build()
		ExerciseDto.builder().type(ExerciseType.MULTIPLE_CHOICE).choiceAnswers([ChoiceAnswer.builder().correct(true).build()]).build()         || MultipleChoice.builder().answers([ChoiceAnswer.builder().correct(true).build()]).build()
		ExerciseDto.builder().type(ExerciseType.MULTIPLE_TRUTH_OR_FALSE).choiceAnswers([ChoiceAnswer.builder().correct(true).build()]).build() || MultipleTruthOrFalse.builder().tasks([ChoiceAnswer.builder().correct(true).build()]).build()
		ExerciseDto.builder().type(ExerciseType.TRUTH_OR_FALSE).correct(true).build()                                                          || TruthOrFalse.builder().correct(true).build()
		ExerciseDto.builder().type(ExerciseType.FILL_BLANKS).blankAnswers([BlankAnswer.builder().answer("A").build()]).build()                 || FillBlanks.builder().answers([BlankAnswer.builder().answer("A").build()]).build()
		ExerciseDto.builder().type(ExerciseType.SELECT_FROM_LIST).listAnswers([ListAnswer.builder().correctAnswer("A").build()]).build()       || SelectFromList.builder().answers([ListAnswer.builder().correctAnswer("A").build()]).build()
		ExerciseDto.builder().type(ExerciseType.FLASH_CARD).correctAnswer("A").build()                                                         || FlashCard.builder().answer("A").build()
	}
}
