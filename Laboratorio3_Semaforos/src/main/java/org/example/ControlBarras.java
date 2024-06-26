package org.example;

import javax.swing.*;

public class ControlBarras {
    long tiempoEsperaTotal;
    JProgressBar barraLlenar;
    long tiempoTranscurrido;

    public ControlBarras(long tiempoEsperaTotal, JProgressBar barraLlenar) {
        this.tiempoEsperaTotal = tiempoEsperaTotal;
        this.barraLlenar = barraLlenar;
    }

    public void llenarBarra() {
        long tiempoInicial, tiempoFinal;
        tiempoInicial = System.nanoTime();
        int porcentaje;
        do{
            tiempoFinal = System.nanoTime();
            tiempoTranscurrido = tiempoFinal - tiempoInicial;
            porcentaje = (int) ((double)(tiempoTranscurrido*100/tiempoEsperaTotal));
            barraLlenar.setValue(porcentaje);
        }while (tiempoTranscurrido < tiempoEsperaTotal);


    }
}
