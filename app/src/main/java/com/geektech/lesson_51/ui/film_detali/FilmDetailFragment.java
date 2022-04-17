package com.geektech.lesson_51.ui.film_detali;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.geektech.lesson_51.R;
import com.geektech.lesson_51.data.models.Film;
import com.geektech.lesson_51.databinding.FragmentFilmDetailBinding;
import com.geektech.lesson_51.ui.App;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmDetailFragment extends Fragment {
    private FragmentFilmDetailBinding binding;
    private FilmDetailAdapter adapter;
    Film film = new Film();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new FilmDetailAdapter();
        binding.recycler.setAdapter(adapter);
        Bundle bundle = getArguments();
        String id = bundle.getString("id");
        App.api.getFilmDetail(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null){
                    adapter.setList(Collections.singletonList(response.body()));
                }else {
                    Snackbar.make(binding.getRoot(), response.message(),
                            BaseTransientBottomBar.LENGTH_LONG)
                            .setBackgroundTint(Color.RED)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });
    }
}