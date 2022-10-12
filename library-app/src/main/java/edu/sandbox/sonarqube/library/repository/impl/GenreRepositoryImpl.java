package edu.sandbox.sonarqube.library.repository.impl;

import edu.sandbox.sonarqube.library.domain.Genre;
import edu.sandbox.sonarqube.library.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreRepositoryImpl implements GenreRepository {

    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public Optional<Genre> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Genre save(Genre object) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
