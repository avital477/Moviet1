package com.example.user.moviet;

import android.util.Log;

public class Select {

//    String myUser;
    private String myCinema;
    private String myGenre;
    private String myDate;

    public Select(){ }

    public Select(String cinema, String genre, String date ){
        this.myCinema=cinema;
        this.myGenre=genre;
        this.myDate=date;
    }

    public void setMyCinema(String myCinema) {
        this.myCinema = myCinema;
    }

    public void setMyGenre(String myGenre) {
        this.myGenre = myGenre;
    }

    public void setMyDate(String myDate) {
        this.myDate = myDate;
    }

    public String getMyCinema(){
        return this.myCinema;
    }
    public String getMyDate(){
        return this.myDate;
    }
    public String getMyGenre(){
        return this.myGenre;
    }

    @Override
    public String toString() {
        return "Select{" +
                "myCinema='" + myCinema + '\'' +
                ", myGenre='" + myGenre + '\'' +
                ", myDate='" + myDate + '\'' +
                '}';
    }
}
