package com.sergio.examenes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarExamenActivity extends AppCompatActivity {
    Button btnGuardar;
    Toolbar toolbar;
    EditText etMateria, etFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_examen);

        btnGuardar = findViewById(R.id.btnGuardar);
        toolbar = findViewById(R.id.toolbal_new);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Constants.STR_NEW_EXAMEN);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarYGuardarMateria();
            }
        });
    }

    public void validarYGuardarMateria(){
        etMateria = findViewById(R.id.etMateria);
        etFecha = findViewById(R.id.etFecha);
        String strMateria = etMateria.getText().toString();
        String strFecha = etFecha.getText().toString();
        if(strMateria.isEmpty() || strFecha.isEmpty()){
            Toast.makeText(this, Constants.STR_MSJ_COMPLETAR_CAMPOS, Toast.LENGTH_SHORT).show();
        }else{
            guardarMateria(strMateria, strFecha);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//Para crear el menú se deberá inflar el xml.
        getMenuInflater().inflate(R.menu.menu_new_examen_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//Para obtener los clicks sobre el ítem del menú se comparará el id del item que viene por parámetro con el del menú
        if (item.getItemId() == R.id.item_back){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void guardarMateria(String strMateria, String strFecha){
        Toast.makeText(this, "El examen se guardaría", Toast.LENGTH_SHORT).show();
        limpiarCampos();
    }

    public void limpiarCampos(){
        etMateria.setText(Constants.STR_VACIO);
        etFecha.setText(Constants.STR_VACIO);
    }

}