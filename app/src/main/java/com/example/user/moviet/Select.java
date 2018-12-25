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

    public void Print(){
        Log.d("My Print is: ",this.myGenre);
        Log.d(this.myCinema,this.myDate);
    }

}
