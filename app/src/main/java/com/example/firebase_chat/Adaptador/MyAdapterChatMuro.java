package com.example.firebase_chat.Adaptador;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase_chat.ChatFragment;
import com.example.firebase_chat.Menu;
import com.example.firebase_chat.R;
import com.example.firebase_chat.WindowsChat;
import com.example.firebase_chat.fichero_chat.Chat;

import java.util.ArrayList;

public class MyAdapterChatMuro extends RecyclerView.Adapter<MyAdapterChatMuro.MyViewHolder> {

    Context con;
    ArrayList<Chat> lista;


    public MyAdapterChatMuro(Context con, ArrayList<Chat> lista){
        this.con=con;
        this.lista=lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(con);
        View V=inflater.inflate(R.layout.my_chats_muro,parent,false);
        return new MyAdapterChatMuro.MyViewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterChatMuro.MyViewHolder holder, int position) {
        Chat dato=lista.get(position);
        holder.nom.setText(dato.getNombre_reu());
        holder.desc.setText(dato.getContrasena_reu());

        //Al clicar este boton nos abre un alert pidiendo la contraseña del chat
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(con);
                final EditText input = new EditText(con);
                input.setHint("Introduce su contraseña");
                alert.setView(input);
                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //si la contraseña introducida por el usuario es igual al dato contraseña del recycler entras
                        if(input.getText().toString().equals(dato.contrasena_reu)){

                            //Aqui necesitamos agregar el chat desbloqueado
                            ChatFragment.lista_chats_desbloqueados.add(dato.getNombre_reu());

                            AppCompatActivity activity = (AppCompatActivity)v.getContext();
                            Intent intent=new Intent(activity.getApplication(),WindowsChat.class);
                            intent.putExtra("DeQueConversacionSeTrata",dato.nombre_reu);
                            activity.startActivity(intent);

                        }else{

                            Toast.makeText(con,"Contraseña incorrecta",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //En caso de que el usuario clique en cancelar volverá el menu
                        AppCompatActivity activity = (AppCompatActivity)v.getContext();
                        Intent intent=new Intent(activity.getApplication(),Menu.class);
                        activity.startActivity(intent);
                    }
                });
                alert.show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nom;
        TextView desc;
        Button button;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nom=itemView.findViewById(R.id.nom_view);
            desc=itemView.findViewById(R.id.desc_view);
            button=itemView.findViewById(R.id.open_chat);
        }
    }
}
