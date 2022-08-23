package com.sergio.examenes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private CheckBox checkRecordUser;
    private Button ntnCrearUser;
    private Button btnInicarSesion;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ntnCrearUser = findViewById(R.id.crearUser);
        btnInicarSesion = findViewById(R.id.iniciaSesion);
        checkRecordUser = (CheckBox) findViewById(R.id.checkBoxRecordarUser);
        toolbar = findViewById(R.id.toolbal);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mis Examenes");

        ntnCrearUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accionarPorBtnCrearUsuario(view);
            }
        });

        btnInicarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accionarPorBtnInicarSesion(view);
            }
        });

    }

    public void accionarPorBtnCrearUsuario(View view){
        Intent intentMA = new Intent(this, TermsAndConditionsActivity.class);
        startActivity(intentMA);
    }

    public void accionarPorBtnInicarSesion(View view) {
        EditText etNameUser = (EditText) findViewById(R.id.txtNameUser);
        EditText etPassword = (EditText) findViewById(R.id.txtPassword);
        if (etNameUser.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()) {//Si hay un campo vacio
            Toast.makeText(LoginActivity.this, "Complete todos los datos.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intentMA = new Intent(this, MainActivity.class);
            intentMA.putExtra("data", etNameUser.getText().toString());//Agrego el nombre como parámetro, en la clave "data"
            startActivity(intentMA);//Cambio de activity (enviando el parámetro)
        }
    }

}