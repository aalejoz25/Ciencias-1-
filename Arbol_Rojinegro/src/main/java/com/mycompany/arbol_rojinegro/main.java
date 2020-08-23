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

        ab.InsercionRN("C");
        ab.InsercionRN("D");
        ab.InsercionRN("B");
        ab.InsercionRN("A");
        ab.InsercionRN("X");
        ab.InsercionRN("Z");
        ab.InsercionRN("J");
        ab.InsercionRN("K");

       
        System.out.println(ab.getRaiz().getHijoIzquierdo().getHijoIzquierdo().getDato());
    }
}
