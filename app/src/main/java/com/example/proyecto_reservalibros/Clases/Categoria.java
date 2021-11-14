package com.example.proyecto_reservalibros.Clases;

public class Categoria {
    private int ID;
    private String Nombre_c;

    public Categoria() {
    }

    public Categoria(int ID, String nombre_c) {
        this.ID = ID;
        Nombre_c = nombre_c;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre_c() {
        return Nombre_c;
    }

    public void setNombre_c(String nombre_c) {
        Nombre_c = nombre_c;
    }

    public String toString(){
        return Nombre_c;
    }
}
