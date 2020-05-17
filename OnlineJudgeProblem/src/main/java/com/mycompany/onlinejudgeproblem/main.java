/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinejudgeproblem;

import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class main {

    Scanner s = new Scanner(System.in);
    public static int izquierda, derecha, ultimo;
    int movimientos = 0;

    public main() {
        int tam = 0;
        tam = s.nextInt();
        int datos[] = new int[tam];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = s.nextInt();
        }
//ALGORITMO IMPLEMENTADO ANTERIORMENTE
        //int n = datos.length;
        /*  for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (datos[j] > datos[j + 1]) {
                    int aux = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = aux;
                    movimientos++;
                }

            }

        }*/
//IMPLEMENTACION DE BURBUJA BIDIRECCIONAL PARA OPTIMIZAR EL TIEMPO DE EJECUCION
        izquierda = 1;
        derecha = datos.length;
        ultimo = datos.length - 1;

        do {
            for (int i = datos.length - 1; i > 0; i--) {
                //Burbuja hacia la izquierda
                //Los valores menores van a la izquierda 
                if (datos[i - 1] > datos[i]) {
                    int aux = datos[i]; // variable auxiliar para poder hacer intercambio de
                    datos[i] = datos[i - 1];  // posicion
                    datos[i - 1] = aux;
                    ultimo = i;
                    movimientos++;
                }
            }
            izquierda = ultimo + 1;
            for (int j = 1; j < datos.length; j++) {
                if (datos[j - 1] > datos[j]) {
                    int aux = datos[j];
                    datos[j] = datos[j - 1];
                    datos[j - 1] = aux;
                    ultimo = j;
                    movimientos++;
                }
            }
            derecha = ultimo - 1;

        } while (derecha >= izquierda);

        if (movimientos % 2 == 0) {
            System.out.println("Carlos");
        } else {
            System.out.println("Marcelo");
        }
    }

    public static void main(String[] args) {
        main m = new main();
    }
}
