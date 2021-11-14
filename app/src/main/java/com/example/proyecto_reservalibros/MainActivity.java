package com.example.proyecto_reservalibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_reservalibros.Clases.Usuario;
import com.example.proyecto_reservalibros.DataBase.AdminSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    private EditText txtuser;
    private EditText txtpass;
    private TextView txterror;
    private AdminSQLiteOpenHelper d;
    private Button btnIniciar;
    private int id_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtuser = (EditText) findViewById(R.id.txtuser);
        txtpass = (EditText) findViewById(R.id.txtpass);
        txterror = (TextView) findViewById(R.id.txterror);
        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        id_user = 0;
        d = new AdminSQLiteOpenHelper(getApplicationContext());

        init();
    }

    private void init(){
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre, pass;

                nombre = txtuser.getText().toString();
                pass = txtpass.getText().toString();

                Usuario user = d.getUser(nombre, pass);
                if (user != null) {
                    if (user.getTipo_user()==1){
                        System.out.println(""+user.getTipo_user());
                        id_user = user.getTipo_user();
                        Intent i = new Intent(getApplicationContext(), menu_admi_act.class);
                        i.putExtra("usuario", user);
                        startActivity(i);
                    }else if(user.getTipo_user()==2){
                        System.out.println(""+user.getTipo_user());
                        id_user = user.getTipo_user();
                        Intent i = new Intent(getApplicationContext(), menu_principal_act.class);
                        i.putExtra("usuario", user);
                        startActivity(i);
                        System.out.println(id_user);
                    }
                }else{
                    txterror.setText("Usuario y/o contraseña incorrectos, reintente");
                    txtuser.setText("");
                    txtpass.setText("");
                }
            }
        });
    }

    public void registrar(View view){

        Intent registrar = new Intent(this, Registro_usuario_act.class);
        startActivity(registrar);


    }

    public void facebook(View view){
        Uri webpage = Uri.parse("https://www.facebook.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }

    public void twitter(View view){
        Uri webpage = Uri.parse("https://www.twitter.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);

    }

    public void instagram(View view){
        Uri webpage = Uri.parse("https://www.instagram.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);

    }




}