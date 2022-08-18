package com.sergio.examenes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPractica extends AppCompatActivity {

    private Button btnCalcularPromedio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica);

        btnCalcularPromedio = findViewById(R.id.btnPromedio);

        btnCalcularPromedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNote = (EditText) findViewById(R.id.editNota1);
                EditText secondNote = (EditText) findViewById(R.id.editNota2);

                int average = (Integer.parseInt(firstNote.getText().toString()) + Integer.parseInt(secondNote.getText().toString())) / 2;

                Toast.makeText(MainActivityPractica.this, "El promedio es: " + String.valueOf(average), Toast.LENGTH_SHORT).show();
            }
        });

    }
    
}