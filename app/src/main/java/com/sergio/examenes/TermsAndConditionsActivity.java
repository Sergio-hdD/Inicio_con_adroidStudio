package com.sergio.examenes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TermsAndConditionsActivity extends AppCompatActivity {

    Button btnAcetar;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        btnAcetar = findViewById(R.id.bntAceptar);
        toolbar = findViewById(R.id.toolbal);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mis Examenes");

        btnAcetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TermsAndConditionsActivity.this, "Ha aceptado los terminos!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}