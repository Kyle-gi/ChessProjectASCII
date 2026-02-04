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

    }
}
