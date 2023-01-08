package com.example.model.exam.mapper;

import com.example.model.exam.ExerciseDto;
import com.example.model.exam.ExerciseType;
import com.example.model.exam.MultipleTruthOrFalse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class, imports = {ExerciseType.class})
public interface MultipleTruthOrFalseMapper extends ExerciseMapper<MultipleTruthOrFalse> {

	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "tasks", source = "choiceAnswers")
	MultipleTruthOrFalse dtoToExercise(ExerciseDto dto);

	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "possibleAnswers", ignore = true)
	@Mapping(target = "correctAnswer", ignore = true)
	@Mapping(target = "blankAnswers", ignore = true)
	@Mapping(target = "choiceAnswers", source = "tasks")
	@Mapping(target = "correct", ignore = true)
	@Mapping(target = "listAnswers", ignore = true)
	@Mapping(target = "type", expression = "java(ExerciseType.MULTIPLE_TRUTH_OR_FALSE)")
	ExerciseDto exerciseToDto(MultipleTruthOrFalse exercise);

	@Override
	default Class<MultipleTruthOrFalse> getExerciseType() {
		return MultipleTruthOrFalse.class;
	}
}
