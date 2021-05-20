package com.example.firebase_chat.fichero_chat;

import java.util.ArrayList;

public class Chat {

    public Chat(String nombre_reu, String contrasena_reu) {
        this.nombre_reu = nombre_reu;
        this.contrasena_reu=contrasena_reu;
    }

    public Chat(){
        //Constructor por defecto
    }

    public String nombre_reu;
    public String contrasena_reu;
    //Coge todos los mensajes de esta conversacion
    public ArrayList<String> mensajes_de_esta_conversacion=new ArrayList<>();

    public String getContrasena_reu() {
        return contrasena_reu;
    }
    public void setContrasena_reu(String contrasena_reu) {
        this.contrasena_reu = contrasena_reu;
    }
    public String getNombre_reu() {
        return nombre_reu;
    }
    public void setNombre_reu(String nombre_reu) {
        this.nombre_reu = nombre_reu;
    }
    public ArrayList<String> getMensajes_de_esta_conversacion() { return mensajes_de_esta_conversacion; }
    public void setMensajes_de_esta_conversacion(ArrayList<String> mensajes_de_esta_conversacion) {
        this.mensajes_de_esta_conversacion = mensajes_de_esta_conversacion;
    }





}
