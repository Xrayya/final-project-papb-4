package com.example.finalprojectpapb4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.List;

public class ReviewAdapter extends FirebaseRecyclerAdapter<ReviewModel, ReviewAdapter.ReviewViewHolder> {

    public ReviewAdapter(@NonNull FirebaseRecyclerOptions<ReviewModel> options) {
        super(options);
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_list, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ReviewViewHolder holder, int position, @NonNull ReviewModel model) {
        // Set data to views
        holder.locationTextView.setText(model.getLocation());
        holder.dateTextView.setText(model.getDate());
        holder.nameTextView.setText(model.getName());
        holder.reviewTextView.setText(model.getReview());
    }

    public static class ReviewViewHolder extends RecyclerView.ViewHolder {
        TextView locationTextView, dateTextView, nameTextView, reviewTextView;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            locationTextView = itemView.findViewById(R.id.tv_lokasi);
            dateTextView = itemView.findViewById(R.id.tv_date);
            nameTextView = itemView.findViewById(R.id.tv_nama);
            reviewTextView = itemView.findViewById(R.id.tv_review);
        }
    }
}