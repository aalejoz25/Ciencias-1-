/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mergesort;

import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class main {

    public static void main(String[] args) {
        int tamañoArreglo = 0;
        Algoritmo mergesort = new Algoritmo();
        Scanner s = new Scanner(System.in);

        System.out.println("Digite el tamaño del arreglo y sus elementos");
        tamañoArreglo = s.nextInt();
        int arreglo[] = new int[tamañoArreglo];

        for (int i = 0; i < tamañoArreglo; i++) {
            arreglo[i] = s.nextInt();
        }

        mergesort.dividirArreglo(arreglo);

        System.out.println("El arreglo organizado es:");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
    }

}
