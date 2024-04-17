package com.sg.dvdLibrary.controller;

import com.sg.dvdLibrary.dao.DVDLibraryDao;
import com.sg.dvdLibrary.dto.Movie;
import com.sg.dvdLibrary.ui.DVDLibraryView;

import java.util.List;

public class DVDController {

    private DVDLibraryDao dao;
    private DVDLibraryView view;

    public DVDController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        while (keepGoing) {
            menuSelection = getMenuSelection();
            switch (menuSelection) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    getAllMovies();
                    break;
                case 3:
                    findMoviesReleasedInLastNYears();
                    break;
                case 4:
                    findMoviesByMPAARating();
                    break;
                case 5:
                    findMoviesByDirector();
                    break;
                case 6:
                    findMoviesByStudio();
                    break;
                case 7:
                    displayAverageAgeOfMovies();
                    break;
                case 8:
                    displayNewestMovie();
                    break;
                case 9:
                    displayOldestMovie();
                    break;
                case 10:
                    displayAverageNumberOfNotes();
                    break;
                case 11:
                    keepGoing = false;
                    break;
                default:
                    view.displayUnknownCommand();
            }
        }
        view.displayExitMessage();
    }

    private void addMovie() {
        view.displayAddMovieBanner();
        Movie newMovie = view.getMovieInfo();
        dao.addMovie(newMovie);
        view.displayMovieAdded();
    }

    private void getAllMovies() {
        view.displayAllMoviesBanner();
        List<Movie> movieDetails = dao.getAllDVDs();
        view.displayMovies(movieDetails);
    }

    private void findMoviesReleasedInLastNYears() {
        int n = view.getNumberOfYears();
        List<Movie> movies = dao.findMoviesReleasedInLastNYears(n);
        view.displayMovies(movies);
    }

    private void findMoviesByMPAARating() {
        String rating = view.getMPAARating();
        List<Movie> movies = dao.findMoviesByMPAARating(rating);
        view.displayMovies(movies);
    }

    private void findMoviesByDirector() {
        String director = view.getDirector();
        List<Movie> movies = dao.findMoviesByDirector(director);
        view.displayMovies(movies);
    }

    private void findMoviesByStudio() {
        String studio = view.getStudio();
        List<Movie> movies = dao.findMoviesByStudio(studio);
        view.displayMovies(movies);
    }

    private void displayAverageAgeOfMovies() {
        double averageAge = dao.averageAgeOfMovies();
        view.displayAverageAgeOfMovies(averageAge);
    }

    private void displayNewestMovie() {
        Movie newestMovie = dao.findNewestMovie();
        view.displayNewestMovie(newestMovie);
    }

    private void displayOldestMovie() {
        Movie oldestMovie = dao.findOldestMovie();
        view.displayOldestMovie(oldestMovie);
    }

    private void displayAverageNumberOfNotes() {
        double averageNotes = dao.averageNumberOfNotes();
        view.displayAverageNumberOfNotes(averageNotes);
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
}
