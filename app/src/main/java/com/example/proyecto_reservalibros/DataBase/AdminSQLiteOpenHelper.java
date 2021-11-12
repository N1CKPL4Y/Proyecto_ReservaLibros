package com.example.proyecto_reservalibros.DataBase;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
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
        db.execSQL("");


    }
    //donde actualizo mi BD
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
