package model;

public class TestMovimiento {
    public static void main(String[] args) {
        // Create a move from E2 to E4
        Posicion inicio = Posicion.fromNotacion("E2");
        Posicion fin = Posicion.fromNotacion("E4");
        Movimiento mov = new Movimiento(inicio, fin);

        System.out.println("Move: " + mov);
        System.out.println("Is vertical? " + mov.esVertical());
        System.out.println("Vertical jump: " + mov.saltoVertical());

        // Test with Tablero
        Tablero tablero = new Tablero();
        Pieza peon = tablero.devuelvePieza(inicio);
        System.out.println("Piece at E2: " + peon);

        if (peon != null) {
            System.out.println("Valid move for pawn? " +
                    peon.validoMovimiento(mov, tablero));
        }
    }
}