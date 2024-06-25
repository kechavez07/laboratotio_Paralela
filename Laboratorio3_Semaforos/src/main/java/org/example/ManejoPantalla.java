package org.example;

public class ManejoPantalla implements Runnable{

    private static Pantalla pantalla;

    public ManejoPantalla(Pantalla pantalla){
        ManejoPantalla.pantalla = pantalla;
    }

    @Override
    public void run() {
        pantalla.pack();
        pantalla.setVisible(true);
    }

    public static Pantalla getPantalla() {
        return pantalla;
    }
}
