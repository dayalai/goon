package com.example.goon.views.driver;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goon.R;
import com.example.goon.models.Car;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorCar extends RecyclerView.Adapter<AdaptadorCar.MiviewHolder> {

    private Context context;
    private List<Car> listaCar = new ArrayList<>();

    public AdaptadorCar(Context context,List<Car> listaCar){
        this.context = context;
        this.listaCar = listaCar;
    }

    @NonNull
    @Override
    public AdaptadorCar.MiviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fila_veh,parent,false);
        return new MiviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCar.MiviewHolder holder, int position) {

        holder.filaPlaca.setText(listaCar.get(position).getPlaca());
        holder.filaMarca.setText(listaCar.get(position).getMarca());
        holder.filaModelo.setText(listaCar.get(position).getModelo());
        holder.filaAnio.setText(listaCar.get(position).getAnio());
        holder.fila.setOnLongClickListener(view -> {
            Intent intent = new Intent(context,MainCarActivity.class);
            intent.putExtra("p_id",listaCar.get(position).getUid()+"");
            intent.putExtra("p_placa",listaCar.get(position).getPlaca()+"");
            intent.putExtra("p_marca",listaCar.get(position).getMarca()+"");
            intent.putExtra("p_modelo",listaCar.get(position).getModelo()+"");
            intent.putExtra("p_anio",listaCar.get(position).getAnio()+"");
            context.startActivity(intent);
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return listaCar.size();
    }

    public class MiviewHolder extends RecyclerView.ViewHolder {
        TextView filaPlaca,filaModelo,filaMarca,filaAnio;
        LinearLayout fila;
        public MiviewHolder(@NonNull View itemView) {
            super(itemView);
            filaPlaca = itemView.findViewById(R.id.filaPlaca);
            filaModelo = itemView.findViewById(R.id.filaModelo);
            filaMarca = itemView.findViewById(R.id.filaMarca);
            filaAnio = itemView.findViewById(R.id.filaAnio);

            fila = itemView.findViewById(R.id.fila_veh);
        }
    }
}
