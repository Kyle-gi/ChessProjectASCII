package model;

public class Torre extends Pieza{

    public Torre(String color){
        super(color);
        setNombre("Torre");
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        if(!(mov.esVertical() || mov.esHorizontal())) {
            return false;
        }
        if(tablero.hayPiezasEntre(mov)){
            return false;
        }
        return true;
    }

    @Override
    public String getSimbolo() {
        return getColor().equals("blanco") ? "(♜)" : "(♖)";
    }
}
