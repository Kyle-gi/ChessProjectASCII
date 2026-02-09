package model;

import javax.swing.text.TabExpander;

public class Tablero {
    private Pieza[][] tabla = new Pieza[8][8];

    public Tablero() {
        inicializarTablero();
    }

    private void inicializarTablero(){

        //Piezas blanco
        tabla[0][0] = new Torre("blanco");
        tabla[0][1] = new Caballo("blanco");
        tabla[0][2] = new

        //Piezas negros
        tabla[7][0] = new Torre("negro");
    }

    public void pintarTablero(){
        System.out.println(" A  B  C  D  E  F  G  H");
        for (int fila = 7; fila >= 0; fila--){
            System.out.print((fila + 1) + " ");
            for (int col = 0; col < 8; col++){
                if(tabla[fila][col] == null){
                    System.out.print(" . ");
                }
                else {
                    System.out.print(" " + tabla[fila][col].getSimbolo() + " ");
                }
            }
            System.out.println(" " + (fila + 1));
        }
        System.out.println(" A  B  C  D  E  F  G  H");
    }

    public boolean hayPieza(int fila, int columna) {
        return tabla[fila][columna] != null;
    }

    public boolean hayPieza(Posicion pos) {
        return hayPieza(pos.getFila(), pos.getColumna());
    }

    public boolean hayPiezasEntre(Movimiento mov){
        Posicion inicio = mov.getPosFinal();
        Posicion fin = mov.getPosFinal();

        //Eso consigue el dirreccion de movimiento
        int dirFila = Integer.signum(fin.getFila() - inicio.getFila());
        int dirColumna = Integer.signum(fin.getColumna() - inicio.getColumna());

        // empezando a revisar despues de empezando
        int filaActual = inicio.getFila() + dirFila;
        int columnaActual = inicio.getColumna() + dirColumna;

        // revisando cada cuadrada hasta llegar al posicion
        while (filaActual != fin.getFila() || columnaActual != fin.getColumna()){
            if (tabla[filaActual][columnaActual] != null){
                return true; // encontrando piezas en entre
            }
            filaActual += dirFila;
            columnaActual += dirColumna;
        }
        return false; // No encontrado piezas en entre
    }

    public Pieza devuelvePieza(Posicion destino) {
        if (destino.getFila() < 0 || destino.getFila() > 7 || destino.getColumna() < 0 || destino.getColumna() > 7){
            return null;
        }
        return tabla[destino.getFila()][destino.getColumna()];
    }

    public void ponPieza(Pieza pieza, Posicion pos){
        tabla[pos.getFila()][pos.getColumna()] = pieza;
    }

    public void quitaPieza(Posicion pos) {
        tabla[pos.getFila()][pos.getColumna()] = null;
    }

    public void moverPieza(Movimiento mov) {
        Pieza pieza = devuelvePieza(mov.getPosInicial());
        quitaPieza(mov.getPosInicial());
        ponPieza(pieza, mov.getPosFinal());
    }
}
