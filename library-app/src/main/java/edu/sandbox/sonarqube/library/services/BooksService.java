package edu.sandbox.sonarqube.library.services;

import edu.sandbox.sonarqube.library.core.operations.CrudOperations;
import edu.sandbox.sonarqube.library.domain.Book;

public interface BooksService extends CrudOperations<Book> {

    void updateBookTitleById(String id, String newTitle);
}
