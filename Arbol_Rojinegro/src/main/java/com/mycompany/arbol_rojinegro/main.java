/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arbol_rojinegro;

/**
 *
 * @author Alvaro
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
        System.out.println("Color: " + prueba.getColor());

    }
}
