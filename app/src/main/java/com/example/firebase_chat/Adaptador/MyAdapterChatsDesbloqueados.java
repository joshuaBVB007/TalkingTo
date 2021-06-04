package com.example.firebase_chat.Adaptador;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.firebase_chat.ChatFragment;
import com.example.firebase_chat.DB.ChatFavoritos;
import com.example.firebase_chat.Menu;
import com.example.firebase_chat.R;
import com.example.firebase_chat.WindowsChat;
import com.example.firebase_chat.fichero_chat.Chat;

import java.util.ArrayList;

import static com.example.firebase_chat.ChatFragment.r;

public class MyAdapterChatsDesbloqueados extends RecyclerView.Adapter<MyAdapterChatsDesbloqueados.MyViewHolder> {

    ArrayList<Chat> lista;
    Context con;
    AppCompatActivity activity;
    public ChatFavoritos dbhelper;
    public SQLiteDatabase db;

    public MyAdapterChatsDesbloqueados(Context con,ArrayList<Chat> lista){
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
       holder.nom.setText(lista.get(position).getNombre_reu());
       //Ponemos la vista a la escucha.
       holder.bote_basura.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Menu.dbhelper.Eliminar_Incidencia_ID(Menu.db,Integer.parseInt(lista.get(position).getNombre_reu()));
               //solucion guarra
               AppCompatActivity activity = (AppCompatActivity)v.getContext();
               activity.recreate();
               Log.i("hemos eliminado", ""+lista.get(position).nombre_reu);
           }
       });

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(activity.getApplication(), WindowsChat.class);
               intent.putExtra("DeQueConversacionSeTrata",lista.get(position).getContrasena_reu());
               activity.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nom;
        ImageView bote_basura;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nom=itemView.findViewById(R.id.nom_reunion);
            bote_basura=itemView.findViewById(R.id.bote_de_basura);
        }
    }


}
