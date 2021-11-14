package com.example.proyecto_reservalibros;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyecto_reservalibros.Clases.Categoria;
import com.example.proyecto_reservalibros.DataBase.AdminSQLiteOpenHelper;

import java.util.ArrayList;

public class ingresarLibros_act extends AppCompatActivity {

    //jose

    private EditText text_nombreLibro;
    private EditText text_cantPaginas;
    private Spinner  spn_catg;
    private Button btn_agregar;
    private AdminSQLiteOpenHelper d;
    ArrayList<String> listaCategoria;
    ArrayList<Categoria> categorialist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_libros);

        text_nombreLibro = (EditText) findViewById(R.id.text_nombreLibro);
        text_cantPaginas = (EditText) findViewById(R.id.text_cantPaginas);
        spn_catg = (Spinner) findViewById(R.id.spn_catg);
        btn_agregar = (Button) findViewById(R.id.btn_agregar);

        d = new AdminSQLiteOpenHelper(getApplicationContext());
        consultarlistaCategoria();
        obtenerLista();
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item,listaCategoria);
        spn_catg.setAdapter(adaptador);

        init();

    }

    public void init(){
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre;
                int c_paginas, categoria;
                nombre = text_nombreLibro.getText().toString();
                c_paginas = Integer.parseInt(text_cantPaginas.getText().toString());
                categoria = spn_catg.getSelectedItemPosition();

            }
        });
    }

    private void consultarlistaCategoria() {
        Categoria cat = null;
        SQLiteDatabase db = d.getReadableDatabase();
        categorialist= new ArrayList<Categoria>();
        Cursor cur = db.rawQuery("SELECT * FROM Categoria_libro", null);

        while(cur.moveToNext()){
            cat = new Categoria();
            cat.setID(cur.getInt(0));
            cat.setNombre_c(cur.getString(1));

            categorialist.add(cat);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaCategoria = new ArrayList<String>();
        listaCategoria.add("Seleccione");

        for (int i =0; i<categorialist.size(); i++){
            listaCategoria.add(categorialist.get(i).getNombre_c());
        }
    }


}