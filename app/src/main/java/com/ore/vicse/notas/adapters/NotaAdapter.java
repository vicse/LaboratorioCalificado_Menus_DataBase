package com.ore.vicse.notas.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ore.vicse.notas.R;
import com.ore.vicse.notas.models.Nota;
import com.ore.vicse.notas.repositories.NotaRepository;

import java.util.List;

public class NotaAdapter  extends RecyclerView.Adapter<NotaAdapter.ViewHolder> {

    private List<Nota> notas;

    public NotaAdapter(List<Nota> notas) {
        this.notas = notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public TextView tittle,contenido;
        public ImageView btnDelete;

        public ViewHolder(View view){
            super(view);

            tittle = (TextView) view.findViewById(R.id.tittle_text);
            contenido= (TextView) view.findViewById(R.id.contenido_text);
            btnDelete= (ImageView) view.findViewById(R.id.btn_delete);
        }

    }


    @NonNull
    @Override
    public NotaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotaAdapter.ViewHolder viewHolder,final int position) {
        final Nota nota = this.notas.get(position);
        viewHolder.tittle.setText(nota.getTittle());
        viewHolder.contenido.setText(nota.getContenido());

        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotaRepository.delete(nota.getId());
                notas.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount());
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.notas.size();
    }
}
