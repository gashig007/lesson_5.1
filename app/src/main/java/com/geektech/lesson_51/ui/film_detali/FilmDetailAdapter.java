package com.geektech.lesson_51.ui.film_detali;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geektech.lesson_51.data.models.Film;
import com.geektech.lesson_51.databinding.ItemFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class FilmDetailAdapter extends RecyclerView.Adapter<FilmDetailAdapter.DetailHolder> {
    private List<Film> list = new ArrayList<>();

    public void setList(List<Film> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DetailHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class DetailHolder extends RecyclerView.ViewHolder {
        private ItemFilmBinding binding;

        public DetailHolder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Film film) {
            binding.tvDescription.setText(film.getDescription());
            binding.tvTitle.setText(film.getTitle());
            binding.tvDirector.setText(film.getDirector());
            binding.tvProducer.setText(film.getProducer());
            binding.tvOriginalTitle.setText(film.getOriginalTitle());
            binding.tvReleaseData.setText(film.getReleaseDate());
            Glide.with(binding.image).load(film.getImage()).into(binding.image);
        }
    }
}
