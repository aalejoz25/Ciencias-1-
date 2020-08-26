/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arbol_rojinegro;

/**
 *
 * David Ricardo Lopez Amador (20161020505)
 * Einar Nayib Moreno Bustos (20152020401)
 * Alvaro Alejandro Zarabanda Gutierrez (20161020507)
 */
public class main {

    public static void main(String[] args) {
        Arbol<String> ab = new Arbol<String>();

        ab.InsertarNodo("C");
        ab.InsertarNodo("B");
        // ab.InsertarNodo("A");
        // ab.InsertarNodo("X");
        // ab.InsertarNodo("Z");
        // ab.InsertarNodo("J");
        // ab.InsertarNodo("K");
        ab.EliminarNodo("C");
        // ab.EliminarNodo("Z");
        // ab.EliminarNodo("A");
        System.out.println("Raiz: ");
        System.out.println("Dato: " + ab.getRaiz().getDato());
        System.out.println("Color: " + ab.getRaiz().getColor() + "\n");
        /*____________________________________________________________*/

        System.out.println("Nodo Encontrado: ");
        Nodo<String> prueba = ab.buscarNodo("B", ab.getRaiz());
        System.out.println("Dato: "+prueba.getDato());
        System.out.println("Color: "+prueba.getColor());
        
        System.out.println("Nodos nulos: ");
        System.out.println("Hijo Izquierdo:");
        System.out.println("Dato: " + prueba.getHijoIzquierdo().getDato());
        System.out.println("Color: " + prueba.getHijoIzquierdo().getColor());
        
        System.out.println("Hijo Derecho:");
        System.out.println("Dato: " + prueba.getHijoDerecho().getDato());
        System.out.println("Color: " + prueba.getHijoDerecho().getColor());

    }
}
