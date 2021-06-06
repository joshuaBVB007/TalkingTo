package com.example.firebase_chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebase_chat.fichero_chat.Chat;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class CrearReunionFragment extends Fragment {
    View V;
    EditText nom;
    EditText pass;
    Button crear;
    DatabaseReference mData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        V= inflater.inflate(R.layout.fragment_crear_reunion, container, false);

        nom=V.findViewById(R.id.nombre_reunion);
        pass=V.findViewById(R.id.password);
        crear=V.findViewById(R.id.crear_button);
        mData=FirebaseDatabase.getInstance().getReference();

        //metodo que ingresa jsons en firebase
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre_del_chat=nom.getText().toString();
                String pass_chat=pass.getText().toString();
                //Crea el chat padre
                mData.child("conversaciones").child(nombre_del_chat).setValue(new Chat(nombre_del_chat,pass_chat));
                //Crea el chat hijo que contiene la conversacio donde se almacenarán los mensajes.
                mData.child("conversaciones").child(nombre_del_chat)
                        .child("Mensajes").child("Bienvenidos")
                        .setValue(new Chat(nombre_del_chat,"Default","Bienvenidos a la reunion:"));
                Toast.makeText(getContext(),"Reunión creada con éxito",Toast.LENGTH_SHORT).show();
            }
        });

        return V;
    }
}