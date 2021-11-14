package com.example.proyecto_reservalibros.Clases;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int ID;
    private String Nombre;
    private String Apellido;
    private String passwd;
    private int tipo_user;

    public Usuario() {
    }

    public Usuario(int ID, String nombre, String apellido, String passwd, int tipo_user) {
        this.ID = ID;
        Nombre = nombre;
        Apellido = apellido;
        this.passwd = passwd;
        this.tipo_user = tipo_user;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(int tipo_user) {
        this.tipo_user = tipo_user;
    }
}


