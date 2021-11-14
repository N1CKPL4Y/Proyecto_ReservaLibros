package com.example.proyecto_reservalibros.Clases;

public class Libro {
    private int ID;
    private String Nombre_l;
    private int Cant_Paginas;
    private int categoria_l;

    public Libro() {
    }

    public Libro(int ID, String nombre_l, int cant_Paginas, int categoria_l) {
        this.ID = ID;
        Nombre_l = nombre_l;
        Cant_Paginas = cant_Paginas;
        this.categoria_l = categoria_l;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre_l() {
        return Nombre_l;
    }

    public void setNombre_l(String nombre_l) {
        Nombre_l = nombre_l;
    }

    public int getCant_Paginas() {
        return Cant_Paginas;
    }

    public void setCant_Paginas(int cant_Paginas) {
        Cant_Paginas = cant_Paginas;
    }

    public int getCategoria_l() {
        return categoria_l;
    }

    public void setCategoria_l(int categoria_l) {
        this.categoria_l = categoria_l;
    }

    @Override
    public String toString(){
        return Nombre_l+"   "+Cant_Paginas;
    }
}
