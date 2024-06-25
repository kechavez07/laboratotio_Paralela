package org.example;

import javax.swing.*;

public class Porcentaje {
    private static int porcentaje = 0;

    public static void incrementar(int incremento){
        if(porcentaje+incremento <= 100) {
            porcentaje = porcentaje + incremento;
            Main.llenarBarra(porcentaje);
        }
        else{
            System.out.println("El porcentaje no puede incrementarse sobre 100");
        }
    }

    public static int obtenerPorcentaje(){
        return porcentaje;
    }
}
