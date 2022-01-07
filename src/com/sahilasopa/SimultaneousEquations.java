package com.sahilasopa;

public class SimultaneousEquations {
    private final double a1;
    private final double b1;
    private final double c1;
    private final double a2;
    private final double b2;
    private final double c2;
    private double tempA1;
    private double tempB1;
    private double tempC1;
    private double tempA2;
    private double tempB2;
    private double tempC2;
    private Double x = null;
    private Double y = null;

    public SimultaneousEquations(double a1, double b1, double c1, double a2, double b2, double c2) {
        this.a1 = a1;
        this.b1 = b1;
        this.c1 = c1;
        this.a2 = a2;
        this.b2 = b2;
        this.c2 = c2;
    }

    public void solve() {
        printEquations();
        // try elimination
        if (Math.abs(a1) == Math.abs(a2) && a1 != a2) {
            tempB1 = b1 + b2;
            tempC1 = c1 + c2;
            y = tempC1 / tempB1;
            solveOther();
            System.out.println("X = " + x);
            System.out.println("Y = " + y);
        } else if (Math.abs(b1) == Math.abs(b2) && b1 != b2) {
            tempA1 = a1 + (a2);
            tempC1 = c1 + (c2);
            x = tempC1 / tempA1;
            solveOther();
            System.out.println("X = " + x);
            System.out.println("Y = " + y);
        } else {
            if (a1 == Math.floor(a1) && a2 == Math.floor(a2)) {
                balance(a1, a2);
                eliminate();
                solveOne();
                solveOther();
                System.out.println("X = " + x);
                System.out.println("Y = " + y);
            } else if (b1 == Math.floor(a1) && b2 == Math.floor(b2)) {
                balance(Math.abs(b1), Math.abs(b2));
                eliminate();
                solveOne();
                solveOther();
                System.out.println("X = " + x);
                System.out.println("Y = " + y);
            } else {
                System.out.println("deal with fucking decimals");
            }
        }
    }

    public void eliminate() {
        if (tempA1 == tempA2) {
            tempA1 = tempA1 - tempA2;
            tempB1 = tempB1 - tempB2;
            tempC1 = tempC1 - tempC2;
        } else if (Math.abs(tempA1) == Math.abs(tempA2)) {
            tempA1 = tempA1 + tempA2;
            tempB1 = tempB1 + tempB2;
            tempC1 = tempC1 + tempC2;
        } else if (tempB1 == tempB2) {
            tempA1 = tempA1 - tempA2;
            tempB1 = tempB1 - tempB2;
            tempC1 = tempC1 - tempC2;
        } else if (Math.abs(tempB1) == Math.abs(tempB2)) {
            tempA1 = tempA1 + tempA2;
            tempB1 = tempB1 + tempB2;
            tempC1 = tempC1 + tempC2;
        }
    }

    private void balance(double num1, double num2) {
        int lcm = findLCM((int) num1, (int) num2);
        if (num1 != lcm) {
            int multiple = (int) (lcm / num1);
            tempA1 = a1 * multiple;
            tempB1 = b1 * multiple;
            tempC1 = c1 * multiple;
        } else {
            tempA1 = a1;
            tempB1 = b1;
            tempC1 = c1;
        }
        if (num2 != lcm) {
            int multiple = (int) (lcm / num2);
            tempA2 = a2 * multiple;
            tempB2 = b2 * multiple;
            tempC2 = c2 * multiple;
        } else {
            tempA2 = a2;
            tempB2 = b2;
            tempC2 = c2;
        }
    }

    public void printEquations() {
        String eqn1 = a1 + "x ".concat(b1 + "y ").concat(" = ").concat(String.valueOf(c1));
        String eqn2 = a2 + "x ".concat(b2 + "y ").concat(" = ").concat(String.valueOf(c2));
        System.out.println(eqn1);
        System.out.println(eqn2);
    }

    public void solveOne() {
        if (tempA1 == 0) {
            y = tempC1 / tempB1;
        } else {
            x = tempC1 / tempA1;
        }
    }

    public void solveOther() {
        if (x != null) {
            y = ((c1) + (-(a1 * x))) / b1;
        } else if (y != null) {
            x = ((c1) + (-(b1 * y))) / a1;
        }
    }

    public int findLCM(int x, int y) {
        int lcm = 0;
        if (x == y) {
            return 1;
        } else {
            int[] factorsX = new int[100];
            int[] factorsY = new int[100];
            for (int i = 0; i < 100; i++) {
                factorsX[i] = x * i;
            }
            for (int i = 0; i < 100; i++) {
                factorsY[i] = y * i;
            }
            for (int k : factorsX) {
                for (int value : factorsY) {
                    if (value == k) {
                        lcm = k;
                        break;
                    }
                    if (lcm != 0) {
                        break;
                    }
                }
            }
        }
        return lcm;
    }
}
