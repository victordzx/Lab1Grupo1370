package com.example.lab1grupo1370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class TicTacToeActivity extends AppCompatActivity {

    public ArrayList<String> estadisticasTic = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        getSupportActionBar().setTitle("Inicio");

        //Descomentar para ver un ejemplo de cómo se verian las estadisticas
//        estadisticasTic.add("Juego 1 : Ganó X");
//        estadisticasTic.add("Juego 2 : Canceló");
//        estadisticasTic.add("Juego 3 : Ganó O");
//        estadisticasTic.add("Juego 4 : Empate");
    }

    public void abrirTicTacToeStats(View view) {
        Intent intent = new Intent(this, TicTacToeStatsActivity.class);
        intent.putExtra("estadisticas", estadisticasTic);
        startActivity(intent);
    }
}