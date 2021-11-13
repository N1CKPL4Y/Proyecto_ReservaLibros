package com.example.proyecto_reservalibros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.AndroidException;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.proyecto_reservalibros.Clases.Categoria;

public class ingresarLibros_act extends AppCompatActivity {

    //jose

    private EditText text_nombreLibro;
    private EditText text_cantPaginas;
    private Spinner  spn_catg;
    private Button añadir_libro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_libros);


        spn_catg = (Spinner) findViewById(R.id.spn_catg);


        Categoria cat = new Categoria();


        //ArrayAdapter adapCategoria = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cat.getNombre_c());

    }










}