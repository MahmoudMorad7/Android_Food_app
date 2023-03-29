package com.example.wagbaapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wagbaapp.adapters.HomeHorAdapter;
import com.example.wagbaapp.adapters.HomeVerAdapter;
import com.example.wagbaapp.adapters.UpdateVerticalRec;
import com.example.wagbaapp.models.HomeHorModel;
import com.example.wagbaapp.models.HomeVerModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menu extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Menu.
     */
    // TODO: Rename and change types and number of parameters
    public static Menu newInstance(String param1, String param2) {
        Menu fragment = new Menu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    RecyclerView homeHorizontalRec,homeVerticalRec;
    DatabaseReference Datarefhor,Datarefver;
    FirebaseRecyclerOptions<restaurants> options;
    FirebaseRecyclerOptions<dishes> doptions;
    FirebaseRecyclerAdapter<restaurants,MyViewHolder> adapter;
    FirebaseRecyclerAdapter<dishes,DishViewHolder> dadapter;
    String ID="";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_menu, container, false);
        homeHorizontalRec=root.findViewById(R.id.home_hor_rec);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setNestedScrollingEnabled(false);
        homeHorizontalRec.setHasFixedSize(true);
        Datarefhor= FirebaseDatabase.getInstance().getReference().child("Restaurant");

        homeVerticalRec=root.findViewById(R.id.home_ver_rec);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        homeVerticalRec.setNestedScrollingEnabled(false);
        Datarefver=FirebaseDatabase.getInstance().getReference().child("Dishes");

        loadres();
        return root;
    }
    private void loadres(){
        options=new FirebaseRecyclerOptions.Builder<restaurants>().setQuery(Datarefhor,restaurants.class).build();
        adapter=new FirebaseRecyclerAdapter<restaurants, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull restaurants model) {
                holder.Name.setText(model.getName());
                Picasso.get().load(model.getIcon()).into(holder.Icon);
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ID=adapter.getRef(holder.getAdapterPosition()).getKey();
                        loaddish(ID);
                    }
                });
            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_items, parent, false);
                return new MyViewHolder(view);
            }
        };

        adapter.startListening();
        homeHorizontalRec.setAdapter(adapter);
    }

    private void loaddish(String ResID){
        doptions=new FirebaseRecyclerOptions.Builder<dishes>().setQuery(Datarefver.orderByChild("ResID").equalTo(ResID),dishes.class).build();
        dadapter=new FirebaseRecyclerAdapter<dishes, DishViewHolder>(doptions) {
            @Override
            protected void onBindViewHolder(@NonNull DishViewHolder holder, int position, @NonNull dishes model) {
                holder.Name.setText(model.getName());
                holder.Price.setText(model.getPrice());
                holder.Time.setText(model.getTime());
                Picasso.get().load(model.getIcon()).into(holder.Icon);
            }

            @NonNull
            @Override
            public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_items, parent, false);
                return new DishViewHolder(view);
            }
        };

        dadapter.startListening();
        homeVerticalRec.setAdapter(dadapter);
    }
}