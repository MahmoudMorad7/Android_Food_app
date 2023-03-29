package com.example.wagbaapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DishViewHolder extends RecyclerView.ViewHolder {
    ImageView Icon;
    TextView Name;
    TextView Price;
    TextView Time;
    TextView ResID;
    CardView cardView;


    public DishViewHolder(@NonNull View itemView){
        super(itemView);
        Icon=itemView.findViewById(R.id.ver_img);
        Name=itemView.findViewById(R.id.name);
        Price=itemView.findViewById(R.id.price);
        Time=itemView.findViewById(R.id.time);
        cardView=itemView.findViewById(R.id.cardView);
    }
}
