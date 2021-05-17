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


public class OtroFragment extends Fragment {
    View V;
    DatabaseReference mData= FirebaseDatabase.getInstance().getReference();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        V= inflater.inflate(R.layout.fragment_otro, container, false);

        EditText nom=V.findViewById(R.id.nombre_reunion);
        EditText pass=V.findViewById(R.id.password);
        Button crear=V.findViewById(R.id.crear_button);



        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Menu.lista_chats.clear();
                String nom_chat=nom.getText().toString();
                String pass_chat=pass.getText().toString();
                mData.child("conversaciones").child(pass_chat).setValue(new Chat(nom_chat,pass_chat));
                Menu.Lista_contraseñas.add(pass_chat);
            }
        });

        return V;
    }
}