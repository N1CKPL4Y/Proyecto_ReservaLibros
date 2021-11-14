package com.example.proyecto_reservalibros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.proyecto_reservalibros.Clases.Libro;
import com.example.proyecto_reservalibros.Clases.Usuario;
import com.example.proyecto_reservalibros.DataBase.AdminSQLiteOpenHelper;

public class realizar_reserva_act extends AppCompatActivity {
    private EditText txtB;
    private EditText txtN;
    private EditText txtC_P;
    private EditText txtCat;
    private Button btnRegistrarR;
    private Button btnBuscarL;
    private Bundle b;
    private AdminSQLiteOpenHelper d;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_reserva);
        txtB = (EditText) findViewById(R.id.txtB);
        txtN = (EditText) findViewById(R.id.txtN);
        txtC_P = (EditText) findViewById(R.id.txtC_P);
        txtCat = (EditText) findViewById(R.id.txtCat);
        btnRegistrarR = (Button) findViewById(R.id.btnRegistrarR);
        btnBuscarL = (Button) findViewById(R.id.btnBuscarL);
        b = getIntent().getExtras();
        usuario = (Usuario) b.getSerializable("usuario");
        d = new AdminSQLiteOpenHelper(getApplicationContext());

        buscar();
    }

    private void buscar() {
        btnBuscarL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtB.getText().toString();
                //Libro oLibro = d.getLibro(nombre);
                System.out.println(usuario.getNombre());
            }
        });
    }

}