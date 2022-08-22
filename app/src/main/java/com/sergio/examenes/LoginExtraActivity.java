package com.sergio.examenes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginExtraActivity extends AppCompatActivity implements View.OnClickListener{ //implemento el interfaz View.OnClickListener

    private CheckBox checkRecordUser;
    private Button ntnCrearUser;
    private Button btnInicarSesion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ntnCrearUser = findViewById(R.id.crearUser);
        btnInicarSesion = findViewById(R.id.iniciaSesion);
        checkRecordUser =(CheckBox) findViewById(R.id.checkBoxRecordarUser);
        /*
          Capturo el objeto button de cada botón y ejecuto su método setOnClickListener
          pasando el propio objeto como parámetro, es decir, el método onClick()
          que llamamos será instanciado en la misma clase.
        * */
        ntnCrearUser.setOnClickListener(this);
        btnInicarSesion.setOnClickListener(this);

    }

    /*
    * Sobrecargo el méoto onClick de la interfaz. Este es el que se
    * llama porque pasamos (this) como parámetro al llamar al
    * setOnClickListener para cada botón
    * */
    @Override
    public void onClick(View view) {
        EditText etNameUser = (EditText) findViewById(R.id.txtNameUser);
        EditText etPassword = (EditText) findViewById(R.id.txtPassword);
        String mensaje = "";

        //Determino que hacer al pulsar cada botón
        if(view.getId() == R.id.iniciaSesion){
            mensaje += "Se inicia sesión "; //TODO
            if(checkRecordUser.isChecked()){
                mensaje += "recordando el usuario "+ etNameUser.getText() + " y contraseña "+ etPassword.getText(); //TODO
            }else{
                mensaje += "sin recordar el usuario"; //TODO
            }
        } else if(view.getId() == R.id.crearUser){
            mensaje += "Se redirige a crear usuario";
        }

        Toast.makeText(LoginExtraActivity.this, mensaje, Toast.LENGTH_SHORT).show();
    }

}