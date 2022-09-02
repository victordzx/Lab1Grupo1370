package com.example.lab1grupo1370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivityMemo extends AppCompatActivity {

    public ArrayList<String> estadisticasMemo = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_memo);
        getSupportActionBar().setTitle("Inicio");

        //Descomentar para ver un ejemplo de cómo se verian las estadisticas
//        estadisticasMemo.add("Juego 1 : Terminó en 2 minutos");
//        estadisticasMemo.add("Juego 2 : Canceló");
//        estadisticasMemo.add("Juego 3 : Terminó en 0.5 minutos");
    }

    public void abrirMemoStats(View view) {
        Intent intent = new Intent(this, MainActivityMemoStats.class);
        intent.putExtra("estadisticas", estadisticasMemo);
        startActivity(intent);
    }
}