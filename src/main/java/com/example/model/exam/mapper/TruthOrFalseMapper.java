package com.example.model.exam.mapper;

import com.example.model.exam.ExerciseDto;
import com.example.model.exam.ExerciseType;
import com.example.model.exam.TruthOrFalse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class, imports = {ExerciseType.class})
public interface TruthOrFalseMapper extends ExerciseMapper<TruthOrFalse> {
	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "correct")
	@Mapping(target = "chosen", ignore = true)
	TruthOrFalse dtoToExercise(ExerciseDto dto);

	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "possibleAnswers", ignore = true)
	@Mapping(target = "correctAnswer", ignore = true)
	@Mapping(target = "blankAnswers", ignore = true)
	@Mapping(target = "choiceAnswers", ignore = true)
	@Mapping(target = "correct")
	@Mapping(target = "listAnswers", ignore = true)
	@Mapping(target = "type", expression = "java(ExerciseType.TRUTH_OR_FALSE)")
	ExerciseDto exerciseToDto(TruthOrFalse exercise);

	@Override
	default Class<TruthOrFalse> getExerciseType() {
		return TruthOrFalse.class;
	}
}
