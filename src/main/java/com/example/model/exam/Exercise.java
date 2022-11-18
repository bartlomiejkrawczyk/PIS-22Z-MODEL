package com.example.model.exam;

import com.example.model.Definition;
import com.example.model.multimedia.DisplayableFile;
import java.util.List;

public interface Exercise {

	int getId();

	String getQuestion();

	DisplayableFile getContent();

	List<Definition> getDefinitions();


	int getPoints();

	int getScore();

	default boolean isCorrectlyAnswered() {
		return getPoints() == getScore();
	}
}
