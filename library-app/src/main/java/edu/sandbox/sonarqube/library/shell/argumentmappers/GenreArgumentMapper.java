package edu.sandbox.sonarqube.library.shell.argumentmappers;

import edu.sandbox.sonarqube.library.domain.Genre;

public interface GenreArgumentMapper {

    Genre map(String id, String name);

    Genre map(String name);
}
