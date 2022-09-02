package com.example.lab1grupo1370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class TicTacToeStatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_stats);
        getSupportActionBar().setTitle("Juego - Tres en Raya");

        Intent intent = getIntent();
        ArrayList<String> estadisticas = intent.getStringArrayListExtra("estadisticas");
        if (estadisticas != null && !estadisticas.isEmpty()) {
            String estadisticasStr = "";
            for (String i : estadisticas) {
                estadisticasStr = estadisticasStr + i + '\n';
            }
            TextView textView = findViewById(R.id.textStatsTic);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            textView.setText(estadisticasStr);
        }
    }
}