package com.example.wagbaapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView Icon;
    TextView Name;
    CardView cardView;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        Icon=itemView.findViewById(R.id.pizzahut);
        Name=itemView.findViewById(R.id.pizzahuttext);
        cardView=itemView.findViewById(R.id.cardView);

    }
}