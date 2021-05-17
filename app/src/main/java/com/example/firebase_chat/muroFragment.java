package com.example.firebase_chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firebase_chat.Adaptador.MyAdapterChat;


public class muroFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View V=inflater.inflate(R.layout.fragment_muro, container, false);

        RecyclerView r=V.findViewById(R.id.recy_muro);
        MyAdapterChat adapter=new MyAdapterChat(getContext(),Menu.lista_chats);
        r.setAdapter(adapter);
        r.setLayoutManager(new LinearLayoutManager(getContext()));


       return V;
    }
}