package com.sg.dvdLibrary.dao;

import com.sg.dvdLibrary.dto.Movie;

import java.util.List;
import java.util.Map;

public interface DVDLibraryDao {
    void addMovie(Movie movie);

    void removeDVD(String title);
    List<Movie> getAllDVDs();
    List<Movie> findMoviesReleasedInLastNYears(int n);
    List<Movie> findMoviesByMPAARating(String rating);
    List<Movie> findMoviesByDirector(String director);
    List<Movie> findMoviesByStudio(String studio);
    double averageAgeOfMovies();
    Movie findNewestMovie();
    Movie findOldestMovie();
    double averageNumberOfNotes();
}
