package com.sahilasopa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x1, y1, z1, x2, y2, z2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Math Bot (Yeah I Suck)");
        System.out.println("\nThe format of equations should be: ax + by = c");
        System.out.print("Enter Equation 1: ");
        String eqn1 = scanner.nextLine();
        System.out.print("Enter Equation 2: ");
        String eqn2 = scanner.nextLine();
        eqn1 = eqn1.replaceAll("\\s+", "");
        eqn2 = eqn2.replaceAll("\\s+", "");
        z1 = Integer.parseInt(eqn1.substring(eqn1.indexOf("=") + 1).trim());
        z2 = Integer.parseInt(eqn2.substring(eqn2.indexOf("=") + 1).trim());
        if (eqn1.indexOf("x") == 0) {
            x1 = 1;
        } else {
            x1 = Integer.parseInt(eqn1.substring(0, eqn1.indexOf("x")));
        }
        if (eqn1.charAt(eqn1.indexOf("y") - 1) == '+' || eqn1.charAt(eqn1.indexOf("y") - 1) == '-') {
            if (eqn1.charAt(eqn1.indexOf("y") - 1) == '+') {
                y1 = 1;
            } else {
                y1 = -1;
            }
        } else if (eqn1.replaceAll("[^=]*$", "").indexOf("-", 1) > 0) {
            y1 = Integer.parseInt(eqn1.substring(eqn1.indexOf("-", 1), eqn1.indexOf("y")));
        } else if (eqn1.replaceAll("[^=]*$", "").indexOf("+", 1) > 0) {
            y1 = Integer.parseInt(eqn1.substring(eqn1.indexOf("+", 1) + 1, eqn1.indexOf("y")));
        } else {
            y1 = 1;
        }
        if (eqn2.indexOf("x") == 0) {
            x2 = 1;
        } else {
            x2 = Integer.parseInt(eqn2.substring(0, eqn2.indexOf("x")));
        }
        if (eqn2.charAt(eqn2.indexOf("y") - 1) == '+' || eqn2.charAt(eqn2.indexOf("y") - 1) == '-') {
            if (eqn2.charAt(eqn2.indexOf("y") - 1) == '+') {
                y2 = 1;
            } else {
                y2 = -1;
            }
        } else if (eqn2.replaceAll("[^=]*$", "").indexOf("-", 1) > 0) {
            y2 = Integer.parseInt(eqn2.substring(eqn2.indexOf("-", 1), eqn2.indexOf("y")));
        } else if (eqn2.replaceAll("[^=]*$", "").indexOf("+", 1) > 0) {
            y2 = Integer.parseInt(eqn2.substring(eqn2.indexOf("+", 1) + 1, eqn2.indexOf("y")));
        } else {
            y2 = 1;
        }
        SimultaneousEquations equations = new SimultaneousEquations(x1, y1, z1, x2, y2, z2);
        equations.solve();
    }
}