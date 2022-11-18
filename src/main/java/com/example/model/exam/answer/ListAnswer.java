package com.example.model.exam.answer;

import java.util.ArrayList;
import java.util.List;
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
import org.apache.commons.lang3.StringUtils;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ListAnswer implements Answer {

	int number;

	String start;
	String end;
	@Builder.Default
	List<String> possibleAnswers = new ArrayList<>();
	String correctAnswer;

	@Builder.Default
	Integer selected = null;

	public boolean isCorrectSelected() {
		return Optional.ofNullable(selected)
				.filter(selectedAnswer -> selectedAnswer >= 0 && selectedAnswer < possibleAnswers.size())
				.map(possibleAnswers::get)
				.map(selectedAnswer -> StringUtils.equals(selectedAnswer, correctAnswer))
				.orElse(false);
	}
}
