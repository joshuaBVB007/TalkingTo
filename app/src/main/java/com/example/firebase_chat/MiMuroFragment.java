package com.example.firebase_chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firebase_chat.Adaptador.MyAdapterChatMuro;


public class MiMuroFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*Lo unico que hace este fragment es lanzar nuestra vista que contiene todas las conversaciones
        * de esta aplicaciony que se reflejan en el muro*/
        View V=inflater.inflate(R.layout.fragment_muro, container, false);
        RecyclerView r=V.findViewById(R.id.recy_muro);
        MyAdapterChatMuro adapter=new MyAdapterChatMuro(getContext(),Menu.lista_chats);
        r.setAdapter(adapter);
        r.setLayoutManager(new LinearLayoutManager(getContext()));
        return V;
    }
}