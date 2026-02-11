package model;

public class Peon extends Pieza{
    private boolean primerMovimiento = true;

    public Peon(String color) {
        super(color);
        setNombre("Peon");
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        int direccion = getColor().equals("blanco") ? 1 : -1;
        int deltaFila = mov.saltoVertical();
        int deltaColumna = mov.saltoHorizontal();

        // Moverse adelante (No capturar)
        if (deltaColumna == 0) {
            //Movimiento normal 1 cuadrado adelante
            if (deltaFila == direccion && ! tablero.hayPieza(mov.getPosFinal())){
                primerMovimiento = false;
                return true;
            }
            // First move: 2 Squares Forward
            if (primerMovimiento && deltaFila == 2 * direccion && deltaColumna == 0 && !tablero.hayPieza(mov.getPosFinal())){
                Posicion medio = new Posicion(
                        mov.getPosInicial().getFila() + direccion,
                        mov.getPosInicial().getColumna()
                );
                if (!tablero.hayPieza(medio)){
                    primerMovimiento = false;
                    return true;
                }
            }
        } else if (Math.abs(deltaColumna) == 1 && deltaFila == direccion) {
            Pieza piezaDestino = tablero.devuelvePieza(mov.getPosFinal());
            if (piezaDestino != null && !piezaDestino.getColor().equals(this.getColor())){
                primerMovimiento = false;
                return true;
            }
        }
        return false;
    }
    @Override
    public String getSimbolo(){
        return getColor().equals("blanco") ? "(♟)" : "(♙)";
    }
}
