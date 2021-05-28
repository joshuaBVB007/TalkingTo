package com.example.firebase_chat.fichero_chat;

import java.util.ArrayList;

public class Chat {
    public String nombre_reu;
    public String contrasena_reu;
    public String contenido;
    //Utilizamos este contructor para crear reuniones con clave y nombre de reunion
    public Chat(String nombre_reu, String contrasena_reu) {
        this.nombre_reu = nombre_reu;
        this.contrasena_reu = contrasena_reu;
    }
    /*Utilizamos este constructor para bajar desde firebase los mensajes,
        ya que al bajarlo trae mas contenido,aunque,solo bajamos la conversacion especifica que necesitamos*/
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
}
