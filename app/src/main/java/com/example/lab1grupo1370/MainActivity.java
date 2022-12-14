package com.example.lab1grupo1370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("APPSIoT - Lab 1");
    }

    public void abrirMemoria(View view) {
        Intent intent = new Intent(this, MainActivityMemo.class);
        startActivity(intent);
    }

    public void abrirTresRaya(View view) {
        Intent intent = new Intent(this, TicTacToeActivity.class);
        startActivity(intent);
    }
}