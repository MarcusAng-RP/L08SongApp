package sg.edu.rp.c346.id22002222.songapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;

public class Song implements Serializable {

    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(int id , String title, String singers, int year, int stars) {
        this.id = id;
        this.title = title ;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public String getSingers() { return singers;}

    public int getYear() { return year;}

    public int getStars() { return stars;}

    public void starRating(int Stars){

        for(int i = 0 ; i < Stars; i++){
            System.out.println("* ");

        }

    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String toString() {
        String message = "";
        for(int i = 0 ; i < stars; i++){
            message += "*";


        }
        return   title + "\n" + singers  + "-" + year + "\n" + message  ;
    }




}
