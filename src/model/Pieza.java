package model;

public abstract class Pieza {
    private String color;
    private String nombre;

    public Pieza(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getNombre(){
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract boolean validoMovimiento(Movimiento mov, Tablero tablero);

    public abstract String getSimbolo();

    @Override
    public String toString(){
        return color + " " + nombre;
    }
}
