package edu.sandbox.sonarqube.library.services;

import edu.sandbox.sonarqube.library.core.operations.CrudOperations;
import edu.sandbox.sonarqube.library.domain.Genre;

import java.util.List;

public interface GenresService extends CrudOperations<Genre> {

    List<Genre> findAllById(Iterable<String> ids);
}
