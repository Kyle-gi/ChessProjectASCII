package core;

import model.*;

public class Juego {
    private Tablero tablero;
    private String turno;

    public Juego() {
        tablero = new Tablero();
        turno = "blanco";
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno){
        this.turno = turno;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public String procesarJugada(String entrada) {
        // Paso 1: Validacion basico
        if (entrada == null || entrada.length() != 4) {
            return "Error: La jugada debe tener 4 caracteres (ej: E2E4)";
        }

        // Paso 2: Convertir la entrada al uppercase
        entrada = entrada.toUpperCase();

        // Step 3: Separar en posicion inicial al final
        String inicioStr = entrada.substring(0, 2);
        String finStr = entrada.substring(2, 4);

        // Step 4: Convert to Position objects
        Posicion inicio, fin;
        try {
            inicio = Posicion.fromNotacion(inicioStr);
            fin = Posicion.fromNotacion(finStr);
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }

        // Step 5: Check if there's a piece at starting position
        Pieza pieza = tablero.devuelvePieza(inicio);
        if (pieza == null) {
            return "Error: No hay pieza en " + inicioStr;
        }

        // Step 6: Check if piece color matches current turn
        if (!pieza.getColor().equals(turno)) {
            return "Error: No es tu turno. Turno actual: " + turno;
        }

        // Step 7: Check if destination has piece of same color
        Pieza piezaDestino = tablero.devuelvePieza(fin);
        if (piezaDestino != null && piezaDestino.getColor().equals(turno)) {
            return "Error: No puedes capturar tu propia pieza";
        }

        // Step 8: Create Move object
        Movimiento movimiento = new Movimiento(inicio, fin);

        // Step 9: Validate if move is legal for this piece
        if (!pieza.validoMovimiento(movimiento, tablero)) {
            return "Error: Movimiento no válido para " + pieza.getNombre();
        }

        // Step 10: Execute the move
        tablero.moverPieza(movimiento);

        // Step 11: Switch turns
        turno = turno.equals("blanco") ? "negro" : "blanco";

        // Step 12: Return null (no error) for successful move
        return null;
    }

    public void mostrarEstado() {
        tablero.pintarTablero();
        System.out.println("Turno: " + (turno.equals("blanco") ? "Blancas" : "Negras"));
        System.out.println("Ingrese jugada (ej: E2E4) o 'salir' para terminar:");
    }
}
