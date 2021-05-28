package com.example.firebase_chat.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firebase_chat.R;
import java.util.ArrayList;

public class MyAdapterChatsDesbloqueados extends RecyclerView.Adapter<MyAdapterChatsDesbloqueados.MyViewHolder> {

    ArrayList<String> lista;
    Context con;

    public MyAdapterChatsDesbloqueados(Context con,ArrayList<String> lista){
        this.con=con;
        this.lista=lista;
    }

    @NonNull
    @Override
    public MyAdapterChatsDesbloqueados.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(con);
        View V=inflater.inflate(R.layout.my_chats_desbloqueados,parent,false);
        return new MyAdapterChatsDesbloqueados.MyViewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterChatsDesbloqueados.MyViewHolder holder, int position) {
       holder.nom.setText(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nom;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nom=itemView.findViewById(R.id.nom_reunion);
        }
    }


}
