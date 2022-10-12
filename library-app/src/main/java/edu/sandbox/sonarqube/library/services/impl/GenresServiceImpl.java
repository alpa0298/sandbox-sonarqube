package edu.sandbox.sonarqube.library.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import edu.sandbox.sonarqube.library.domain.Genre;
import edu.sandbox.sonarqube.library.repository.GenreRepository;
import edu.sandbox.sonarqube.library.services.GenresService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenresServiceImpl implements GenresService {

    private final GenreRepository genreRepository;

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> findAllById(Iterable<String> ids) {
//        return genreRepository.findAllById(ids);
        return null;
    }

    @Override
    public Optional<Genre> findById(String id) {
        return genreRepository.findById(id);
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void deleteById(String id) {
        genreRepository.deleteById(id);
    }
}
