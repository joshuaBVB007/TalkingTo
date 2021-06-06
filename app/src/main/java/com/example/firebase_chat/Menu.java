package com.example.firebase_chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.firebase_chat.DB.BBDD_ChatsDesbloqueados;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Menu extends AppCompatActivity {
    static int Buscador_position=0;
    public static BBDD_ChatsDesbloqueados dbhelper;
    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Esta clase solo se encarga de mostrar los fragments activados por el usuario:MimuroFragment,chatFragment,etc
        dbhelper=new BBDD_ChatsDesbloqueados(Menu.this);
        db=dbhelper.getWritableDatabase();

        BottomNavigationView navView = findViewById(R.id.btn);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.muroFragment, R.id.chatFragment, R.id.otroFragment,R.id.perfilFragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mi_buscador,menu);
        MenuItem searchitem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView)searchitem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if(Menu.Buscador_position==0){
                    MiMuroFragment.adapter.getFilter().filter(newText);
                }
                return false;
            }
        });
        return true;
    }


}