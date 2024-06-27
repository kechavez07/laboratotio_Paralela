package org.example;

import javax.swing.*;
import java.util.concurrent.Semaphore;

public class Tarea extends Thread{

    private String nombre;
    private int porcentajeAportado;
    private long tiempoUsado;
    private Semaphore semaforo;

    public Tarea(String nombre, int porcentajeAportado, int codigoTiempo, Semaphore semaforo){
        super();
        this.nombre = nombre;
        this.porcentajeAportado = porcentajeAportado;
        //5 segs de la simulacion por el numero de horas (codigoTiempo)
        this.tiempoUsado = 5000000000L * codigoTiempo;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try{
            System.out.println("Tarea: " + nombre + ", comenzada");
            System.out.println("Tarea: " + nombre + ", esperando la seccion critica");
            semaforo.acquire();
            System.out.println("Tarea: " + nombre + ", entro a la sección crítica");
            llenarBarra(elegirBarra(nombre), tiempoUsado);
            Porcentaje.incrementar(porcentajeAportado);
            System.out.println("Tarea: " + nombre + ", salio de la sección crítica");

        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        finally {
            semaforo.release();
        }
    }

    public JProgressBar elegirBarra(String nombre){
        switch(nombre){
            case "Información Personal":
                return Main.getPantalla().getBarraInfoPersonal();
            case "Ingresos":
                return Main.getPantalla().getBarraIngresos();
            case "Egresos":
                return Main.getPantalla().getBarraEgresos();
            case "Referencias":
                return Main.getPantalla().getBarraReferencias();
            case "Formas de pago":
                return Main.getPantalla().getBarraMetPago();
            default:
                throw new IllegalStateException("Unexpected value: " + nombre);
        }
    }

    public void llenarBarra(JProgressBar barraLlenar, long tiempoEsperaTotal) {
        long tiempoInicial, tiempoFinal, tiempoTranscurrido;
        tiempoInicial = System.nanoTime();
        int porcentaje, porcentajeGeneral;
        int porcentajePrevio = 0;
        do{
            tiempoFinal = System.nanoTime();
            tiempoTranscurrido = tiempoFinal - tiempoInicial;
            porcentaje = ((int) ((double)(tiempoTranscurrido*100/tiempoEsperaTotal)));
            if(porcentaje > 100) porcentaje = 100;
            barraLlenar.setValue(porcentaje);
        }while (tiempoTranscurrido < tiempoEsperaTotal);
    }
}
