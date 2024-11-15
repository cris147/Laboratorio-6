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
          // System.out.println("");
       
           switch(resp) {
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
                   System.out.println("");
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
        
        for(int i = 0; i < size; i++) {
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
    
    public static void work(String op, boolean[][] ma){
        int size = ma.length;
        
        System.out.println("Operacion realizada: ");
        
        for(int i = 0; i < size; i++) {
            boolean p = ma[i][0];
            boolean q = ma[i][1];
            
            boolean n = false;

            if(op.equalsIgnoreCase("p^q")) {
                n = p && q;
            } else if(op.equalsIgnoreCase("pvq")) {
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
    
    public static void triangulo(int tri){
        int size = (tri*2) +1;
        int[][] pascal = new int[size][size];
        
        for (int i = 0; i<tri; i++){
            for (int j = 0; j< i; j++){
                if(j == 0 || j == i){
                    pascal[i][j] = 1; 
                }else{
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];   
                }
            }
        }
      for (int i = 0; i<tri; i++){
          for(int j = 0; j< i; j++){
              System.out.print("["+pascal[i][j] + "]");
          }
          System.out.println();
      }
        
    }
    
    
}


