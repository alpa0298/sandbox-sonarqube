package edu.sandbox.sonarqube.library.shell;

import edu.sandbox.sonarqube.library.domain.Comment;
import edu.sandbox.sonarqube.library.services.CommentsService;
import edu.sandbox.sonarqube.library.shell.argumentmappers.CommentArgumentMapper;
import edu.sandbox.sonarqube.library.shell.responsemappers.ToStringResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import static java.lang.String.format;

/*
    Example commands:
        c
        c_b_id -i 1
        c_id 1
        c_c -b 1 -t new-comment
        u_c -i 1 -b 1 -t changed-text
        d_c_id 1
 */
@ShellComponent
@RequiredArgsConstructor
public class CommentsShellController {

    private final CommentsService commentsService;
    private final CommentArgumentMapper commentArgumentMapper;
    private final ToStringResponseMapper<Comment> commentToStringResponseMapper;

    @ShellMethod(value = "Finds all comments", key = {"comments", "c"})
    public String findAll() {
        return commentToStringResponseMapper.map(commentsService.findAll());
    }

    @ShellMethod(value = "Finds comments by book id", key = {"comments_by_book_id", "c_b_id"})
    public String findCommentsByBookId(@ShellOption("-i") String id) {
        return commentToStringResponseMapper.map(commentsService.findCommentsByBookId(id));
    }

    @ShellMethod(value = "Finds comment by id", key = {"comment_by_id", "c_id"})
    public String findById(@ShellOption("-i") String id) {
        return commentsService.findById(id)
                .map(commentToStringResponseMapper::map)
                .orElse(format("Can't find comment by id %s", id));
    }

    @ShellMethod(value = "Creates comment", key = {"create_comment", "c_c"})
    public String create(@ShellOption("-b") String bookId, @ShellOption("-t") String text) {
        edu.sandbox.sonarqube.library.domain.Comment comment = commentArgumentMapper.map(bookId, text);
        return commentToStringResponseMapper.map(commentsService.save(comment));
    }

    @ShellMethod(value = "Updates comment", key = {"update_comment", "u_c"})
    public String update(@ShellOption("-i") String id, @ShellOption("-b") String bookId, @ShellOption("-t") String text) {
        edu.sandbox.sonarqube.library.domain.Comment comment = commentArgumentMapper.map(id, bookId, text);
        return commentToStringResponseMapper.map(commentsService.save(comment));
    }

    @ShellMethod(value = "Deletes comment by id", key = {"delete_comment_by_id", "d_c_id"})
    public void deleteById(@ShellOption("-i") String id) {
        commentsService.deleteById(id);
    }
}
