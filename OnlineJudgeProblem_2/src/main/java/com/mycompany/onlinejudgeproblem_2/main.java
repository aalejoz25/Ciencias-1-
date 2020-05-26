/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinejudgeproblem_2;

import static java.lang.Double.max;
import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int M, N, x;
        M = s.nextInt();
        N = s.nextInt();

        while (M * N <= 100000) {
            int prevLine1 = 0;
            int prevLine2 = 0;
            int tmp;
            for (int i = 0; i < M; i++) {
                int prevNum1 = 0;
                int prevNum2 = 0;
                for (int j = 0; j < N; j++) {
                    x = s.nextInt();
                    tmp = prevNum1;
                    prevNum1 = (int) max(prevNum1, x + prevNum2);
                    prevNum2 = tmp;

                }
                tmp = prevLine1;
                prevLine1 = (int) max(prevLine1, prevNum1 + prevLine2);
                prevLine2 = tmp;
            }
            System.out.println(prevLine1);
            break;
        }
    }
}
