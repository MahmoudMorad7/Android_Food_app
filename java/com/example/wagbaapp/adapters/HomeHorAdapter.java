package com.example.wagbaapp.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wagbaapp.R;
import com.example.wagbaapp.models.HomeHorModel;
import com.example.wagbaapp.models.HomeVerModel;

import java.util.ArrayList;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.viewHolder> {
    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;

    boolean check=true;
    boolean select=true;
    int row_index=-1;


    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_items,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if(check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.supersupreme, "Super Supreme", "50 MINS", "100 EGP"));
            homeVerModels.add(new HomeVerModel(R.drawable.pepperoni, "Pepperoni Pizza", "45 MINS", "90 EGP"));
            homeVerModels.add(new HomeVerModel(R.drawable.chickenbbq, "chicken BBQ Pizza", "45 MINS", "70 EGP"));
            homeVerModels.add(new HomeVerModel(R.drawable.margherita, "Margherita", "30 MINS", "50 EGP"));

            updateVerticalRec.callback(position, homeVerModels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    row_index=position;
                    notifyDataSetChanged();

                    if(position==0){
                        ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.supersupreme,"Super Supreme","50 MINS","100 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pepperoni,"Pepperoni Pizza","45 MINS","90 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.chickenbbq,"chicken BBQ Pizza","45 MINS","70 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.margherita,"Margherita","30 MINS","50 EGP"));

                        updateVerticalRec.callback(position,homeVerModels);
                    }
                    else if(position==1){
                        ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.cheeseburger,"Cheese Burger","20 MINS","35 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.chickenmcdo,"Chicken McDo","25 MINS","30 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.mcchicken,"Mac Chicken","30 MINS","65 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.bigmac,"Big Mac","30 MINS","70 EGP"));

                        updateVerticalRec.callback(position,homeVerModels);
                    }
                    else if(position==2){
                        ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.famousstar,"Famous Star","25 MINS","40 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.superstar,"Super Star","30 MINS","60 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.chickenfillet,"Chicken Fillet","20 MINS","35 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.cordonbleu,"Cordon Bleu","30 MINS","55 EGP"));

                        updateVerticalRec.callback(position,homeVerModels);
                    }
                    else if(position==3){
                        ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.chocolate,"Chocolate Icecream","15 MINS","30 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.strawberry,"Strawberry Icecream","15 MINS","30 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.manga,"Mango Icecream","15 MINS","30 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.vanilla,"Vanilla Icecream","15 MINS","30 EGP"));

                        updateVerticalRec.callback(position,homeVerModels);
                    }
                    else if(position==4){
                        ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.frappuccino,"Original","20 MINS","35 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.mermaid,"mermaid Frappuccino","20 MINS","35 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.chocolatefrap,"Chocolate Fappuccino","20 MINS","40 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.lemon,"Lemon Frappuccino","20 MINS","40 EGP"));

                        updateVerticalRec.callback(position,homeVerModels);
                    }
                    else if(position==5){
                        ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.doublewhopper,"Double Whopper","25 MINS","50 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.doublewhoppercombo,"Double Whopper Combo","35 MINS","80 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.fries,"Fries","10 MINS","20 EGP"));

                        updateVerticalRec.callback(position,homeVerModels);
                    }
                    else if(position==6){
                        ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.chocolatedonuts,"Chocolate Donut","10 MINS","20 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.strawberrydonut,"Strawberry Donut","10 MINS","20 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.hazelnut,"Hazelnut Donut","10 MINS","20 EGP"));
                        homeVerModels.add(new HomeVerModel(R.drawable.icedcoffee,"Iced Coffee","10 MINS","15 EGP"));

                        updateVerticalRec.callback(position,homeVerModels);
                    }
                }
            });

            if(select){
                if(position ==0){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select=false;
                }
            }
            else {
                if(row_index==position){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }else {
                    holder.cardView.setBackgroundResource(R.drawable.defaultbg);
                }
            }
        }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        CardView cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.pizzahut);
            name=itemView.findViewById(R.id.pizzahuttext);
            cardView=itemView.findViewById(R.id.cardView);


        }
    }
}
