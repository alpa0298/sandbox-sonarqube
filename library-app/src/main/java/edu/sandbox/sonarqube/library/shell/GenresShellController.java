package edu.sandbox.sonarqube.library.shell;

import edu.sandbox.sonarqube.library.domain.Genre;
import edu.sandbox.sonarqube.library.services.GenresService;
import edu.sandbox.sonarqube.library.shell.argumentmappers.GenreArgumentMapper;
import edu.sandbox.sonarqube.library.shell.responsemappers.ToStringResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

import static java.lang.String.format;

/*
    Example commands:
        g
        g_ids -ids 1,2,3
        g_id 1
        c_g new-genre
        u_g -i 1 -n changed_genre
        d_g_id 5
 */
@ShellComponent
@RequiredArgsConstructor
public class GenresShellController {

    private final GenresService genresService;
    private final GenreArgumentMapper genreArgumentMapper;
    private final ToStringResponseMapper<Genre> genreToStringResponseMapper;

    @ShellMethod(value = "Finds all genres", key = {"genres", "g"})
    public String findAll() {
        return genreToStringResponseMapper.map(genresService.findAll());
    }

    @ShellMethod(value = "Finds all genres by id", key = {"genres_by_id", "g_ids"})
    public String findAllById(@ShellOption("-ids") List<String> genreIds) {
        return genreToStringResponseMapper.map(genresService.findAllById(genreIds));
    }

    @ShellMethod(value = "Finds genre by id", key = {"genre_by_id", "g_id"})
    public String findById(@ShellOption("-i") String id) {
        return genresService.findById(id)
                .map(genreToStringResponseMapper::map)
                .orElse(format("Can't find genre by id %s", id));
    }

    @ShellMethod(value = "Creates genre", key = {"create_genre", "c_g"})
    public String create(@ShellOption("-n") String name) {
        edu.sandbox.sonarqube.library.domain.Genre genre = genreArgumentMapper.map(name);
        return genreToStringResponseMapper.map(genresService.save(genre));
    }

    @ShellMethod(value = "Updates genre", key = {"update_genre", "u_g"})
    public String update(@ShellOption("-i") String id, @ShellOption("-n") String name) {
        edu.sandbox.sonarqube.library.domain.Genre genre = genreArgumentMapper.map(id, name);
        return genreToStringResponseMapper.map(genresService.save(genre));
    }

    @ShellMethod(value = "Deletes genre by id", key = {"delete_genre_by_id", "d_g_id"})
    public void deleteById(@ShellOption("-i") String id) {
        genresService.deleteById(id);
    }
}
