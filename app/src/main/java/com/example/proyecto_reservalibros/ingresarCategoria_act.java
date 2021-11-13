package com.example.proyecto_reservalibros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto_reservalibros.Clases.Categoria;
import com.example.proyecto_reservalibros.DataBase.AdminSQLiteOpenHelper;


public class ingresarCategoria_act extends AppCompatActivity {

    //jose
    private EditText text_nombre;
    private Button btn_añadir;
    private AdminSQLiteOpenHelper d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_categoria);

        //jose

        text_nombre = (EditText) findViewById(R.id.text_nombre);
        btn_añadir = (Button) findViewById(R.id.btn_añadir);


        d = new AdminSQLiteOpenHelper(getApplicationContext());


    }
    //jose

            public void añadir(View view) {

                String nombre;

                nombre = text_nombre.getText().toString();

                Categoria cat = new Categoria(0,nombre);
                d.añadirCAt(cat);

                Toast.makeText(getApplicationContext(), "agregado", Toast.LENGTH_LONG).show();

            }






}
