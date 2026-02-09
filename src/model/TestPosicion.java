package model;

import model.Posicion;

public class TestPosicion {
    public static void main(String[] args) {
        // Test conversions
        Posicion p1 = Posicion.fromNotacion("A1");
        System.out.println("A1 -> " + p1);  // Should be (0,0)
        System.out.println("Notación: " + p1.toNotacion());  // Should be A1

        Posicion p2 = Posicion.fromNotacion("H8");
        System.out.println("H8 -> " + p2);  // Should be (7,7)

        Posicion p3 = Posicion.fromNotacion("E4");
        System.out.println("E4 -> " + p3);  // Should be (3,4)

        // Test error cases
        try {
            Posicion p4 = Posicion.fromNotacion("A9");  // Invalid row
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught error: " + e.getMessage());
        }
    }
}