package com.example.model.exam.mapper;

import com.example.model.exam.Choice;
import com.example.model.exam.ExerciseDto;
import com.example.model.exam.ExerciseType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class, imports = {ExerciseType.class})
public interface ChoiceMapper extends ExerciseMapper<Choice> {

	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "possibleAnswers")
	@Mapping(target = "correctAnswer")
	@Mapping(target = "selected", ignore = true)
	Choice dtoToExercise(ExerciseDto dto);

	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "possibleAnswers")
	@Mapping(target = "correctAnswer")
	@Mapping(target = "blankAnswers", ignore = true)
	@Mapping(target = "choiceAnswers", ignore = true)
	@Mapping(target = "correct", ignore = true)
	@Mapping(target = "listAnswers", ignore = true)
	@Mapping(target = "type", expression = "java(ExerciseType.CHOICE)")
	ExerciseDto exerciseToDto(Choice exercise);

	@Override
	default Class<Choice> getExerciseType() {
		return Choice.class;
	}
}
