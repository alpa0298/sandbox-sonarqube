package edu.sandbox.sonarqube.library.domain;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table("books")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @PrimaryKey
    private String id;

    @Column("title")
    private String title;

    @Column("genre_id")
    private Genre genre;

    @Column("authors")
    private List<Author> authors = new ArrayList<>();

    @Column("comments")
    private List<Comment> comments = new ArrayList<>();

    public Book(String id, String title, Genre genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public Book(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Book(String id) {
        this.id = id;
    }
}
