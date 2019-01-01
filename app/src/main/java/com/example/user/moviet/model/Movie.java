package com.example.user.moviet.model;

public class Movie {
    private String name;
    private String dateAndTime;
    private int cost;
    private String genre;
    private String theater;

    public Movie(){}

    public Movie(String name, String dateAndTime, int cost, String genre, String theater) {
        this.name = name;
        this.dateAndTime = dateAndTime;
        this.cost = cost;
        this.genre = genre;
        this.theater = theater;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", dateAndTime='" + dateAndTime + '\'' +
                ", cost=" + cost +
                ", genre='" + genre + '\'' +
                ", theater='" + theater + '\'' +
                '}';
    }
}
