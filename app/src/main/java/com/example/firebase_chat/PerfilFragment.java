package com.example.firebase_chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilFragment extends Fragment {

    TextView current_u;
    EditText nickname_edit;
    Button button_establecerNick;
    Button button_quitarNick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V= inflater.inflate(R.layout.fragment_perfil, container, false);

        //aqui van los componentes de esta vista
        current_u=V.findViewById(R.id.currentuser);
        nickname_edit=V.findViewById(R.id.nickname);
        button_establecerNick =V.findViewById(R.id.button_ponerNick);
        button_quitarNick=V.findViewById(R.id.button_quitarNick);

        current_u.setText(FirebaseActivity.usuario_en_activo_de_firebase.getEmail());

        button_establecerNick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowsChat.Nick=nickname_edit.getText().toString();
                Toast.makeText(getContext(),"Ahora eres: "+WindowsChat.Nick,Toast.LENGTH_SHORT).show();
            }
        });

        button_quitarNick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowsChat.Nick=FirebaseActivity.usuario_en_activo_de_firebase.getEmail();
                Toast.makeText(getContext(),"Ahora eres: "+WindowsChat.Nick,Toast.LENGTH_SHORT).show();
            }
        });

        return V;
    }

}