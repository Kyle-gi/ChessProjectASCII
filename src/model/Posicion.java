package model;

public class Posicion {

    private int fila;
    private int columna;

    //Constructores;
    public Posicion(){}
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila){
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna){
        this.columna = columna;
    }

    @Override
    public String toString(){
        return "(" + fila + "," + columna + ")";
    }

    public static Posicion fromNotacion(String notacion) {

    }
}
