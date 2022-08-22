package com.sergio.examenes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcularPromedio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Muestro lo que llaga por parámetro desde el LoginActivity
        String strNombre = getIntent().getStringExtra("data");//Obtengo el dato
        Toast.makeText(MainActivity.this, "Te damos la bienvenida " + strNombre + "!!!", Toast.LENGTH_SHORT).show();

        btnCalcularPromedio = findViewById(R.id.btnPromedio);

        btnCalcularPromedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNote = (EditText) findViewById(R.id.editNota1);
                EditText secondNote = (EditText) findViewById(R.id.editNota2);

                int average = (Integer.parseInt(firstNote.getText().toString()) + Integer.parseInt(secondNote.getText().toString())) / 2;

                Toast.makeText(MainActivity.this, "El promedio es: " + String.valueOf(average), Toast.LENGTH_SHORT).show();
            }
        });

    }

}