package model;

public class Caballo extends Pieza {
    public Caballo(String color) {
        super(color);
        setNombre("Caballo");
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {

        int deltaFila = Math.abs(mov.saltoVertical());
        int deltaColumna = Math.abs(mov.saltoHorizontal());

        boolean movimientoValido = (deltaFila == 2 && deltaColumna == 1) ||
                (deltaFila == 1 && deltaColumna == 2);

        if (!movimientoValido) {
            return false;
        }


        Posicion destino = mov.getPosFinal();
        Pieza piezaDestino = tablero.devuelvePieza(destino);

        if (piezaDestino != null && piezaDestino.getColor().equals(this.getColor())) {
            return false; // Can't capture your own piece
        }

        return true;
    }

    @Override
    public String getSimbolo() {
        return getColor().equals("blanco") ? "(♞)" : "(♘)";
    }
}