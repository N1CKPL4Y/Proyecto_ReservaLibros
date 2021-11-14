package com.example.proyecto_reservalibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.proyecto_reservalibros.Clases.Usuario;

public class menu_admi_act extends AppCompatActivity {
    private TextView txtuserlog;
    private String nombre_usuario;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admi);
        txtuserlog = (TextView) findViewById(R.id.txtuserlog);
        b = getIntent().getExtras();
        Usuario usuario = (Usuario) b.getSerializable("usuario");
        txtuserlog.setText("Bienvenido: "+usuario.getNombre());

    }

    //inicio de intent botones

    public void insertar(View view){

        Intent insertar = new Intent(this, ingresarLibros_act.class);
        startActivity(insertar);


    }

    public void modificar (View view){

        Intent modificar = new Intent(this, modificar_libro_act.class);
        startActivity(modificar);
    }

    public void categoria (View view){

        Intent categoria = new Intent(this, ingresarCategoria_act.class);
        startActivity(categoria);
    }

    public void verRegistro (View view){

        Intent verRegistro = new Intent(this, ver_registro_reservasAdmi_act.class);
        startActivity(verRegistro);
    }

    public void cerrarSesion (View view){

        Intent cerrarSesion = new Intent(this, MainActivity.class);
        startActivity(cerrarSesion);
    }



}