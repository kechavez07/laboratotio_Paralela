package org.example;

import javax.swing.*;

public class TareaPorcentaje{
    long tiempoEsperaTotal;
    JProgressBar barraLlenar;
    long tiempoTranscurrido;

    public TareaPorcentaje(long tiempoEsperaTotal, JProgressBar barraLlenar) {
        this.tiempoEsperaTotal = tiempoEsperaTotal;
        this.barraLlenar = barraLlenar;
    }

    public void llenarBarra() {
        long tiempoInicial, tiempoFinal;
        tiempoInicial = System.nanoTime();
        do{
            tiempoFinal = System.nanoTime();
            tiempoTranscurrido = tiempoFinal - tiempoInicial;
            barraLlenar.setValue((int) (tiempoTranscurrido/tiempoEsperaTotal) * 100);
        }while (tiempoTranscurrido < tiempoEsperaTotal);


    }
}
