package com.example.proyecto_reservalibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    // lo agregue solo para probar si funcionaban los intent de admi uwu
    public void ingresar(View view){

        Intent ingresar = new Intent(this, menu_admi_act.class);
        startActivity(ingresar);


    }

    public void registrar(View view){

        Intent registrar = new Intent(this, Registro_usuario_act.class);
        startActivity(registrar);


    }




}