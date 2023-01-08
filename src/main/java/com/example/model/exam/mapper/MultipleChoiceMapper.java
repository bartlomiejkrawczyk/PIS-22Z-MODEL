package com.example.model.exam.mapper;

import com.example.model.exam.ExerciseDto;
import com.example.model.exam.ExerciseType;
import com.example.model.exam.MultipleChoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class, imports = {ExerciseType.class})
public interface MultipleChoiceMapper extends ExerciseMapper<MultipleChoice> {

	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "answers", source = "choiceAnswers")
	MultipleChoice dtoToExercise(ExerciseDto dto);

	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "possibleAnswers", ignore = true)
	@Mapping(target = "correctAnswer", ignore = true)
	@Mapping(target = "blankAnswers", ignore = true)
	@Mapping(target = "choiceAnswers", source = "answers")
	@Mapping(target = "correct", ignore = true)
	@Mapping(target = "listAnswers", ignore = true)
	@Mapping(target = "type", expression = "java(ExerciseType.MULTIPLE_CHOICE)")
	ExerciseDto exerciseToDto(MultipleChoice exercise);

	@Override
	default Class<MultipleChoice> getExerciseType() {
		return MultipleChoice.class;
	}
}
