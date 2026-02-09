package model;

public class TestTablero {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.pintarTablero();

        //Test devuelvePieza
        Posicion pos = new Posicion(0, 0);
        Pieza pieza = tablero.devuelvePieza(pos);
        System.out.println("Pieza en A1: " + pieza);
    }
}
