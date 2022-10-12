package edu.sandbox.sonarqube.library.repository.impl;

import edu.sandbox.sonarqube.library.domain.Comment;
import edu.sandbox.sonarqube.library.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentRepositoryImpl implements CommentRepository {

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public Optional<Comment> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Comment save(Comment object) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
