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

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
                finish();
            }
        }, 6000);


    }
}