package com.example.firebase_chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firebase_chat.Adaptador.MyAdapterChatMuro;
import com.example.firebase_chat.fichero_chat.Chat;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MiMuroFragment extends Fragment {

    public  ArrayList<Chat> lista_chats=new ArrayList<>();
    RecyclerView r;
    View V;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*Lo unico que hace este fragment es lanzar nuestra vista que contiene todas las conversaciones
        * de esta aplicaciony que se reflejan en el muro*/
        V=inflater.inflate(R.layout.fragment_muro, container, false);
        //rellenamos el arraylist con los chats del firebase
        ingresarChatsDelMuro();
        //se lo pasamos al adapter pa que los lea

        return V;
    }

    public void ingresarChatsDelMuro(){
        //PARA DESCARGAR LOS CHATS Y RELLENAR LA LISTA
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("conversaciones");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        Chat dato=snapshot.getValue(Chat.class);
                        lista_chats.add(dato);
                    }
                    r=V.findViewById(R.id.recy_muro);
                    MyAdapterChatMuro adapter=new MyAdapterChatMuro(getContext(),lista_chats);
                    r.setAdapter(adapter);
                    r.setLayoutManager(new LinearLayoutManager(getContext()));
                }
                Log.i("T", "onDataChange: "+ lista_chats.size());
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("TAG_2", "Failed to read value.", error.toException());
            }
        });
    }


}