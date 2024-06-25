package org.example;

import javax.swing.*;
import java.util.concurrent.Semaphore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Pantalla pantalla;

    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(1);
        Tarea tarea1 = new Tarea("Información Personal", 40, 1, semaforo);
        Tarea tarea2 = new Tarea("Ingresos", 10, 2, semaforo);
        Tarea tarea3 = new Tarea("Egresos", 10, 2, semaforo);
        Tarea tarea4 = new Tarea("Referencias", 5, 1, semaforo);
        Tarea tarea5 = new Tarea("Formas de pago", 35, 2, semaforo);


        pantalla = new Pantalla();

        tarea1.start();
        tarea2.start();
        tarea3.start();
        tarea4.start();
        tarea5.start();

        pantalla.pack();
        pantalla.setVisible(true);

        try {
            tarea1.join();
            tarea2.join();
            tarea3.join();
            tarea4.join();
            tarea5.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(Porcentaje.obtenerPorcentaje());

    }

    public static void llenarBarra(int porcentaje){
        JProgressBar barraCarga = pantalla.getBarraGeneral();
        barraCarga.setValue(porcentaje);
    }

    public static Pantalla getPantalla() {
        return pantalla;
    }

}