package com.example.goon.views;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.goon.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterSearchTrip extends RecyclerView.Adapter<AdapterSearchTrip.MyHolderViews> {
    @NonNull
    @Override
    public AdapterSearchTrip.MyHolderViews onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSearchTrip.MyHolderViews holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyHolderViews extends RecyclerView.ViewHolder {
        TextView title, price, dateTime, departure, arrival;
        ImageView image;
        public MyHolderViews(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.textTitle);
            price= itemView.findViewById(R.id.textPrice);
            dateTime= itemView.findViewById(R.id.textDateTime);
            departure= itemView.findViewById(R.id.textDeparture);
            arrival= itemView.findViewById(R.id.textArrival);
        }
    }
}
