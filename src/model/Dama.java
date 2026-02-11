package model;

public class Dama extends Pieza{
    public Dama(String color) {
        super(color);
        setNombre("Dama");
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero){
        //Dama mueve como Alfil o Torre pues implementamos los movimientos:
        Torre torreSimulada = new Torre(getColor());
        Alfil alfilSimulado = new Alfil(getColor());

        return torreSimulada.validoMovimiento(mov, tablero) || alfilSimulado.validoMovimiento(mov, tablero);
    }

    @Override
    public String getSimbolo() {
        return getColor().equals("blanco") ? "(♛)" : "(♕)";
    }
}
