package com.sergio.examenes;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPractica extends AppCompatActivity {

    public void buttonCalculatePress(View v){
        EditText et1, et2;
        Integer num1, num2, prom;
        et1 = (EditText) findViewById(R.id.editNota1);
        et2 = (EditText) findViewById(R.id.editNota2);
        num1 = Integer.parseInt(et1.getText().toString());
        num2 = Integer.parseInt(et2.getText().toString());
        prom = (num1 + num2) / 2;

        Toast.makeText(this, "El promedio es: "+prom, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica);
    }
}