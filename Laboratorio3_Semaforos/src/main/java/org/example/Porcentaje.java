package org.example;

public class Porcentaje {
    private static int porcentaje = 0;

    public static void incrementar(int incremento){
        if(porcentaje+incremento <= 100 && incremento > 0) {
            porcentaje = porcentaje + incremento;
            Main.llenarBarraGeneral(porcentaje);
        }
    }

    public static int obtenerPorcentaje(){
        return porcentaje;
    }
}
