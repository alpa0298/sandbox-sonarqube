package edu.sandbox.sonarqube.library.shell.argumentmappers.impl;

import edu.sandbox.sonarqube.library.domain.Author;
import edu.sandbox.sonarqube.library.domain.Book;
import edu.sandbox.sonarqube.library.domain.Genre;
import edu.sandbox.sonarqube.library.shell.argumentmappers.BookArgumentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookArgumentMapperImpl implements BookArgumentMapper {

    @Override
    public Book map(String title, String genreId, List<String> authorIds) {
        Book book = new Book(title, new Genre(null, genreId));
        List<Author> authors = authorIds.stream().map(authorId -> new Author(authorId, null)).toList();
        book.setAuthors(authors);
        return book;
    }

    @Override
    public Book map(String id, String title, String genreId, List<String> authorIds) {
        Book book = new Book(id, title, new Genre(null, genreId));
        List<Author> authors = authorIds.stream().map(authorId -> new Author(authorId, null)).toList();
        book.setAuthors(authors);
        return book;
    }
}
