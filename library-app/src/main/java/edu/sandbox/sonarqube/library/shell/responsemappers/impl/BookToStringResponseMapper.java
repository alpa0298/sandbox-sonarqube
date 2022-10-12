package edu.sandbox.sonarqube.library.shell.responsemappers.impl;

import edu.sandbox.sonarqube.library.shell.responsemappers.ToStringResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import edu.sandbox.sonarqube.library.domain.Author;
import edu.sandbox.sonarqube.library.domain.Book;
import edu.sandbox.sonarqube.library.domain.Genre;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.SPACE;

@Service
@RequiredArgsConstructor
public class BookToStringResponseMapper implements ToStringResponseMapper<Book> {

    private final ToStringResponseMapper<Genre> genreToStringResponseMapper;
    private final ToStringResponseMapper<Author> authorToStringResponseMapper;

    @Override
    public String map(Book book) {
        return format("id: %s | title: %s | genre: {%s} | authors: {%s}",
                book.getId(), book.getTitle(),
                genreToStringResponseMapper.map(book.getGenre()),
                authorToStringResponseMapper.map(book.getAuthors(), SPACE)
        );
    }
}
