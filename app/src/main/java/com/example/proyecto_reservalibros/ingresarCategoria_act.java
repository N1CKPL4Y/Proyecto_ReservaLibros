package com.example.proyecto_reservalibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto_reservalibros.Clases.Categoria;
import com.example.proyecto_reservalibros.DataBase.AdminSQLiteOpenHelper;


public class ingresarCategoria_act extends AppCompatActivity {

    //jose
    private EditText text_nombre_c;
    private Button btn_add;
    private AdminSQLiteOpenHelper d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_categoria);

        //jose

        text_nombre_c = (EditText) findViewById(R.id.text_nombre_c);
        btn_add = (Button) findViewById(R.id.btn_add);


        d = new AdminSQLiteOpenHelper(getApplicationContext());

        init();

    }
    //jose

            private void init(){
                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nombre;

                        nombre = text_nombre_c.getText().toString();

                        Categoria cat = new Categoria(0,nombre);
                        //System.out.println(cat.toString());
                        d.insertCategoria(cat);
                        System.out.println("categoria agregada: " +cat);
                        Intent ointent = new Intent(getApplicationContext(), menu_admi_act.class);
                        startActivity(ointent);
                        finish();

                    }
                });

            }
}
