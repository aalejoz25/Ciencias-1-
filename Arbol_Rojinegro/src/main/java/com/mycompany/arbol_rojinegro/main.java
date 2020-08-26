/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arbol_rojinegro;

import java.util.Scanner;

/**
 *
 * David Ricardo Lopez Amador (20161020505) Einar Nayib Moreno Bustos
 * (20152020401) Alvaro Alejandro Zarabanda Gutierrez (20161020507)
 */
public class main {

    public static void main(String[] args) {
        boolean programa = true;
        Scanner s = new Scanner(System.in);
        Arbol<Integer> ab = new Arbol<Integer>();

        while (programa) {

            int caso = 0;
            int nodo;
            System.out.println("Digite 1 para agregar un nodo\nDigite 2 para eliminar un nodo\nDigite 3 para buscar un nodo\nDigite 4 para recorrido IRD el arbol\n0 para salir: ");
            caso = s.nextInt();

            switch (caso) {
                case 0:
                    programa = false;
                    break;
                case 1:
                    System.out.println("\nDigite el numero que desea agregar");
                    nodo = s.nextInt();
                    ab.InsertarNodo(nodo);
                    System.out.println("se ha agregado el nodo!!!\n");
                    break;
                case 2:
                    try {
                    System.out.println("\nDigite el nodo que desea eliminar");
                    nodo = s.nextInt();
                    ab.EliminarNodo(nodo);
                    System.out.println("se ha eliminado el nodo!!!\n");
                    break;

                } catch (Exception e) {
                    System.out.println("No existe el nodo\n");
                    break;
                }

                case 3:
                    try {
                    System.out.println("\nDigite el nodo que desea buscar: ");
                    nodo = s.nextInt();

                    Nodo<Integer> encontrado = ab.buscarNodo(nodo, ab.getRaiz());

                    if (encontrado != null) {
                        System.out.println("Se ha encontrado el nodo!!!");
                    }

                    System.out.println("El color del nodo es: " + encontrado.getColor() + "\n");
                    try {
                        System.out.println("Su hijo izquierdo es: " + encontrado.getHijoIzquierdo().getDato());
                        System.out.println("Color: " + encontrado.getHijoIzquierdo().getColor() + "\n");
                    } catch (NullPointerException e) {
                    }
                    try {
                        System.out.println("Su hijo derecho es: " + encontrado.getHijoDerecho().getDato());
                        System.out.println("Color: " + encontrado.getHijoDerecho().getColor() + "\n");
                    } catch (NullPointerException e) {
                    }
                    break;

                } catch (NullPointerException e) {
                    System.out.println("No existe el nodo\n");
                    break;
                }

                case 4:
                    try {
                    ab.recorrerIRD();
                    System.out.println("\n");
                    break;
                } catch (NullPointerException e) {
                    System.out.println("No hay arbol");
                    break;
                }

                default:
                    System.out.println("\nNo selecciono un caso valido");
                    break;

            }

        }

        /*
        ab.InsertarNodo(26);
        ab.InsertarNodo(17);
        ab.InsertarNodo(41);
        ab.InsertarNodo(14);
        ab.InsertarNodo(21);
        ab.InsertarNodo(30);
        ab.InsertarNodo(47);
        ab.InsertarNodo(10);
        ab.InsertarNodo(16);
        ab.InsertarNodo(19);
        ab.InsertarNodo(23);
        ab.InsertarNodo(28);
        ab.InsertarNodo(38);
        ab.InsertarNodo(7);
        ab.InsertarNodo(12);
        ab.InsertarNodo(15);
        ab.InsertarNodo(20);
        ab.InsertarNodo(35);
        ab.InsertarNodo(39);
        ab.InsertarNodo(3);
         */
    }
}
