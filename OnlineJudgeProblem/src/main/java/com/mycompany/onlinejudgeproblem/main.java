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

    public main() {
        int tam = 0;
        tam = s.nextInt();
        int datos[] = new int[tam];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = s.nextInt();
        }

        int n = datos.length;
        int movimientos = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if (datos[j]>datos[j+1]) {
                    int aux = datos[j];
                    datos[j] = datos[j+1];
                    datos[j+1] = aux;
                    movimientos++;                    
                }
                
            }
            
        }
        if (movimientos%2==0) {
            System.out.println("Carlos");
        }else{
            System.out.println("Marcelo");
        }
    }

    public static void main(String[] args) {
        main m = new main();
    }
}
