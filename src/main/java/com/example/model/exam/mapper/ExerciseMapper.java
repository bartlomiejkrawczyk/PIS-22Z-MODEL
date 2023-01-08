package com.example.model.exam.mapper;

import com.example.model.exam.Exercise;
import com.example.model.exam.ExerciseDto;

public interface ExerciseMapper<T extends Exercise> {

	T dtoToExercise(ExerciseDto dto);

	ExerciseDto exerciseToDto(T exercise);

	Class<T> getExerciseType();


	default ExerciseMapper<T> mapperToSpecificType() {
		return this;
	}
}
