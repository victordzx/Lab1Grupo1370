package com.example.lab1grupo1370;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MainActivityMemo extends AppCompatActivity {

    public ArrayList<String> estadisticasMemo = new ArrayList();
    private final int[] botonesID = {R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,
            R.id.btn8,R.id.btn9,R.id.btn10,R.id.btn11,R.id.btn12,R.id.btn13,R.id.btn14,R.id.btn15,R.id.btn16};
    private HashMap<Button,String> btnLetra = new HashMap<>();
    private int contadorElecciones;
    private ArrayList<Button> btnElecciones = new ArrayList<>();
    private Instant instantStarted, instantStopped;
    private ArrayList<String> listaTiempos = new ArrayList<>();

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

    public void memoInitalize(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            instantStarted = Instant.now();
        }

        contadorElecciones = 0;
        btnElecciones.clear();
        btnLetra.clear();
        TextView cronometro = (TextView) findViewById(R.id.mostrarTiempo);
        cronometro.setText("");

        ArrayList<String> letrasMemoria = new ArrayList<>();
        letrasMemoria.add("A");
        letrasMemoria.add("B");
        letrasMemoria.add("C");
        letrasMemoria.add("D");
        letrasMemoria.add("E");
        letrasMemoria.add("F");
        letrasMemoria.add("G");
        letrasMemoria.add("H");

        ArrayList<String> letritas = new ArrayList<>();
        for(String letras : letrasMemoria){
            letritas.add(letras);
            letritas.add(letras);
        }

        Collections.shuffle(letritas);

        for(int i=0; i<botonesID.length;i++){
            Button botoncito = (Button) findViewById(botonesID[i]);
            btnLetra.put(botoncito,letritas.get(i));
            botoncito.setText(String.valueOf(letritas.get(i)));
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                inicioMemo();
            }
        }, 1000);
    }

    public void inicioMemo(){
        for(int i=0;i<botonesID.length;i++){
            Button botoncito = (Button) findViewById(botonesID[i]);
            botoncito.setText("-");
        }
    }

    public void extraerLetraBoton(View view){
        if(contadorElecciones < 2){
            Button boton = (Button) view;
            String letra = btnLetra.get(boton);

            if(letra != null) {
                btnElecciones.add(boton);
                boton.setText(String.valueOf(letra));
                contadorElecciones++;

                if (btnElecciones.size() == 2) {

                    if(btnElecciones.get(0).getId() != btnElecciones.get(1).getId()) {
                        String letra1 = btnLetra.get(btnElecciones.get(0));
                        String letra2 = btnLetra.get(btnElecciones.get(1));

                        if (letra1.equalsIgnoreCase(letra2)) {
                            // Letras iguales
                            btnLetra.remove(btnElecciones.get(0));
                            btnLetra.remove(btnElecciones.get(1));

                        } else {
                            // Letras diferentes
                            Button btn1Selec = btnElecciones.get(0);
                            Button btn2Selec = btnElecciones.get(1);

                            Handler handler1 = new Handler();
                            handler1.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    btn1Selec.setText("-");
                                    btn2Selec.setText("-");
                                }
                            }, 500);

                        }
                    }else{
                        btnElecciones.get(0).setText("-");
                    }
                    btnElecciones.clear();
                    contadorElecciones = 0;
                }

                if (btnLetra.size() == 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        instantStopped = Instant.now();
                    }

                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        long seconds = instantStopped.getEpochSecond() - instantStarted.getEpochSecond();

                        if (seconds < 60){
                            String tiempo = "Termino en " + (seconds/60.0) + " minutos";

                            String estadistica = "Juego " + (listaTiempos.size() + 1) + " : " + tiempo;
                            listaTiempos.add(estadistica);

                            TextView cronometro = (TextView) findViewById(R.id.mostrarTiempo);
                            cronometro.setText(tiempo);

                        }else{
                            String tiempo = "Termino en " + (60.0/seconds) + " minutos";

                            String estadistica = "Juego " + (listaTiempos.size() + 1) + " : " + tiempo;
                            listaTiempos.add(estadistica);

                            TextView cronometro = (TextView) findViewById(R.id.mostrarTiempo);
                            cronometro.setText(tiempo);
                        }
                    }
                }
            }
        }
    }

    public void rebootJuego(View view){

        if(btnLetra.size() != 0){
            String estadistica = "Juego " + (listaTiempos.size() + 1) + " : " + "Canceló";
            listaTiempos.add(estadistica);
        }
        memoInitalize();
    }

    public void abrirMemoStats(View view) {
        Intent intent = new Intent(this, MainActivityMemoStats.class);
        intent.putExtra("estadisticas", estadisticasMemo);
        startActivity(intent);
    }
}