package com.example.tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Localizar los controles
        TextView Nombreact2 = (TextView)findViewById(R.id.txtNombre2);
        TextView Generoact2 = (TextView)findViewById(R.id.txtGenero2);
        TextView Fechaact2 = (TextView)findViewById(R.id.txtfechamain2);
        TextView Telefonoact2 = (TextView)findViewById(R.id.txtTelefonomain2);
        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        Nombreact2.setText(bundle.getString("NOMBRE"));
        Generoact2.setText(bundle.getString("GENERO"));
        Fechaact2.setText(bundle.getString("FECHA"));
        Telefonoact2.setText(bundle.getString("TELEFONO"));
    }



}