package com.example.model.exam.answer;

import java.util.Optional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChoiceAnswer implements Answer {

	int number;
	String content;

	boolean correct;

	@Builder.Default
	Boolean checked = null;

	public boolean isCorrectSelected() {
		return Optional.ofNullable(checked).orElse(false) == correct;
	}
}
