package com.sg.dvdLibrary.dao;

import com.sg.dvdLibrary.dto.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    private Map<String, Movie> dvdLibrary = new HashMap<>();

    @Override
    public void addMovie(Movie movie) {
        dvdLibrary.put(movie.getTitle(), movie);
    }

    @Override
    public void removeDVD(String title) {
        dvdLibrary.remove(title);
    }

    @Override
    public List<Movie> getAllDVDs() {
        return new ArrayList<>(dvdLibrary.values());
    }

    @Override
    public List<Movie> findMoviesReleasedInLastNYears(int n) {
        int currentYear = java.time.Year.now().getValue();
        return dvdLibrary.values().stream()
                .filter(movie -> currentYear - movie.getReleaseYear() <= n)
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> findMoviesByMPAARating(String rating) {
        return dvdLibrary.values().stream()
                .filter(movie -> movie.getMpaaRating().equals(rating))
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> findMoviesByDirector(String director) {
        return dvdLibrary.values().stream()
                .filter(movie -> movie.getDirector().equals(director))
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> findMoviesByStudio(String studio) {
        return dvdLibrary.values().stream()
                .filter(movie -> movie.getStudio().equals(studio))
                .collect(Collectors.toList());
    }

    @Override
    public double averageAgeOfMovies() {
        int currentYear = java.time.Year.now().getValue();
        return dvdLibrary.values().stream()
                .mapToInt(movie -> currentYear - movie.getReleaseYear())
                .average()
                .orElse(0);
    }

    @Override
    public Movie findNewestMovie() {
        return dvdLibrary.values().stream()
                .max(java.util.Comparator.comparingInt(Movie::getReleaseYear))
                .orElse(null);
    }

    @Override
    public Movie findOldestMovie() {
        return dvdLibrary.values().stream()
                .min(java.util.Comparator.comparingInt(Movie::getReleaseYear))
                .orElse(null);
    }

    @Override
    public double averageNumberOfNotes() {
        return dvdLibrary.values().stream()
                .mapToInt(Movie::getNotes)
                .average()
                .orElse(0);
    }
}
