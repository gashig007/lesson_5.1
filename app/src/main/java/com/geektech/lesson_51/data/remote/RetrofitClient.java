package com.geektech.lesson_51.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private Retrofit retrofit = new Retrofit.Builder().baseUrl("https://ghibliapi.herokuapp.com/films")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public FilmApi createFilmApi(){
        return retrofit.create(FilmApi.class);
    }
}

