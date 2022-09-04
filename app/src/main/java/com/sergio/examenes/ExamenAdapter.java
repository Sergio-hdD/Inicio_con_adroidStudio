package com.sergio.examenes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExamenAdapter extends RecyclerView.Adapter<ExamenAdapter.ExamenViewHolder> {

    List<Examen> examenes;


    OnItemClickListener onItemClickListener;


    interface OnItemClickListener{
        void onItemClick(Examen examen);
    }

    //Constructor
    public ExamenAdapter(List<Examen> examenes, OnItemClickListener onItemClickListener) {
        this.examenes = examenes;
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ExamenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemExamen = LayoutInflater
                .from(parent.getContext())//parent porque es interno
                .inflate(R.layout.item_examen, parent, false);//Inflate rellena
        return new ExamenViewHolder(itemExamen);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamenViewHolder holder, int position) {
        int posAux = position;
        holder.materia.setText(examenes.get(position).getMateria());//Cargo el texto
        holder.fecha.setText((CharSequence) examenes.get(position).getFecha());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(examenes.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return examenes.size();
    }

    public class ExamenViewHolder extends RecyclerView.ViewHolder {
        TextView materia;
        TextView fecha;

        public ExamenViewHolder(View item){
            super(item);
            materia = (TextView) item.findViewById(R.id.txtMateria);
            fecha = (TextView) item.findViewById(R.id.txtFecha);
        }
    }

}
