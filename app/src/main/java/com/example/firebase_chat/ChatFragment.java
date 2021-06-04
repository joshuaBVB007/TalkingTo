package com.example.firebase_chat;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firebase_chat.Adaptador.MyAdapterChatMuro;
import com.example.firebase_chat.Adaptador.MyAdapterChatsDesbloqueados;
import com.example.firebase_chat.DB.ChatFavoritos;

import java.util.ArrayList;

public class ChatFragment extends Fragment {
    /*esta lista la declaramos como estatica porque hacemos uso d ella en otra clase(MyadapterMuro)
    * donde si el usuario ingresa la contraseña correcta desbloquea esa conversacion y la anadimos desde alla para aqui*/
    //public static ArrayList<String> lista_chats_desbloqueados=new ArrayList<>();
    ChatFavoritos dbhelper;
    SQLiteDatabase db;
    public static RecyclerView r;
    public static MyAdapterChatsDesbloqueados adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dbhelper=new ChatFavoritos(getContext());
        db=dbhelper.getReadableDatabase();
        View V=inflater.inflate(R.layout.fragment_chat, container, false);
        r=V.findViewById(R.id.recy_chats);
        adapter=new MyAdapterChatsDesbloqueados(getContext(),ChatFavoritos.getAllIncidencies(db));
        r.setAdapter(adapter);
        r.setLayoutManager(new LinearLayoutManager(getContext()));
        return V;

    }
}