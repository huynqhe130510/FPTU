package Ui;

import business.CheckEven;
import business.CheckInput;
import business.CheckLimit;
import business.CheckOdd;
import business.CheckSquare;
import entity.QuadraticEquation;
import entity.SuperLativeEquation;

public class Main {

    public static void main(String[] args) {

        CheckInput ci = new CheckInput();
        CheckOdd co = new CheckOdd();
        CheckEven ce = new CheckEven();
        CheckSquare cs = new CheckSquare();
        CheckLimit cl = new CheckLimit();
        System.out.println("========Equation Program========");
        while (true) {
            System.out.println("\n1. Calculate Superlative Equation");
            System.out.println("2. Calculate Quadratic Equation");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = CheckLimit.checkInputIntLimit(1, 3);
            switch (choice) {
                case 1:
                    System.out.println("-------Calculate equation-------");
                    System.out.print("Enter A: ");
                    double a = ci.checkInputDouble();
                    System.out.print("Enter B: ");
                    double b = ci.checkInputDouble();

                    SuperLativeEquation s = new SuperLativeEquation(a, b);
                    s.superlativeEquation();
                    switch (s.getResult()) {
                        case 0:
                            System.out.println("Solution: x = " + s.getX());
                            break;
                        case 1:
                            System.out.println("Solution: x = Every x");
                            break;
                    }

                    System.out.print("Number is odd: ");
                    if (co.checkOdd(a)) {
                        System.out.print(a + " ");
                    }
                    if (co.checkOdd(b)) {
                        System.out.print(b + " ");
                    }
                    if (co.checkOdd(s.getX())) {
                        System.out.print(s.getX() + " ");
                    }
                    System.out.print("Number is even: ");
                    if (ce.checkEven(a)) {
                        System.out.print(a + " ");
                    }
                    if (ce.checkEven(b)) {
                        System.out.print(b + " ");
                    }
                    if (ce.checkEven(s.getX())) {
                        System.out.print(s.getX() + " ");
                    }
                    System.out.print("Number is perfect square: ");
                    if (cs.checkSquareNumber(a)) {
                        System.out.print(a + " ");
                    }
                    if (cs.checkSquareNumber(b)) {
                        System.out.print(b + " ");
                    }
                    if (cs.checkSquareNumber(s.getX())) {
                        System.out.print(s.getX() + " ");
                    }
                    break;
                case 2:
                    System.out.println("--------Calculate Quadratic Equation-------");
                    System.out.print("Enter A: ");
                    double A = ci.checkInputDouble();
                    System.out.print("Enter B: ");
                    double B = ci.checkInputDouble();
                    System.out.print("Enter C: ");
                    double C = ci.checkInputDouble();

                    QuadraticEquation qe = new QuadraticEquation(A, B, C);
                    qe.quadraticEquation();

                    switch (qe.getResutl()) {
                        case -1:
                            System.out.println("Solve haven't been called");
                            break;
                        case 0:
                            System.out.println("Absurb quadratic equation");
                            break;
                        case 1:
                            System.out.println("No solution");
                            break;
                        case 2:
                            double X = qe.getX();
                            System.out.println("Duplicate solution x = " + X);
                            break;
                        case 3:
                            double X1 = qe.getX();
                            double X2 = qe.getX1();
                            System.out.println("Solution: x1 = " + X1
                                    + ",  x2 = " + X2);
                    }

                    System.out.print("Number is odd: ");
                    if (co.checkOdd(A)) {
                        System.out.print(A + " ");
                    }
                    if (co.checkOdd(B)) {
                        System.out.print(B + " ");
                    }
                    if (co.checkOdd(C)) {
                        System.out.print(C + " ");
                    }
                    if (co.checkOdd(qe.getX())) {
                        System.out.print(qe.getX() + " ");
                    }
                    if (co.checkOdd(qe.getX1())) {
                        System.out.print(qe.getX1() + " ");
                    }
                    System.out.println();

                    System.out.print("Number is even: ");
                    if (ce.checkEven(A)) {
                        System.out.print(A + " ");
                    }
                    if (ce.checkEven(B)) {
                        System.out.print(B + " ");
                    }
                    if (ce.checkEven(C)) {
                        System.out.print(C + " ");
                    }
                    if (ce.checkEven(qe.getX())) {
                        System.out.print(qe.getX() + " ");
                    }
                    if (ce.checkEven(qe.getX1())) {
                        System.out.print(qe.getX1() + " ");
                    }
                    System.out.println();

                    System.out.print("Number is square: ");
                    if (cs.checkSquareNumber(A)) {
                        System.out.print(A + " ");
                    }
                    if (cs.checkSquareNumber(B)) {
                        System.out.print(B + " ");
                    }
                    if (cs.checkSquareNumber(C)) {
                        System.out.print(C + " ");
                    }
                    if (cs.checkSquareNumber(qe.getX())) {
                        System.out.print(qe.getX() + " ");
                    }
                    if (cs.checkSquareNumber(qe.getX1())) {
                        System.out.print(qe.getX1() + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    return;
            }
        }
    }
}
