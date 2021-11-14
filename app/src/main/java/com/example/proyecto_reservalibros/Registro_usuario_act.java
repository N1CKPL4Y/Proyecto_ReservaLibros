package com.example.proyecto_reservalibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto_reservalibros.Clases.Usuario;
import com.example.proyecto_reservalibros.DataBase.AdminSQLiteOpenHelper;

public class Registro_usuario_act extends AppCompatActivity {
    private EditText txtUserR;
    private EditText txtApellido;
    private EditText txtPassR;
    private Button btnRegistrar;
    private AdminSQLiteOpenHelper d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        txtUserR = (EditText) findViewById(R.id.txtUserR);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        txtPassR = (EditText) findViewById(R.id.txtpassR);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        d = new AdminSQLiteOpenHelper(getApplicationContext());

        init();
    }

    private void init(){
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre_u, apellido_u, pass_u;
                nombre_u = txtUserR.getText().toString();
                apellido_u = txtApellido.getText().toString();
                pass_u = txtPassR.getText().toString();

                Usuario user = new Usuario(0, nombre_u,apellido_u,pass_u,2);
                d.insertUser(user);
                txtUserR.setText("");
                txtApellido.setText("");
                txtPassR.setText("");
                Intent ointent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ointent);
                finish();
            }
        });
    }



}
