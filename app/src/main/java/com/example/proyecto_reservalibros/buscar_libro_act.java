package com.example.proyecto_reservalibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyecto_reservalibros.Clases.Libro;
import com.example.proyecto_reservalibros.DataBase.AdminSQLiteOpenHelper;

import java.util.ArrayList;

public class buscar_libro_act<Scrollview> extends AppCompatActivity {
    private AdminSQLiteOpenHelper d;
    private ListView lista_libros;
    private Button btnBuscar;
    private EditText txtBuscarLibro;
    ArrayAdapter<String> adaptador;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_libro);
        d = new AdminSQLiteOpenHelper(getApplicationContext());
        lista_libros = (ListView) findViewById(R.id.lista_libros);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        txtBuscarLibro = (EditText) findViewById(R.id.txtBuscarLibro);
        listarDatos();

        buscar();
    }

    public void volver(View view){
        Intent i = new Intent(this, menu_principal_act.class);
        startActivity(i);
    }

    public void listarDatos(){
        ArrayList <Libro> lista = d.getLibros();
        if (!lista.isEmpty()){
            lista_libros.setVisibility(View.VISIBLE);
            ArrayAdapter <Libro> adaptador = new ArrayAdapter<Libro>(this, android.R.layout.simple_list_item_1, lista);
            lista_libros.setAdapter(adaptador);
        }else{

        }

    }

    private void buscar(){
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtBuscarLibro.getText().toString();
                System.out.println(nombre);
                if(nombre.isEmpty()){
                    listarDatos();
                }else if (!nombre.isEmpty()){
                    Libro oLibro = d.getLibro(nombre);
                    boolean exist = d.getlibro(nombre);
                    ArrayList <Libro> list = new ArrayList<>();
                    list.add(oLibro);
                    if (!list.isEmpty() && exist==true){
                        lista_libros.setVisibility(View.VISIBLE);
                        ArrayAdapter <Libro> adaptador = new ArrayAdapter<Libro>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
                        lista_libros.setAdapter(adaptador);
                    }else if (exist==false){
                        listarDatos();
                        Toast.makeText(getApplicationContext(), "Libro no encontrado uwu", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });
    }


}