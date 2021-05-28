package com.example.firebase_chat.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase_chat.R;
import com.example.firebase_chat.fichero_chat.Chat;

import java.util.ArrayList;

public class MyAdapterMensajes extends RecyclerView.Adapter<MyAdapterMensajes.MyViewHolder> {

    Context con;
    ArrayList<Chat> lista;
    public MyAdapterMensajes(Context con,ArrayList<Chat> lista){
        this.con=con;
        this.lista=lista;
    }

    @NonNull
    @Override
    public MyAdapterMensajes.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(con);
        View V=inflater.inflate(R.layout.my_mensajes_de_los_chats_internos,parent,false);
        return new MyAdapterMensajes.MyViewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterMensajes.MyViewHolder holder, int position) {
        Chat dato=lista.get(position);
        holder.contenido.setText(dato.getNombre_reu());
        holder.usuario_que_lo_envia.setText(dato.getContenido());
    }

    @Override
    public int getItemCount() { return lista.size();}

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView contenido;
        TextView usuario_que_lo_envia;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            contenido=itemView.findViewById(R.id.contenido);
            usuario_que_lo_envia=itemView.findViewById(R.id.usuario_que_lo_envia);
        }
    }
}
