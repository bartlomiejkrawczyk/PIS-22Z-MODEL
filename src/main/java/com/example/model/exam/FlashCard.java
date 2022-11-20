package com.example.model.exam;

import com.example.model.Definition;
import com.example.model.multimedia.DisplayableFile;
import java.util.ArrayList;
import java.util.List;
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
public class FlashCard implements Exercise {

	int id;
	String question;
	DisplayableFile content;

	@Builder.Default
	List<Definition> definitions = new ArrayList<>();

	String answer;

	@Builder.Default
	boolean shown = false;


	@Override
	public int getPoints() {
		return 0;
	}

	@Override
	public int getScore() {
		return 0;
	}
}
