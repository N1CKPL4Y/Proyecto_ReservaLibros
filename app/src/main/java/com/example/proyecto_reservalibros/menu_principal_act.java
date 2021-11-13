package com.example.proyecto_reservalibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class menu_principal_act extends AppCompatActivity {
    private TextView txtclientelog;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        txtclientelog = (TextView) findViewById(R.id.txtclientelog);
        video = (VideoView) findViewById(R.id.video);
        String path = "android.resource://"+getResources()+"/"+R.raw.video;
        video.setVideoURI(Uri.parse(path));
        video.start();
        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        int id = getIntent().getIntExtra("tipo",1);
        txtclientelog.setText(nombre);
    }

    public void logout(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}