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
            System.out.println((double)(tiempoTranscurrido)/(double)(tiempoEsperaTotal));
            barraLlenar.setValue((int) ((double)(tiempoTranscurrido)*100/(double)(tiempoEsperaTotal)));
        }while (tiempoTranscurrido < tiempoEsperaTotal);


    }
}
