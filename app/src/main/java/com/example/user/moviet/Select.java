package com.example.user.moviet;

import android.util.Log;

public class Select {

//    String myUser;
    String myCinema;
    String myGenre;
    String myDate;

    public Select(){ }

    public Select(String cinema, String genre, String date ){
        this.myCinema=cinema;
        this.myGenre=genre;
        this.myDate=date;
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



}
