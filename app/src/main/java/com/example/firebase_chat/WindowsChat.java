package com.example.firebase_chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.firebase_chat.Adaptador.MyAdapterMensajesDeLosChats;
import com.example.firebase_chat.fichero_chat.Chat;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WindowsChat extends AppCompatActivity {
    //este arraylist será el que nos mostrara todos nuestros mensajes
    ArrayList<Chat> mensajes_del_chat=new ArrayList<>();
    String receptor;
    //este edittect contiene las letras que componen mi mensaje
    EditText cuerpomensaje;
    DatabaseReference myRef;
    MyAdapterMensajesDeLosChats adapter;
    RecyclerView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windows_chat);
        cuerpomensaje=findViewById(R.id.cuerpoMensaje);
        DescargaMensajesDelChats();
    }



    public void DescargaMensajesDelChats(){
        //PARA DESCARGAR LOS CHATS Y RELLENAR LA LISTA

        receptor=getIntent().getStringExtra("DeQueConversacionSeTrata");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("conversaciones").child(receptor).child("Mensajes");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    mensajes_del_chat.clear();
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        Chat dato=snapshot.getValue(Chat.class);
                        mensajes_del_chat.add(dato);
                    }
                    r=findViewById(R.id.recycler_vista_mensajes);
                    adapter=new MyAdapterMensajesDeLosChats(WindowsChat.this,mensajes_del_chat);
                    r.setAdapter(adapter);
                    r.setLayoutManager(new LinearLayoutManager(WindowsChat.this));
                    //linea de codigo que hace que baje al ultimo mensaje insertado
                    r.scrollToPosition(mensajes_del_chat.size()-1);

                }
                Log.i("T", "Cantidad de mensajes de este chat son : "+ mensajes_del_chat.size());
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("TAG_2", "Failed to read value.", error.toException());
            }
        });
    }

    public void EnviarMensaje(View V){
        String mensaje=cuerpomensaje.getText().toString();
        myRef.child(myRef.push().getKey()).setValue(new Chat("Mensaje enviado por: "+FirebaseActivity.usuario_en_activo_de_firebase.getEmail(),"Calderon",mensaje));
        cuerpomensaje.setText("");
        DescargaMensajesDelChats();
    }

}