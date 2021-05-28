package com.example.firebase_chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firebase_chat.Adaptador.MyAdapterChatMuro;
import com.example.firebase_chat.Adaptador.MyAdapterChatsDesbloqueados;

import java.util.ArrayList;

public class ChatFragment extends Fragment {

    public static ArrayList<String> lista_chats_desbloqueados=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View V=inflater.inflate(R.layout.fragment_chat, container, false);
        RecyclerView r=V.findViewById(R.id.recy_chats);
        MyAdapterChatsDesbloqueados adapter=new MyAdapterChatsDesbloqueados(getContext(),lista_chats_desbloqueados);
        r.setAdapter(adapter);
        r.setLayoutManager(new LinearLayoutManager(getContext()));
        return V;

    }
}