package edu.sandbox.sonarqube.library.domain;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("comments")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @PrimaryKey
    private String id;

    @Column("text")
    private String text;

    @Column("book")
    private Book book;

    public Comment(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public Comment(String id, String bookId, String bookTitle, String text) {
        this.id = id;
        this.text = text;
        this.book = new Book(bookId, bookTitle);
    }
}
