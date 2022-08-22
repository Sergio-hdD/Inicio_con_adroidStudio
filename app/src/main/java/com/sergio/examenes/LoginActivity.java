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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void accionarPorBtnCrearUsuario(View view) {
        Toast.makeText(LoginActivity.this, "Se redirige para crear usuario", Toast.LENGTH_SHORT).show();
    }

    public void accionarPorBtnInicarSesion(View view){
        EditText etNameUser = (EditText) findViewById(R.id.txtNameUser);
        EditText etPassword = (EditText) findViewById(R.id.txtPassword);
        if (etNameUser.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()){//Si hay un campo vacio
            Toast.makeText(LoginActivity.this, "Complete todos los datos.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intentMA = new Intent(this, MainActivity.class);
            intentMA.putExtra("data", etNameUser.getText().toString());//Agrego el nombre como parámetro, en la clave "data"
            startActivity(intentMA);//Cambio de activity (enviando el parámetro)
        }
    }

}