package com.example.model.exam.mapper;

import com.example.model.exam.ExerciseDto;
import com.example.model.exam.ExerciseType;
import com.example.model.exam.SelectFromList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class, imports = {ExerciseType.class})
public interface SelectFromListMapper extends ExerciseMapper<SelectFromList> {

	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "answers", source = "listAnswers")
	SelectFromList dtoToExercise(ExerciseDto dto);

	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "possibleAnswers", ignore = true)
	@Mapping(target = "correctAnswer", ignore = true)
	@Mapping(target = "blankAnswers", ignore = true)
	@Mapping(target = "choiceAnswers", ignore = true)
	@Mapping(target = "correct", ignore = true)
	@Mapping(target = "listAnswers", source = "answers")
	@Mapping(target = "type", expression = "java(ExerciseType.SELECT_FROM_LIST)")
	ExerciseDto exerciseToDto(SelectFromList exercise);

	@Override
	default Class<SelectFromList> getExerciseType() {
		return SelectFromList.class;
	}
}
