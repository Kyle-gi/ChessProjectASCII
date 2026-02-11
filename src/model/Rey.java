package model;

public class Rey extends Pieza{
    public Rey(String color) {
        super(color);
        setNombre("Rey");
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero){
        int deltaFila = Math.abs(mov.saltoVertical());
        int deltaColumna = Math.abs(mov.saltoHorizontal());

        // Rey solamente moverse 1 cuadrado de cualquier dirreccion
        boolean movimientoValido = deltaFila <= 1 && deltaColumna <= 1 && !(deltaFila == 0 && deltaColumna == 0);

        if (!movimientoValido){
            return false;
        }

        // Revisar el destino
        Posicion destino = mov.getPosFinal();
        Pieza piezaDestino = tablero.devuelvePieza(destino);

        if (piezaDestino != null && piezaDestino.getColor().equals(this.getColor())){
            return false; //No puede comer su propio pieza
        }
        return true;
    }

   @Override
   public String getSimbolo() {
        return getColor().equals("blanco") ? "(♚)" : "(♔)";
   }
}
