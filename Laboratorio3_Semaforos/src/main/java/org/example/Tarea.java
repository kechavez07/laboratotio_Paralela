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
            TareaPorcentaje tareaPorcentaje = new TareaPorcentaje(tiempoUsado, elegirBarra(nombre));
            tareaPorcentaje.llenarBarra();
            semaforo.acquire();
            System.out.println("Tarea: " + nombre + ", entró en la sección crítica");
            Porcentaje.incrementar(porcentajeAportado);
            System.out.println("Tarea: " + nombre + ", terminada");
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
                return ManejoPantalla.getPantalla().getBarraInfoPersonal();
            case "Ingresos":
                return ManejoPantalla.getPantalla().getBarraIngresos();
            case "Egresos":
                return ManejoPantalla.getPantalla().getBarraEgresos();
            case "Referencias":
                return ManejoPantalla.getPantalla().getBarraReferencias();
            case "Formas de pago":
                return ManejoPantalla.getPantalla().getBarraMetPago();
            default:
                throw new IllegalStateException("Unexpected value: " + nombre);
        }
    }
}
