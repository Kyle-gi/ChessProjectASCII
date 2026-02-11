package model;

public class Alfil extends Pieza{
    public Alfil(String color) {
        super(color);
        setNombre("Alfil");
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero){
        // deberia moverse diagonal
        if (!mov.esDiagonal()) {
            return false;
        }

        // Revisar que si las piezas estan en camino
        if (tablero.hayPiezasEntre(mov)){
            return false;
        }

        //Revisar la destinacion
        Posicion destino = mov.getPosFinal();
        Pieza piezaDestino = tablero.devuelvePieza(destino);

        if (piezaDestino != null && piezaDestino.getColor().equals(this.getColor())) {
            return false;
        }
        return true;
    }

    @Override
    public String getSimbolo(){
        return getColor().equals("blanco") ? "(♝)" : "(♗)";
    }
}
