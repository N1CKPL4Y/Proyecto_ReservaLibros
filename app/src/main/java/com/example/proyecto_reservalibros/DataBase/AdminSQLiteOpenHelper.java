package com.example.proyecto_reservalibros.DataBase;
import android.content.Context;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyecto_reservalibros.Clases.Categoria;
import com.example.proyecto_reservalibros.Clases.Libro;
import com.example.proyecto_reservalibros.Clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "biblioapp";
    private static final String TABLA_TIPO_USUARIO = "CREATE TABLE Tipo_usuario(id INTEGER primary key, nombre_t TEXT );";
    private static final String INSERT_TIPO_USUARIO = "INSERT INTO Tipo_usuario VALUES(1, 'Administrador'),(2, 'Cliente');";
    private static final String TABLA_USUARIO = "CREATE TABLE Usuario(id INTEGER primary key autoincrement, nombre TEXT, apellido TEXT, passwd TEXT,tipo_usuario_fk INTEGER, foreign key(tipo_usuario_fk) references Tipo_usuario(id))";
    private static final String INSERT_USUARIO = "INSERT INTO Usuario VALUES(null, 'admin', 'admin', 'admin123', 1), (null, 'Nicolas', 'Perez', 'nico123', 2), (null, 'Jose', 'Pino', 'jose123', 2)";
    private static final String TABLA_CATEGORIA = "CREATE TABLE Categoria_libro(id INTEGER primary key autoincrement,nombre_c TEXT)";
    private static final String INSERT_CATEGORIA = "INSERT INTO Categoria_libro VALUES(null, 'suspenso'), (null, 'accion'), (null, 'romance')";
    private static final String TABLA_LIBRO = "CREATE TABLE Libro(id INTEGER primary key autoincrement, nombre TEXT,cantidad_paginas INTEGER, categoria_id_fk INTEGER, foreign key(categoria_id_fk) references Categoria(id))";
    private static final String INSERT_LIBRO = "INSERT INTO Libro VALUES(null, 'IT(eso)', 400, 1), (null, 'El prisionero de zenda', 300, 2), (null, 'Francisca yo te amo', 200, 3)";
    private static final String TABLA_REGISTRO_RESERVA = "CREATE TABLE Registro_Reserva(id INTEGER primary key autoincrement,fecha_hora TEXT ,usuario_id_fk INTEGER, libro_id_fk INTEGER, categoria_id_fk INTEGER, foreign key(usuario_id_fk) REFERENCES Usuario(id),foreign key(libro_id_fk) REFERENCES Libro(id),foreign key(categoria_id_fk) REFERENCES Categoria(id))";

    public AdminSQLiteOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    //donde creo mis tablas
    @Override
    public void onCreate(SQLiteDatabase db) {
        //tabla tipo_usuario
        db.execSQL(TABLA_TIPO_USUARIO);
        //insert tipo de usuarios
        db.execSQL(INSERT_TIPO_USUARIO);
        //tabla usuario
        db.execSQL(TABLA_USUARIO);
        //insert usuarios
        db.execSQL(INSERT_USUARIO);
        //tabla categoria_libro
        db.execSQL(TABLA_CATEGORIA);
        //insert categorias
        db.execSQL(INSERT_CATEGORIA);
        //tabla libro
        db.execSQL(TABLA_LIBRO);
        //insert libro
        db.execSQL(INSERT_LIBRO);
        //tabla historial de reservas
        db.execSQL(TABLA_REGISTRO_RESERVA);
        /*db.execSQL("create view view_libro as SELECT * from Libro\n" +
                "inner join Categoria\n" +
                "on Libro.categoria_id_fk=Categoria.id");*/

    }
    //donde actualizo mi BD
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //consulta para saber si el usuario existe dentro de la bd
    public Usuario getUser(String nombre_u, String pass_u){
        Usuario user = null;
       SQLiteDatabase bd = getReadableDatabase();
       Cursor cur = bd.rawQuery("SELECT * FROM Usuario WHERE nombre= '"+nombre_u+"'and passwd = '"+pass_u+"'",null);
       if (cur.moveToFirst()){
           user = new Usuario();
           user.setID(cur.getInt(0));
           user.setNombre(cur.getString(1));
           user.setApellido(cur.getString(2));
           user.setPasswd(cur.getString(3));
           user.setTipo_user(cur.getInt(4));
       }
       return user;
    }

    //insertamos un usuario nuevo
    public void insertUser(Usuario user){
        SQLiteDatabase bd = getReadableDatabase();
        if (bd != null){
            bd.execSQL("INSERT INTO Usuario VALUES(NULL, '"+user.getNombre()+"', '"+user.getApellido()+"', '"+user.getPasswd()+"',2);");
        }
        bd.close();
    }

    //insertamos una categoria nueva
    public void insertCategoria(Categoria cat){
        SQLiteDatabase bd = getReadableDatabase();
        if (bd !=null){
            bd.execSQL("INSERT INTO Categoria_libro VALUES(NULL, '"+cat.getNombre_c()+"');");
        }
        bd.close();
    }

    //obtenemos lista de los libros existentes
    public ArrayList<Libro> getLibros(){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cur = bd.rawQuery("SELECT * FROM Libro", null);
        ArrayList<Libro> listalib = new ArrayList<Libro>();

        while(cur.moveToNext()){
            Libro l = new Libro();
            l.setID(cur.getInt(0));
            l.setNombre_l(cur.getString(1));
            l.setCant_Paginas(cur.getInt(2));
            l.setCategoria_l(cur.getInt(3));
            listalib.add(l);
        }
        bd.close();
        return listalib;
    }

    //buscamos un libro en especifico
    public Libro getLibro(String nombre){
        Libro l = null;
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cur = bd.rawQuery("SELECT * FROM Libro WHERE nombre = '"+nombre+"'", null);
        if (cur.moveToFirst()){
            l = new Libro();
            l.setID(cur.getInt(0));
            l.setNombre_l(cur.getString(1));
            l.setCant_Paginas(cur.getInt(2));
            l.setCategoria_l(cur.getInt(3));
        }
        return l;
    }

    public boolean getlibro(String nombre){
        Libro l = null;
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cur = bd.rawQuery("SELECT * FROM Libro WHERE nombre = '"+nombre+"'", null);
        if (cur.moveToFirst()){
            l = new Libro();
            l.setID(cur.getInt(0));
            l.setNombre_l(cur.getString(1));
            l.setCant_Paginas(cur.getInt(2));
            l.setCategoria_l(cur.getInt(3));
            return true;
        }
        return false;
    }

    //agregar libro
    public void insertLibro(Libro l){
        SQLiteDatabase bd = getReadableDatabase();
        if (bd !=null){
            bd.execSQL("INSERT INTO Libro VALUES(NULL, '"+l.getNombre_l()+"', "+l.getCant_Paginas()+", "+l.getCategoria_l()+");");
        }
        bd.close();

    }




}
