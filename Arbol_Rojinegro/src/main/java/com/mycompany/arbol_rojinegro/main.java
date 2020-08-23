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
        ab.InsertarNodo("D");
        //  ab.InsertarNodo("B");
        //  ab.InsertarNodo("A");
        //ab.InsertarNodo("X");
        // ab.InsertarNodo("Z");
        // ab.InsertarNodo("J");
        // ab.InsertarNodo("K");
        ab.EliminarNodo("C");
        //  ab.EliminarNodo("Z");
        //  ab.EliminarNodo("A");

        System.out.println(ab.getRaiz().getDato());
        //arreglar error de eliminacion de arbol de unicamente 2 nodos

    }
}
