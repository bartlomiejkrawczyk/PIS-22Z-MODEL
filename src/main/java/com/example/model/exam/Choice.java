package com.example.model.exam;

import com.example.model.Definition;
import com.example.model.multimedia.DisplayableFile;
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
public class Choice implements Exercise {

	int id;
	String question;
	DisplayableFile content;

	@Builder.Default
	List<Definition> definitions = new ArrayList<>();

	@Builder.Default
	List<String> possibleAnswers = new ArrayList<>();
	String correctAnswer;

	@Builder.Default
	Integer selected = null;


	@Override
	public int getPoints() {
		return 1;
	}

	@Override
	public int getScore() {
		return (int) Optional.ofNullable(selected)
				.filter(selectedAnswer -> selectedAnswer >= 0 && selectedAnswer < possibleAnswers.size())
				.map(possibleAnswers::get)
				.filter(selectedAnswer -> StringUtils.equals(selectedAnswer, correctAnswer))
				.stream()
				.count();
	}
}
