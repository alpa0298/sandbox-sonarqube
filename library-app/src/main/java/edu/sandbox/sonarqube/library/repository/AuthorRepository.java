package edu.sandbox.sonarqube.library.repository;

import edu.sandbox.sonarqube.library.domain.Author;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface AuthorRepository extends CassandraRepository<Author, String> {

    Author findByName(String name);

    void deleteByName(String name);
}