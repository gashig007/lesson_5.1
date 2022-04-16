package com.geektech.lesson_51.ui;

import android.app.Application;

import com.geektech.lesson_51.data.remote.FilmApi;
import com.geektech.lesson_51.data.remote.RetrofitClient;

public class App extends Application {
    private RetrofitClient retrofitClient;
    public static FilmApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.createFilmApi();
    }

}
