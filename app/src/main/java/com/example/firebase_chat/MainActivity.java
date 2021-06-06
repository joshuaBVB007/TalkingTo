package com.example.firebase_chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {


    /*
    #########################################################################
    ######## ESTE ACTIVITY MUESTRA LA PANTALLA DE CARGA DE MI APP ###########
    #########################################################################
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Este controlador se encarga de que dar un periodo de carga de 6 minutos antes de empezar la siguiente antivity
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, FirebaseActivity.class);
                startActivity(intent);
                finish();
            }
        }, 6000);
    }
}