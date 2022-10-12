package edu.sandbox.sonarqube.library.core.operations;

import java.util.List;
import java.util.Optional;

public interface CrudOperations<T> {

    List<T> findAll();

    Optional<T> findById(String id);

    T save(T object);

    void deleteById(String id);
}