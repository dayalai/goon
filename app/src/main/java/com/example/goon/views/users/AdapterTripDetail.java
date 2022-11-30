package com.example.goon.views.users;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.example.goon.R;
import com.example.goon.models.Trips;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterTripDetail extends RecyclerView.Adapter<AdapterTripDetail.MyViewHolder> {
    Context context;
    List<Trips> tripsList= new ArrayList<>();

    public AdapterTripDetail(Context context, List<Trips> tripsList) {
        this.context = context;
        this.tripsList = tripsList;
    }

    @NonNull
    @Override
    public AdapterTripDetail.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rows_trips_details,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTripDetail.MyViewHolder holder, int position) {
        //holder.row
    }

    @Override
    public int getItemCount() {
        return tripsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageButton btnBack;
        Button btnTakeTrip;
        LinearLayout row;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            btnBack=itemView.findViewById(R.id.btnBackTripDetail);
            btnTakeTrip=itemView.findViewById(R.id.btnTakeTrip);
            row =itemView.findViewById(R.id.rowTripsDetail);
        }
    }
}
