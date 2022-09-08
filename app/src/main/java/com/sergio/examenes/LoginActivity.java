package com.sergio.examenes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    CheckBox checkRecordUser;
    Button ntnCrearUser;
    Button btnInicarSesion;
    Toolbar toolbar;
    EditText etNameUser, etPassword;
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ntnCrearUser = findViewById(R.id.crearUser);
        btnInicarSesion = findViewById(R.id.iniciaSesion);
        checkRecordUser = findViewById(R.id.checkBoxRecordarUser);
        toolbar = findViewById(R.id.toolbal);
        etNameUser = findViewById(R.id.txtNameUser);
        etPassword = findViewById(R.id.txtPassword);
        pref = this.getPreferences(MODE_PRIVATE);
        editor= pref.edit();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mis Examenes");

        if (this.pref.getBoolean(Constants.STR_CHECKRECORDUSER, false)) {//Si había elgido recordar usuario
            redirigirAlMainActivityYEnviarNombre(this.pref.getString(Constants.STR_USERNAME, Constants.STR_VACIO));
        }

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
        if (etNameUser.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()) {//Si hay un campo vacio
            Toast.makeText(LoginActivity.this, "Complete todos los datos.", Toast.LENGTH_SHORT).show();
        } else {
            if (checkRecordUser.isChecked()) {
                actualizarDatosAlmacenados(etNameUser.getText().toString(), etPassword.getText().toString(), true);
            }
            redirigirAlMainActivityYEnviarNombre(etNameUser.getText().toString());
        }
    }

    public void redirigirAlMainActivityYEnviarNombre(String username){
        Intent intentMA = new Intent(this, MainActivity.class);
        intentMA.putExtra("data", username);//Agrego el nombre como parámetro, en la clave "data"
        startActivity(intentMA);//Cambio de activity (enviando el parámetro)
    }
    public void actualizarDatosAlmacenados(String inputUsername, String inputPassword, boolean estado){
            editor.putString(Constants.STR_USERNAME, inputUsername);
            editor.putString(Constants.STR_PASSWORD, inputPassword);
            editor.putBoolean(Constants.STR_CHECKRECORDUSER, estado);
            editor.apply();
    }

}