package model;

public class Posicion {
    private int fila;
    private int columna;

    // Constructores
    public Posicion() {}

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    // Getters and setters
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "(" + fila + "," + columna + ")";
    }

    public String toNotacion() {
        char columnaLetra = (char) ('A' + columna);
        int filaNumero = fila + 1;
        return "" + columnaLetra + filaNumero;
    }

    public static Posicion fromNotacion(String notacion) {
        // Validate input
        if (notacion == null || notacion.length() != 2) {
            throw new IllegalArgumentException("Notación inválida: " + notacion);
        }

        // Convert to uppercase
        notacion = notacion.toUpperCase();
        char letraColumna = notacion.charAt(0);
        char numeroFila = notacion.charAt(1);

        // Validate
        if (letraColumna < 'A' || letraColumna > 'H') {
            throw new IllegalArgumentException("Columna debe ser A-H: " + letraColumna);
        }

        if (numeroFila < '1' || numeroFila > '8') {
            throw new IllegalArgumentException("Fila debe ser 1-8: " + numeroFila);
        }

        // Convert to indices
        int columna = letraColumna - 'A';  // A=0, B=1, ... H=7
        int fila = numeroFila - '1';       // '1'=0, '2'=1, ... '8'=7

        return new Posicion(fila, columna);
    }
}