package edu.sandbox.sonarqube.library.services.impl;

import edu.sandbox.sonarqube.library.domain.Comment;
import edu.sandbox.sonarqube.library.repository.BookRepository;
import edu.sandbox.sonarqube.library.repository.CommentRepository;
import edu.sandbox.sonarqube.library.services.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService {

    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findCommentsByBookId(String id) {
//        Optional<Book> book = bookRepository.findById(id);
//        if (book.isPresent()) {
//            List<Comment> comments = book.get().getComments();
//            Hibernate.initialize(comments);
//            return comments;
//        }
        return emptyList();
    }

    @Override
    public Optional<Comment> findById(String id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }
}
