package com.example.proyecto_reservalibros.DataBase;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "biblioapp";

    public AdminSQLiteOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }



    //donde creo mis tablas
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //tabla tipo_usuario
        db.execSQL("CREATE TABLE Tipo_usuario(id integer primary key," +
                "nombre_t varchar(50));");
        //insert tipo de usuarios
        db.execSQL("INSERT INTO Tipo_usuario VALUES(1, 'Administrador')");
        db.execSQL("INSERT INTO Tipo_usuario VALUES(2, 'Cliente')");
        //tabla usuario
        db.execSQL("CREATE TABLE Usuario(id integer primary key autoincrement," +
                "nombre varchar(50), apellido varchar(50), passwd varchar(50)," +
                "foreign key(tipo_usuario_fk) references Tipo_usuario(id));");
        //insert usuarios
        db.execSQL("INSERT INTO Usuario VALUES(null, 'admin', 'admin', 'admin123', 1)");
        db.execSQL("INSERT INTO Usuario VALUES(null, 'Nicolas', 'Perez', 'nico123', 2);");
        db.execSQL("INSERT INTO Usuario VALUES(null, 'Jose', 'Pino', 'jose123', 2);");
        //tabla categoria_libro
        db.execSQL("CREATE TABLE categoria_libro(id integer primary key autoincrement," +
                "nombre_c varchar(50));");
        //insert categorias
        db.execSQL("INSERT INTO Categoria_libro VALUES(null, 'suspenso')");
        db.execSQL("INSERT INTO Categoria_libro VALUES(null, 'accion')");
        db.execSQL("INSERT INTO Categoria_libro VALUES(null, 'romance')");
        //tabla libro
        db.execSQL("CREATE TABLE Libro(id integer primary key autoincrement, nombre varchar(50)," +
                "cantidad_paginas integer, foreign key(categoria_id_fk) references Categoria(id));");
        //insert libro
        db.execSQL("INSERT INTO Libro VALUES(null, 'IT(eso)', 400, 1)");
        db.execSQL("INSERT INTO Libro VALUES(null, 'El prisionero de zenda', 300, 2)");
        db.execSQL("INSERT INTO Libro VALUES(null, 'Francisca yo te amo', 200, 3)");
        //tabla historial de reservas
        db.execSQL("CREATE TABLE Registro_Reserva(id integer primary key autoincrement," +
                "fecha_hora TEXT," +
                "foreign key(usuario_id_fk) REFERENCES Usuario(id)," +
                "foreign key(libro_id_fk) REFERENCES Libro(id)," +
                "foreign key(categoria_id_fk) REFERENCES Categoria(id));");

    }
    //donde actualizo mi BD
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
