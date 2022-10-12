package edu.sandbox.sonarqube.library.services;

import edu.sandbox.sonarqube.library.core.operations.CrudOperations;
import edu.sandbox.sonarqube.library.domain.Comment;

import java.util.List;

public interface CommentsService extends CrudOperations<Comment> {

    List<Comment> findCommentsByBookId(String id);
}
