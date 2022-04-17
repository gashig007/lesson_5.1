package com.geektech.lesson_51.ui.film_list;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.icu.text.Transliterator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.lesson_51.R;
import com.geektech.lesson_51.data.models.Film;
import com.geektech.lesson_51.databinding.FragmentFilmBinding;
import com.geektech.lesson_51.ui.App;
import com.geektech.lesson_51.ui.OnClick;
import com.geektech.lesson_51.ui.film_detali.FilmDetailFragment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmFragment extends Fragment implements OnClick {
    private FragmentFilmBinding binding;
    private FilmsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FilmsAdapter();
        adapter.setOnClick(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recycler.setAdapter(adapter);
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null){
                    adapter.setFilms(response.body());
                }else {
                    Snackbar.make(binding.getRoot(), response.message(),
                            BaseTransientBottomBar.LENGTH_LONG)
                            .setBackgroundTint(Color.RED)
                            .show();
                }
            }


            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                Snackbar.make(binding.getRoot(), t.getLocalizedMessage(),
                        BaseTransientBottomBar.LENGTH_LONG)
                        .setBackgroundTint(Color.RED)
                        .show();
            }
        });
    }

    @Override
    public void onClick(Film film) {
        String id = film.getId();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        Navigation.findNavController(requireView()).navigate(R.id.action_filmFragment_to_filmDetailFragment, bundle);
    }
}