package model;

public class Caballo extends Pieza{
    public Caballo(String color){
        super(color);
        setNombre("Caballo");
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero){
        if(!(mov.saltoVertical() || mov.saltoHorizontal())){
            return false;
        }
        if(tablero.hayPieza(mov)){
            return false;
        }
        return true;
    }

    @Override
    public String getSimbolo(){
        return getColor().equals("blanco") ? "♞" : "♘";
    }
}
