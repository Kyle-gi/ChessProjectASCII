package model;

public class Caballo extends Pieza {
    public Caballo(String color) {
        super(color);
        setNombre("Caballo");
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        // Get absolute differences (positive values)
        int deltaFila = Math.abs(mov.saltoVertical());    // Change in row
        int deltaColumna = Math.abs(mov.saltoHorizontal()); // Change in column

        // Knight moves 2+1 or 1+2
        // One of these must be 2 and the other must be 1
        boolean movimientoValido = (deltaFila == 2 && deltaColumna == 1) ||
                (deltaFila == 1 && deltaColumna == 2);

        if (!movimientoValido) {
            return false;
        }

        // Check destination - Knights can jump over pieces!
        // Only check if destination has a piece of the SAME color
        Posicion destino = mov.getPosFinal(); // You need this getter in Movimiento
        Pieza piezaDestino = tablero.devuelvePieza(destino);

        if (piezaDestino != null && piezaDestino.getColor().equals(this.getColor())) {
            return false; // Can't capture your own piece
        }

        return true;
    }

    @Override
    public String getSimbolo() {
        return getColor().equals("blanco") ? "♘" : "♞";
    }
}