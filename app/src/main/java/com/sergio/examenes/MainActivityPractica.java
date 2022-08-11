package com.sergio.examenes;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPractica extends AppCompatActivity {

    public void buttonCalculatePress(View v){
        Toast.makeText(this, "Se presionó el botón", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica);
    }
}