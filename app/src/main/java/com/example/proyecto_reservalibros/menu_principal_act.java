package com.example.proyecto_reservalibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.proyecto_reservalibros.Clases.Usuario;

public class menu_principal_act extends AppCompatActivity {
    private TextView txtclientelog;
    private VideoView video;
    private Bundle b;
    private Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        txtclientelog = (TextView) findViewById(R.id.txtclientelog);
        video = (VideoView) findViewById(R.id.video);

        video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video));
        video.start();
        b = getIntent().getExtras();
        usuario = (Usuario) b.getSerializable("usuario");
        txtclientelog.setText(usuario.getNombre());
    }

    public void logout(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void buscar(View view){
        Intent i = new Intent(this, buscar_libro_act.class);
        startActivity(i);
    }

    public void realizar_reserva(View view){
        Intent i = new Intent(this, realizar_reserva_act.class);
        i.putExtra("usuario", usuario);
        startActivity(i);
    }

    public void ver_historial(View view){
        Intent i = new Intent(this, historial_reservas_act.class);
        startActivity(i);
    }
}