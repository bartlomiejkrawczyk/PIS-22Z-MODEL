package com.example.model.exam.mapper;

import com.example.model.exam.Choice;
import com.example.model.exam.Exercise;
import com.example.model.exam.ExerciseDto;
import com.example.model.exam.FillBlanks;
import com.example.model.exam.FlashCard;
import com.example.model.exam.MultipleChoice;
import com.example.model.exam.MultipleTruthOrFalse;
import com.example.model.exam.SelectFromList;
import com.example.model.exam.TruthOrFalse;
import java.util.Map;
import java.util.Optional;
import org.mapstruct.factory.Mappers;

public class ExerciseMappers {

	private static final Map<Class<? extends Exercise>, ExerciseMapper<? extends Exercise>> EXERCISE_MAPPERS = Map.of(
			Choice.class, Mappers.getMapper(ChoiceMapper.class),
			MultipleChoice.class, Mappers.getMapper(MultipleChoiceMapper.class),
			TruthOrFalse.class, Mappers.getMapper(TruthOrFalseMapper.class),
			MultipleTruthOrFalse.class, Mappers.getMapper(MultipleTruthOrFalseMapper.class),
			FillBlanks.class, Mappers.getMapper(FillBlanksMapper.class),
			SelectFromList.class, Mappers.getMapper(SelectFromListMapper.class),
			FlashCard.class, Mappers.getMapper(FlashCardMapper.class)
	);

	public ExerciseDto exerciseToDto(Exercise entity) {
		return findMapper(entity)
				.map(ExerciseMapper::mapperToSpecificType)
				.map(mapper -> mapper.exerciseToDto(mapper.getExerciseType().cast(entity)))
				.orElse(null);
	}

	public Exercise dtoToExercise(ExerciseDto dto) {
		return findMapper(dto)
				.map(ExerciseMapper::mapperToSpecificType)
				.map(mapper -> mapper.dtoToExercise(dto))
				.orElse(null);
	}

	private Optional<ExerciseMapper<? extends Exercise>> findMapper(Exercise exercise) {
		return Optional.ofNullable(EXERCISE_MAPPERS.get(exercise.getClass()));
	}

	private Optional<ExerciseMapper<? extends Exercise>> findMapper(ExerciseDto dto) {
		return Optional.ofNullable(EXERCISE_MAPPERS.get(dto.getType().getClazz()));
	}
}
