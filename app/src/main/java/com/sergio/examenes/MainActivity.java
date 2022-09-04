package com.sergio.examenes;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvExamenes;
    ExamenAdapter examenAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbal);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mis Examenes");

        setupAdapter();

        /* RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvExamenes.setLayoutManager(layoutManager);*/
    }


    public List<Examen> getExamenes() {
        return new ArrayList<Examen>() {{
            add(new Examen(1, "Ingenieria de Software 1", "2022-04-05"));
            add(new Examen(2, "Algoritmos y Estructuras de Datos", "2022-04-07"));
            add(new Examen(3, "Prueba de Software", "2022-04-08"));
            add(new Examen(4, "Matematica", "2022-04-10"));
        }};
    }


    private void setupAdapter(){
        rvExamenes = findViewById(R.id.rvExamenes);
        examenAdapter = new ExamenAdapter(getExamenes(), new ExamenAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Examen examen) {
                Toast.makeText(MainActivity.this, examen.getMateria(), Toast.LENGTH_SHORT).show();
            }
        });
        rvExamenes.setAdapter(examenAdapter);// examenAdapter será el adaptador de rvExamenes

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_primary_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_agregar){
            Intent intent = new Intent(this, AgregarExamenActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}