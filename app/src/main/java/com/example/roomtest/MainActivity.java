package com.example.roomtest;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String DATABASE_NAME = "movies_db";
    private MovieDatabase movieDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        movieDatabase =       Room.databaseBuilder(getApplicationContext(),
                MovieDatabase.class, DATABASE_NAME)
                .fallbackToDesctructiveMigration()
                .build();
    }

    new Thread(new Runnable() {
        @Override
        public void run() {
            Movies movie =new Movies();
            movie.setMovieId( "2");
            movie.setMovieName("The Prestige");
            movieDatabase.daoAccess () . insertOnlySingleMovie (movie);
        }
    }) .start();
}
