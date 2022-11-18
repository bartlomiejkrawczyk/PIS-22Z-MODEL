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
public class TruthOrFalse implements Exercise {

	int id;
	String question;
	DisplayableFile content;

	@Builder.Default
	List<Definition> definitions = new ArrayList<>();

	boolean correct;

	@Builder.Default
	Boolean chosen = null;

	@Override
	public int getPoints() {
		return 1;
	}

	@Override
	public int getScore() {
		return correct == Boolean.TRUE.equals(chosen) ? 1 : 0;
	}
}
