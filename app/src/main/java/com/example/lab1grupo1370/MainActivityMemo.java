package com.example.lab1grupo1370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivityMemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_memo);
        getSupportActionBar().setTitle("Inicio");
    }

    public void abrirMemoStats(View view) {
        Intent intent = new Intent(this, MainActivityMemoStats.class);
        startActivity(intent);
    }
}