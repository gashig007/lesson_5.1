package com.geektech.lesson_51.ui.film_list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geektech.lesson_51.R;
import com.geektech.lesson_51.data.models.Film;
import com.geektech.lesson_51.databinding.ItemFilmBinding;
import com.geektech.lesson_51.ui.OnClick;
import com.geektech.lesson_51.ui.film_detali.FilmDetailFragment;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmViewHolder> {
    private List<Film> films = new ArrayList<>();
    private OnClick onClick;
    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public List<Film> getFilms() {
        return films;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    protected class FilmViewHolder extends RecyclerView.ViewHolder {
        private ItemFilmBinding binding;

        public FilmViewHolder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Film film) {
            Glide.with(binding.getRoot()).load(film.getImage()).into(binding.image);
            binding.tvTitle.setText(film.getTitle());
            binding.tvDescription.setText(film.getDescription());
            binding.tvDirector.setText(film.getDirector());
            binding.tvProducer.setText(film.getProducer());
            binding.tvOriginalTitle.setText(film.getOriginalTitle());
            binding.tvReleaseData.setText(film.getReleaseDate());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClick.onClick(film);
                }
            });
        }
    }
}
