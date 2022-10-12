USE ${CASSANDRA_KEYSPACE};

DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS books_authors;
DROP TABLE IF EXISTS comments;

CREATE TABLE genres
(
    id   uuid,
    name text PRIMARY KEY
);

CREATE TABLE authors
(
    id   uuid,
    name text PRIMARY KEY
);

-- CREATE TABLE books
-- (
--     id          BIGSERIAL NOT NULL PRIMARY KEY,
--     title       VARCHAR(128),
--     genre_id    BIGINT NOT NULL REFERENCES genres(id) ON DELETE CASCADE
-- );
--
-- CREATE TABLE books_authors
-- (
--     book_id           BIGINT NOT NULL REFERENCES books(id) ON DELETE CASCADE,
--     author_id         BIGINT NOT NULL REFERENCES authors(id) ON DELETE CASCADE
-- );
--
-- CREATE TABLE comments
-- (
--     id      BIGSERIAL PRIMARY KEY,
--     book_id BIGINT REFERENCES BOOKS(id) ON DELETE CASCADE,
--     text    TEXT CHECK(length(text) <= 4096) NOT NULL
-- );