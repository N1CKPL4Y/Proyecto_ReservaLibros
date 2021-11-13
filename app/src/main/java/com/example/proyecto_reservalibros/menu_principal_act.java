package com.example.proyecto_reservalibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class menu_principal_act extends AppCompatActivity {
    private TextView txtclientelog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        txtclientelog = (TextView) findViewById(R.id.txtclientelog);
        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        int id = getIntent().getIntExtra("tipo",1);
        txtclientelog.setText(nombre);
    }
}