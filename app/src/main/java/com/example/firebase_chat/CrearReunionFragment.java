package com.example.firebase_chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.firebase_chat.fichero_chat.Chat;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class CrearReunionFragment extends Fragment {
    View V;
    DatabaseReference mData= FirebaseDatabase.getInstance().getReference();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        V= inflater.inflate(R.layout.fragment_crear_reunion, container, false);

        EditText nom=V.findViewById(R.id.nombre_reunion);
        EditText pass=V.findViewById(R.id.password);
        Button crear=V.findViewById(R.id.crear_button);



        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre_del_chat=nom.getText().toString();
                String pass_chat=pass.getText().toString();

                //Creamos el chat en forebase con el nombre de que le de el usuario
                mData.child("conversaciones").child(nombre_del_chat).setValue(new Chat(nombre_del_chat,pass_chat));

                /*creamos el chat interno:contiene las propiedades de mi chat que son nombre,clavey la conversacion
                interna que siempre se llamará mensajes mas un json hijo que se llama Bienvenidos y un objeto que es mi
                mensaje inicial para que el json se cree*/
                mData.child("conversaciones").child(nombre_del_chat)
                        .child("Mensajes").child("Bienvenidos").setValue(new Chat(nombre_del_chat,"Default","Default"));

            }
        });

        return V;
    }
}