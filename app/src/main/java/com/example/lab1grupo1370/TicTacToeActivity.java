package com.example.lab1grupo1370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TicTacToeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        getSupportActionBar().setTitle("Inicio");
    }

    public void abrirTicTacToeStats(View view) {
        Intent intent = new Intent(this, TicTacToeStatsActivity.class);
        startActivity(intent);
    }
}