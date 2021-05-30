package com.example.firebase_chat.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.firebase_chat.fichero_chat.Chat;

import java.util.ArrayList;

public class ChatFavoritos extends SQLiteOpenHelper {
    private static final String query = "CREATE TABLE " + "Chats" +
            "(" + "ID" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NombreChat"+" TEXT,"+
            "Clave"+" TEXT)";
    public ChatFavoritos(@Nullable Context context) {
        super(context, "MisChats", null, 1);
        Log.i("SQL", "Tabla creada con exito: ");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    public static ArrayList<Chat> getAllIncidencies(SQLiteDatabase db){
        ArrayList<Chat> listIncidencies = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from "+"Chats",null);
        if( cursor.getCount()>0){
            //ID,TITULO.PRIORIDAD,FECHA,DESCRIPCION,ESTADO
            while (cursor.moveToNext()) {
                Chat incidencia = new Chat(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2));
                listIncidencies.add(incidencia);
            }
        }
        cursor.close();
        return listIncidencies;
    }

    public void insertIncidencia(SQLiteDatabase db, Chat michat){
        if(db.isOpen()){
            ContentValues contenido=new ContentValues();
            contenido.put("NombreChat",michat.nombre_reu);
            contenido.put("Clave",michat.getContrasena_reu());
            try {
                db.insert("Chats",null,contenido);
            }catch (SQLException e){
                Log.i("prova","insert not happened");
            }
        }else{
            Log.i("prova","database is closed");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

}
