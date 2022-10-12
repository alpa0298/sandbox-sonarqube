package edu.sandbox.sonarqube.library.shell.argumentmappers;

import edu.sandbox.sonarqube.library.domain.Comment;

public interface CommentArgumentMapper {

    Comment map(String bookId, String text);

    Comment map(String id, String bookId, String text);
}
