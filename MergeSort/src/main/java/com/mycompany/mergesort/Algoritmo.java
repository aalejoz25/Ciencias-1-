/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mergesort;

/**
 *
 * @author Alvaro
 */
public class Algoritmo {

    //uso de recursividad para subdividir el arreglo hasta que llegue a la menor division
    public void dividirArreglo(int arr[]) {
        if (arr.length < 2) {
            return;
        }

        int mitad = arr.length / 2;

        //declaracion de arreglos divididos
        int izquierda[] = new int[mitad];
        int derecha[] = new int[arr.length - mitad];

        int i = 0;
        int j = mitad;
        //ciclo para asignar los valores correspondientes a cada division
        while (i < mitad || j < arr.length) {
            if (i < mitad) {
                izquierda[i] = arr[i];
            }
            derecha[i] = arr[j];
            i++;
            j++;

        }

        //se hace recursivamente la funcion a los arreglos divididos para seguirlos subdividiendo
        dividirArreglo(derecha);
        dividirArreglo(izquierda);
        //se organizan y se unen los arreglos
        UnirArreglos(izquierda, derecha, arr);

    }

    //funcion que recibe los arreglos a unir y el arreglo original 
    public static void UnirArreglos(int izquierda[], int derecha[], int arreglo[]) {
        int i = 0, j = 0, k = 0;

        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] < derecha[j]) {
                arreglo[k] = izquierda[i];
                i++;
            } else {
                arreglo[k] = derecha[j];
                j++;
            }
            k++;
        }
        while (i < izquierda.length) {
            arreglo[k] = izquierda[i];
            k++;
            i++;
        }
        while (j < derecha.length) {
            arreglo[k] = derecha[j];
            k++;
            j++;
        }

    }

}
