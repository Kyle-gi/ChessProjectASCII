package model;

public class Movimiento {
    private Posicion posInicial;
    private Posicion posFinal;

    public Movimiento() { }
    public Movimiento(Posicion inicio, Posicion fin){
        this.posInicial = inicio;
        this.posFinal = fin;
    }

    public boolean esVertical() {
        return posInicial.getColumna() == posFinal.getColumna();
    }

    public boolean esHorizontal() {
        return posInicial.getFila() == posFinal.getFila();
    }

    public boolean esDiagonal() {
        int deltaFila = Math.abs(posFinal.getFila() - posInicial.getFila());

        int deltaColumna = Math.abs(posFinal.getColumna() - posInicial.getColumna());

        return deltaFila == deltaColumna;
    }

    public int saltoHorizontal() {
        return posFinal.getColumna() - posInicial.getColumna();
    }

    public int saltoVertical(){
        return posFinal.getFila() - posInicial.getFila();
    }

    public Posicion getPosInicial(){
        return posInicial;
    }

    public Posicion getPosFinal(){
        return posFinal;
    }


}
