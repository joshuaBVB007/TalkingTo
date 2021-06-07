package com.example.firebase_chat.fichero_chat;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Chat {
    public String nombre_reu;
    public String contrasena_reu;
    public String contenido;
    public long fecha;


    //Utilizamos este contructor para crear reuniones con clave y nombre de reunion
    public Chat(String nombre_reu, String contrasena_reu) {
        this.nombre_reu = nombre_reu;
        this.contrasena_reu = contrasena_reu;
    }

    public Chat(String nombre_reu, String contrasena_reu,String contenido,long fecha) {
        this.nombre_reu = nombre_reu;
        this.contrasena_reu = contrasena_reu;
        this.contenido=contenido;
        this.fecha=fecha;
    }
    /*Utilizamos este constructor para bajar desde firebase los mensajes,
        ya que al bajarlo trae mas contenido que son los mensajes que han escritos los usuarios*/
    public Chat(String nombre_reu, String contrasena_reu,String contenido) {
        this.nombre_reu = nombre_reu;
        this.contrasena_reu = contrasena_reu;
        this.contenido=contenido;
    }

    /*Una peculiaridad de firebase es que nos obliga a crear un constructor por defcto para no darnos
    fallo al darle play a la app*/
    public Chat(){
        //Constructor por defecto
    }

    public String getContrasena_reu() { return contrasena_reu; }
    public void setContrasena_reu(String contrasena_reu) { this.contrasena_reu = contrasena_reu; }
    public String getNombre_reu() { return nombre_reu; }
    public void setNombre_reu(String nombre_reu) { this.nombre_reu = nombre_reu; }
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    public long getFecha() { return fecha; }
    public void setFecha(long fecha) { this.fecha = fecha; }
    public String dimeFecha(){//ESTE METODO LO USAMOS EN EL RECYCLER_ADAPTER
        Long fecha = this.getFecha()*1000;
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String hora_definitiva=format.format(fecha);
        String dateString = DateFormat.format("MM/dd/yyyy HH:mm:ss", new Date(fecha)).toString();
        return dateString;
    }
}
