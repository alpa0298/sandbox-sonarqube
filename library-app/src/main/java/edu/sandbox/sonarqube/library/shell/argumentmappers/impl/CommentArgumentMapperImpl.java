package edu.sandbox.sonarqube.library.shell.argumentmappers.impl;

import edu.sandbox.sonarqube.library.domain.Book;
import edu.sandbox.sonarqube.library.domain.Comment;
import edu.sandbox.sonarqube.library.shell.argumentmappers.CommentArgumentMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentArgumentMapperImpl implements CommentArgumentMapper {

    @Override
    public Comment map(String bookId, String text) {
        return new Comment(text, null, new Book(bookId));
    }

    @Override
    public Comment map(String id, String bookId, String text) {
        return new Comment(id, text, new Book(bookId));
    }
}
