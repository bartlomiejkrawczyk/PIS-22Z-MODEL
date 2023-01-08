package com.example.model.exam.mapper;

import com.example.model.exam.ExerciseDto;
import com.example.model.exam.ExerciseType;
import com.example.model.exam.FlashCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class, imports = {ExerciseType.class})
public interface FlashCardMapper extends ExerciseMapper<FlashCard> {

	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "answer", source = "correctAnswer")
	@Mapping(target = "shown", ignore = true)
	FlashCard dtoToExercise(ExerciseDto dto);

	@Override
	@Mapping(target = "id")
	@Mapping(target = "question")
	@Mapping(target = "content")
	@Mapping(target = "definitions")
	@Mapping(target = "possibleAnswers", ignore = true)
	@Mapping(target = "correctAnswer", source = "answer")
	@Mapping(target = "blankAnswers", ignore = true)
	@Mapping(target = "choiceAnswers", ignore = true)
	@Mapping(target = "correct", ignore = true)
	@Mapping(target = "listAnswers", ignore = true)
	@Mapping(target = "type", expression = "java(ExerciseType.FLASH_CARD)")
	ExerciseDto exerciseToDto(FlashCard exercise);

	@Override
	default Class<FlashCard> getExerciseType() {
		return FlashCard.class;
	}
}
