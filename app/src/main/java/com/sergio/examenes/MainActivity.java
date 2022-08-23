package com.sergio.examenes;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcularPromedio;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Muestro lo que llaga por parámetro desde el LoginActivity
        String strNombre = getIntent().getStringExtra("data");//Obtengo el dato
        Toast.makeText(MainActivity.this, "Te damos la bienvenida " + strNombre + "!!!", Toast.LENGTH_SHORT).show();

        btnCalcularPromedio = findViewById(R.id.btnPromedio);

        toolbar = findViewById(R.id.toolbal);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mis Examenes");

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_primary_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_agregar){
            Intent intent = new Intent(MainActivity.this, AgregarExamenActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}