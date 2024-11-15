/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p2_cristophersibrian;

import java.util.Random;
import java.util.Scanner;

public class Lab6P2_CristopherSibrian {

    public static void main(String[] args) {
        Scanner lab6 = new Scanner(System.in);
        int resp;

        do {
            System.out.println("-------------------------------------");
            System.out.println("1. Tablas de verdad");
            System.out.println("2. Triangulo con patron");
            System.out.println("3. Intercambio de filas y columnas");
            System.out.println("4. Salir");
            resp = lab6.nextInt();

            switch (resp) {
                case 1:
                    System.out.println("------------------------------------------");
                    System.out.println("Ingrese el tamano de la tabla de verdad: ");
                    int size = lab6.nextInt();
                    System.out.println("P    Q");
                    boolean[][] re = tabla(size);

                    System.out.println("Ingresa la operacion logica (pvq o p^q): ");
                    String op = lab6.next();

                    work(op, re);
                    break;
                case 2:
                    System.out.println("----------------------------------");
                    System.out.println("Ingresa el tamano del triangulo");
                    int tri = lab6.nextInt();
                    triangulo(tri);
                    break;
                case 3:
                    System.out.println("Ingrese el tamano de la matriz:");
                    int tam;

                    while (true) {
                        tam = lab6.nextInt();
                        if (tam % 2 == 0) {
                            break;
                        }
                        System.out.println("Debe ser un numero par");
                    }

                    int[][] matriz = generarMatriz(tam);
                    show(matriz);

                    System.out.println("Ingrese el comando para intercambiar filas y columnas (f1:c1): ");
                    String comando = lab6.next();

                    intercambiar(matriz, comando);
                    show(matriz);
                    break;
                case 4:
                    System.out.println("Gracias");
                    break;
                default:
                    System.out.println("No valido.");
            }
        } while (resp != 4);
    }

   
    public static boolean[][] tabla(int size) {
        boolean[][] ma = new boolean[size][2];
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                ma[i][j] = r.nextBoolean();
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                if (ma[i][j]) {
                    System.out.print("[1] ");
                } else {
                    System.out.print("[0] ");
                }
            }
            System.out.println();
        }

        return ma;
    }

    public static void work(String op, boolean[][] ma) {
        int size = ma.length;

        System.out.println("Operacion realizada: ");

        for (int i = 0; i < size; i++) {
            boolean p = ma[i][0];
            boolean q = ma[i][1];

            boolean n = false;

            if (op.equalsIgnoreCase("p^q")) {
                n = p && q;
            } else if (op.equalsIgnoreCase("pvq")) {
                n = p || q;
            } else {
                System.out.println("No es una operacion valida");
                return;
            }

            if (p) {
                System.out.print("[1] ");
            } else {
                System.out.print("[0] ");
            }

            if (op.equals("pvq")) {
                System.out.print("v");
            } else {
                System.out.print("^");
            }

            if (q) {
                System.out.print(" [1] ");
            } else {
                System.out.print(" [0] ");
            }

            System.out.print(" = ");
            if (n) {
                System.out.println("[1]");
            } else {
                System.out.println("[0]");
            }
        }
    }

    public static void triangulo(int tri) {
        int[][] pascal = new int[tri][];

        for (int i = 0; i < tri; i++) {
            pascal[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                }
            }
        }

        for (int i = 0; i < tri; i++) {
            for (int j = 0; j < tri - i - 1; j++) {
                System.out.print(" ");  
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(pascal[i][j] + " ");  
            }
            System.out.println();
        }
    }
    
     public static int[][] generarMatriz(int tam) {
        Random rand = new Random();
        int[][] matriz = new int[tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                matriz[i][j] = rand.nextInt(10);
            }
        }
        return matriz;
    }

    public static void show(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void intercambiar(int[][] matriz, String comando) {
        String[] partes = comando.split(":");
        String[] parte1 = partes[0].split("");
        String[] parte2 = partes[1].split("");

        String tipo1 = parte1[0];
        int num1 = Integer.parseInt(parte1[1]);
        String tipo2 = parte2[0];
        int num2 = Integer.parseInt(parte2[1]);

        if (tipo1.equals("f") && tipo2.equals("c")) {
            cabio(matriz, num1, num2);
        } else if (tipo1.equals("c") && tipo2.equals("f")) {
            cabio(matriz, num2, num1);
        } else if (tipo1.equals("f") && tipo2.equals("f")) {
            intercambio(matriz, num1, num2);
        } else if (tipo1.equals("c") && tipo2.equals("c")) {
            inter(matriz, num1, num2);
        }
    }

    public static void intercambio(int[][] matriz, int fila1, int fila2) {
        int[] temp = matriz[fila1];
        matriz[fila1] = matriz[fila2];
        matriz[fila2] = temp;
        System.out.println("Intercambiando fila " + fila1 + " y fila " + fila2);
    }

    public static void inter(int[][] matriz, int col1, int col2) {
        for (int i = 0; i < matriz.length; i++) {
            int temp = matriz[i][col1];
            matriz[i][col1] = matriz[i][col2];
            matriz[i][col2] = temp;
        }
        System.out.println("Intercambiando columna " + col1 + " y columna " + col2);
    }

    public static void cabio(int[][] matriz, int fila, int columna) {
        for (int i = 0; i < matriz.length; i++) {
            int temp = matriz[fila][i];
            matriz[fila][i] = matriz[i][columna];
            matriz[i][columna] = temp;
        }
        System.out.println("Intercambiando fila " + fila + " y columna " + columna);
    }

}
