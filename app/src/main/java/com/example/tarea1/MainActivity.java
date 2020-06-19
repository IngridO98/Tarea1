package com.example.tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener fechadialogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fechadialogo = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker FechaSel, int anio, int mes, int dia) {
                mes = mes + 1;
                EditText Fecha = (EditText) findViewById(R.id.txtFechamain1);
                //String fech=dia+"/"+mes+"/"+anio;
                Fecha.setText(dia + "/" + mes + "/" + anio);
            }
        };
    }

    public void btnFecha(View view){
        Calendar cale = Calendar.getInstance();
        int anio=cale.get(Calendar.YEAR);
        int mes=cale.get(Calendar.MONTH);
        int dia=cale.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialogo = new DatePickerDialog(
                MainActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                fechadialogo,anio,mes,dia);
        dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogo.show();
    }

    public void EnviarDatos(View view){

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        Bundle b = new Bundle();

        String Generosel=" ";
        RadioButton rdf=(RadioButton) findViewById(R.id.rdFem);
        RadioButton rdm=(RadioButton) findViewById(R.id.rdMas);
        EditText Fecha = (EditText) findViewById(R.id.txtFechamain1);
        EditText Nombre = (EditText) findViewById(R.id.txtNombremain1);
        EditText Telefono = (EditText) findViewById(R.id.txtTelefonomain1);


            if(rdf.isChecked()==true)
                Generosel="Femenino";
            else if(rdm.isChecked()==true)
                Generosel="Masculino";
            else
                Generosel="Nada";

        if(Generosel.toString()!="Nada" &&
                Nombre.getText().toString()!=null && !Nombre.getText().toString().trim().equals("") &&
                Fecha.getText().toString()!=null && !Fecha.getText().toString().trim().equals("") &&
                Telefono.getText().toString()!=null && !Telefono.getText().toString().trim().equals(""))
        {
            b.putString("NOMBRE", Nombre.getText().toString());
            b.putString("GENERO", Generosel.toString());
            b.putString("FECHA", Fecha.getText().toString());
            b.putString("TELEFONO", Telefono.getText().toString());
            intent.putExtras(b);

            // Iniciamos la nueva actividad
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"Verifique los datos por favor",Toast.LENGTH_LONG).show();
         }
    }
}