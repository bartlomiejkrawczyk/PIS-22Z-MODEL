package com.example.model.exam;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExerciseType {
	CHOICE(1, Choice.class),
	FILL_BLANKS(2, FillBlanks.class),
	FLASH_CARD(3, FlashCard.class),
	MULTIPLE_CHOICE(4, MultipleChoice.class),
	MULTIPLE_TRUTH_OR_FALSE(5, MultipleTruthOrFalse.class),
	SELECT_FROM_LIST(6, SelectFromList.class),
	TRUTH_OR_FALSE(7, TruthOrFalse.class),
	;

	private final int type;
	private final Class<? extends Exercise> clazz;
}
