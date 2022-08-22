package com.sergio.examenes;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ntnCrearUser = findViewById(R.id.crearUser);
        btnInicarSesion = findViewById(R.id.iniciaSesion);
        checkRecordUser = (CheckBox) findViewById(R.id.checkBoxRecordarUser);

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
        //TODO
        Toast.makeText(LoginActivity.this, "Se redirige para crear usuario", Toast.LENGTH_SHORT).show();
    }

    public void accionarPorBtnInicarSesion(View view){
        EditText etNameUser = (EditText) findViewById(R.id.txtNameUser);
        EditText etPassword = (EditText) findViewById(R.id.txtPassword);
        String mensaje = "";
        if(checkRecordUser.isChecked()){
            mensaje += "recordando el usuario "+ etNameUser.getText() + " y contraseña "+ etPassword.getText(); //TODO
        }else{
            mensaje += "sin recordar el usuario"; //TODO
        }
        Toast.makeText(LoginActivity.this, "Se inicia sesión " + mensaje, Toast.LENGTH_SHORT).show(); //TODO
    }

}