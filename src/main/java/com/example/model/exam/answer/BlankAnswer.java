package com.example.model.exam.answer;

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
public class BlankAnswer implements Answer {

	int id;
	String start;
	String end;
	String answer;

	@Builder.Default
	String entered = null;

	public boolean isCorrectSelected() {
		return StringUtils.equals(entered, answer);
	}
}
