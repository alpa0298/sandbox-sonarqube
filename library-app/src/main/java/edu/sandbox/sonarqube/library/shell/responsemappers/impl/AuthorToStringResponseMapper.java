package edu.sandbox.sonarqube.library.shell.responsemappers.impl;

import edu.sandbox.sonarqube.library.shell.responsemappers.ToStringResponseMapper;
import org.springframework.stereotype.Service;
import edu.sandbox.sonarqube.library.domain.Author;

import static java.lang.String.format;

@Service
public class AuthorToStringResponseMapper implements ToStringResponseMapper<Author> {

    @Override
    public String map(Author author) {
        return format("id: %s | name: %s", author.getId(), author.getName());
    }
}
