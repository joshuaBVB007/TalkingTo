package com.example.firebase_chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.example.firebase_chat.DB.ChatFavoritos;
import com.example.firebase_chat.fichero_chat.Chat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    public static ChatFavoritos dbhelper;
    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Esta clase solo se encarga de mostrar los fragments activados por el usuario:MimuroFragment,chatFragment,etc
        dbhelper=new ChatFavoritos(Menu.this);
        db=dbhelper.getWritableDatabase();

        BottomNavigationView navView = findViewById(R.id.btn);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.muroFragment, R.id.chatFragment, R.id.otroFragment,R.id.perfilFragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }
}