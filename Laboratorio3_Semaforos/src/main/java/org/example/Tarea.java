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
            ControlBarras tareaPorcentaje = new ControlBarras(tiempoUsado, elegirBarra(nombre));
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
}
