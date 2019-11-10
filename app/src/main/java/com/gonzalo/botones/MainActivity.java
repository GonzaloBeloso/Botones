package com.gonzalo.botones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton aleatorio,b_trofeo,b_dado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }


    private void acciones(){
        aleatorio.setOnClickListener(this);
        b_trofeo.setOnClickListener(this);
        b_dado.setOnClickListener(this);
    }
    private void instancias(){
        aleatorio = findViewById(R.id.aleatorio);
        b_trofeo = findViewById(R.id.concurso);
        b_dado = findViewById(R.id.dados);
    }
    @Override
    public void onClick(View view) {
        Intent cambio;
        switch (view.getId()){
            case R.id.aleatorio:
                cambio= new Intent(getApplicationContext(),AleatorioActivity.class);
                startActivity(cambio);
                break;
            case R.id.concurso:
                cambio= new Intent(getApplicationContext(),ConcursoActivity.class);
                startActivity(cambio);
                break;
            case R.id.dados:
                cambio= new Intent(getApplicationContext(), DadosActivity.class);
                startActivity(cambio);
                break;
        }


    }
}
