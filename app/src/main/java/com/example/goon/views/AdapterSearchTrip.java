package com.example.goon.views;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.goon.R;
import com.example.goon.models.Trips;
import com.example.goon.views.users.TripDetail;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterSearchTrip extends RecyclerView.Adapter<AdapterSearchTrip.MyHolderViews> {
    private Context context;
    private List<Trips> tripsList= new ArrayList<>();
    public AdapterSearchTrip(Context context, List<Trips> tripsList) {
        this.context = context;
        this.tripsList = tripsList;
    }



    @NonNull
    @Override
    public AdapterSearchTrip.MyHolderViews onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.rows_trips,parent,false);
        return new MyHolderViews(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSearchTrip.MyHolderViews holder, int position) {
        //holder.title.setText(tripsList.get(position).getpaaaaa().toos);
           holder.rowTrips.setOnLongClickListener(view -> {
               Intent intent= new Intent(context,TripDetail.class);
               //intent.putExtra("@id",tripsList.get(position).getClass())
               context.startActivity(intent);
               return false;
           });
    }

    @Override
    public int getItemCount() {
        return tripsList.size();
    }

    public static class MyHolderViews extends RecyclerView.ViewHolder {
        TextView title, price, dateTime, departure, arrival;
        ImageView image;
        LinearLayout rowTrips;
        public MyHolderViews(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.textTitle);
            price= itemView.findViewById(R.id.textPrice);
            dateTime= itemView.findViewById(R.id.textDateTime);
            departure= itemView.findViewById(R.id.textDeparture);
            arrival= itemView.findViewById(R.id.textArrival);
            rowTrips=itemView.findViewById(R.id.rowTrips);
        }
    }
}
