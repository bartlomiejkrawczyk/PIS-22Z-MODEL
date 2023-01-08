package com.example.model.exam.mapper;

import com.example.model.exam.ExerciseDto;
import com.example.model.exam.ExerciseType;
import com.example.model.exam.FillBlanks;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class, imports = {ExerciseType.class})
public interface FillBlanksMapper extends ExerciseMapper<FillBlanks> {


	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "answers", source = "blankAnswers")
	FillBlanks dtoToExercise(ExerciseDto dto);

	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "possibleAnswers", ignore = true)
	@Mapping(target = "correctAnswer", ignore = true)
	@Mapping(target = "blankAnswers", source = "answers")
	@Mapping(target = "choiceAnswers", ignore = true)
	@Mapping(target = "correct", ignore = true)
	@Mapping(target = "listAnswers", ignore = true)
	@Mapping(target = "type", expression = "java(ExerciseType.FILL_BLANKS)")
	ExerciseDto exerciseToDto(FillBlanks exercise);

	@Override
	default Class<FillBlanks> getExerciseType() {
		return FillBlanks.class;
	}
}
