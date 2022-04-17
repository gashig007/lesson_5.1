package com.geektech.lesson_51.ui.film_detali;

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

public class FilmDetailFragment extends Fragment {
    private FragmentFilmDetailBinding binding;
    Film film = new Film();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);binding.tvTitle.setText(film.getTitle());
        binding.tvDescription.setText(film.getDescription());
        Glide.with(binding.image).load(film.getImage());
        binding.tvDirector.setText(film.getDirector());
        binding.tvProducer.setText(film.getProducer());
        binding.tvOriginalTitle.setText(film.getOriginalTitle());
        binding.tvReleaseData.setText(film.getReleaseDate());
    }
}