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
            actualizarYMostrarValoresEnView(true); //Con esto llena los campos
        }

        //Con esto se limpia (si se destilda el check se vacía los campos, en vista y lo guardado)
        checkRecordUser.setOnClickListener(new View.OnClickListener() {//Ante un clic en el check
            @Override
            public void onClick(View view) {
                if (!checkRecordUser.isChecked() && pref.getBoolean(Constants.STR_CHECKRECORDUSER, false)) { //Si se eligió no recordar y tenía guarda que si recuerde (Si primer parámrtro es false y el segundo true)
                    limpiar();
                }
            }
        });

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


    private void limpiar() {
        actualizarDatosAlmacenados(Constants.STR_VACIO, Constants.STR_VACIO, false);
        actualizarYMostrarValoresEnView(false);
    }

    private void actualizarYMostrarValoresEnView(boolean estado) {
        checkRecordUser.setChecked(estado);
        etNameUser.setText(this.pref.getString(Constants.STR_USERNAME, Constants.STR_VACIO));
        etPassword.setText(this.pref.getString(Constants.STR_PASSWORD, Constants.STR_VACIO));
    }

}