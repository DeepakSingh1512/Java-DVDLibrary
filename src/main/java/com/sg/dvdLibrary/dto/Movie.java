package com.sg.dvdLibrary.dto;

public class Movie {


    private String title;
    private int releaseYear;
    private String director;
    private String mpaaRating;
    private String studio;
    private int notes;

    // Constructor
    public Movie(String title, int releaseYear, String director, String mpaaRating, String studio, int notes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
        this.mpaaRating = mpaaRating;
        this.studio = studio;
        this.notes = notes;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getNotes() {
        return notes;
    }

    public void setNotes(int notes) {
        this.notes = notes;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "MovieDTO{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", director='" + director + '\'' +
                ", mpaaRating='" + mpaaRating + '\'' +
                ", studio='" + studio + '\'' +
                ", notes=" + notes +
                '}';
    }
}
