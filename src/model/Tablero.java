package model;

import javax.swing.text.TabExpander;

public class Tablero {
    private Pieza[][] tabla = new Pieza[8][8];

    public Tablero() {
        inicializarTablero();
    }

    private void inicializarTablero(){

        //Limpiando la tabla primero
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                tabla[i][j] = null;
            }
        }
        //Piezas blanco
        tabla[0][0] = new Torre("blanco");
        tabla[0][1] = new Caballo("blanco");
        tabla[0][2] = new Alfil("blanco");
        tabla[0][3] = new Dama("blanco");
        tabla[0][4] = new Rey("blanco");
        tabla[0][5] = new Alfil("blanco");
        tabla[0][6] = new Caballo("blanco");
        tabla[0][7] = new Torre("blanco");

        // Peones blancos
        for (int i = 0; i < 8; i++){
            tabla[1][i] = new Peon("blanco");
        }

        //Piezas negros
        tabla[7][0] = new Torre("negro");
        tabla[7][1] = new Caballo("negro");
        tabla[7][2] = new Alfil("negro");
        tabla[7][3] = new Dama("negro");
        tabla[7][4] = new Rey("negro");
        tabla[7][5] = new Alfil("negro");
        tabla[7][6] = new Caballo("negro");
        tabla[7][7] = new Torre("negro");

        for (int i = 0; i < 8; i++){
            tabla[6][i] = new Peon("negro");
        }
    }

    public void pintarTablero(){
        System.out.println("   Aㅤ Bㅤ Cㅤ Dㅤ Eㅤ F   G   H");
        for (int fila = 7; fila >= 0; fila--){
            System.out.print((fila + 1) + " ");
            for (int col = 0; col < 8; col++){
                if(tabla[fila][col] == null){
                    System.out.print("(ㅤ)");
                }
                else {
                    System.out.print(tabla[fila][col].getSimbolo());
                }
            }
            System.out.println((fila + 1));
        }
        System.out.println("   Aㅤ Bㅤ Cㅤ Dㅤ Eㅤ F   G   H");
    }

    public boolean hayPieza(int fila, int columna) {
        return tabla[fila][columna] != null;
    }

    public boolean hayPieza(Posicion pos) {
        return hayPieza(pos.getFila(), pos.getColumna());
    }

    public boolean hayPiezasEntre(Movimiento mov){
        Posicion inicio = mov.getPosInicial();
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
        if (pieza != null) {
            quitaPieza(mov.getPosInicial());
            ponPieza(pieza, mov.getPosFinal());
        }
    }
}
