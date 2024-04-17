package com.sg.dvdLibrary.ui;

import com.sg.dvdLibrary.dto.Movie;

import java.util.List;

public class DVDLibraryView {
    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add Movie");
        io.print("2. View All Movies");
        io.print("3. Find Movies Released in Last N Years");
        io.print("4. Find Movies by MPAA Rating");
        io.print("5. Find Movies by Director");
        io.print("6. Find Movies by Studio");
        io.print("7. Display Average Age of Movies");
        io.print("8. Display Newest Movie");
        io.print("9. Display Oldest Movie");
        io.print("10. Display Average Number of Notes");
        io.print("11. Exit");
        return io.readInt("Please select from the above choices.", 1, 11);
    }
    public Movie getMovieInfo(){
        io.print("Add Address Menu");
        String title = io.readString("Please enter Title");
        int releaseYear = io.readInt("Please enter releaseYear");
        String director = io.readString("Please enter Director Name");
        String mpaaRating = io.readString("Please enter mpaaRating");
        String studio = io.readString("Please enter studio");
        int notes = io.readInt("Please enter num of notes");
        Movie newMovie = new Movie(title,releaseYear,director,mpaaRating,studio,notes);
        io.print("Address added.  Press 1 to go to Main Menu.");
        return newMovie;
    }

    public void displayAddMovieBanner(){
        io.print("=== Add Movie ===");
    }

    public void displayAllMoviesBanner(){
        io.print("=== Show All Movies ===");
    }
    public void displayMovies(List<Movie> movieDetails) {
        int index = 1;
        for (Movie currentItem : movieDetails) {
            io.print("[" + index + "] " +
                    "Title: " + currentItem.getTitle() +
                    ", Year Released: " + currentItem.getReleaseYear() +
                    ", Director: " + currentItem.getDirector() +
                    ", Studio: " + currentItem.getStudio() +
                    ", MPAA Rating: " + currentItem.getMpaaRating() +
                    ", Notes: " + currentItem.getNotes());
            index++;
        }
    }
    public int getNumberOfYears() {
        return io.readInt("Enter the number of years:");
    }

    public String getMPAARating() {
        return io.readString("Enter MPAA Rating:");
    }

    public String getDirector() {
        return io.readString("Enter Director Name:");
    }

    public String getStudio() {
        return io.readString("Enter Studio:");
    }


    public void displayAverageAgeOfMovies(double averageAge) {
        io.print("Average Age of Movies: " + averageAge);
    }

    public void displayNewestMovie(Movie newestMovie) {
        if (newestMovie == null) {
            io.print("No movies found.");
        } else {
            io.print("Newest Movie: " + newestMovie.getTitle() + " (" + newestMovie.getReleaseYear() + ")");
        }
    }

    public void displayOldestMovie(Movie oldestMovie) {
        if (oldestMovie == null) {
            io.print("No movies found.");
        } else {
            io.print("Oldest Movie: " + oldestMovie.getTitle() + " (" + oldestMovie.getReleaseYear() + ")");
        }
    }

    public void displayAverageNumberOfNotes(double averageNotes) {
        io.print("Average Number of Notes: " + averageNotes);
    }

    public void displayUnknownCommand() {
        io.print("Unknown Command.");
    }

    public void displayExitMessage() {
        io.print("Exiting...");
    }

    public void displayMovieAdded() {
        io.print("=== Movie Added ===");
    }
}
