package edu.sandbox.sonarqube.library.shell.argumentmappers;

import edu.sandbox.sonarqube.library.domain.Author;

public interface AuthorArgumentMapper {

    Author map(String id, String name);

    Author map(String name);
}
