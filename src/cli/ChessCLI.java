package cli;

import core.Juego;
import java.util.Scanner;

public class ChessCLI {
    public static void main(String[] args) {
        Juego juego = new Juego();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== AJEDREZ EN CONSOLA ===");

        boolean jugando = true;
        while (jugando) {
            juego.mostrarEstado();
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("salir")) {
                jugando = false;
                continue;
            }

            String error = juego.procesarJugada(entrada);
            if (error != null) {
                System.out.println(error);
            }
        }

        scanner.close();
        System.out.println("Juego terminado.");
    }
}
