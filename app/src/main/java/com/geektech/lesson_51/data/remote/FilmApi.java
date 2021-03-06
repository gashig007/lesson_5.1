package com.geektech.lesson_51.data.remote;

import com.geektech.lesson_51.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FilmApi {
    @GET("/films")
    Call<List<Film>> getFilms();

    @GET("/films/{id}")
    Call<Film> getFilmDetail(@Path("id") String id);

}
