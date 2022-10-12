package edu.sandbox.sonarqube.library.shell.argumentmappers.impl;

import edu.sandbox.sonarqube.library.domain.Genre;
import edu.sandbox.sonarqube.library.shell.argumentmappers.GenreArgumentMapper;
import org.springframework.stereotype.Service;

@Service
public class GenreArgumentMapperImpl implements GenreArgumentMapper {

    @Override
    public Genre map(String id, String name) {
        return new Genre(id, name);
    }

    @Override
    public Genre map(String name) {
        return new Genre(null, name);
    }
}
