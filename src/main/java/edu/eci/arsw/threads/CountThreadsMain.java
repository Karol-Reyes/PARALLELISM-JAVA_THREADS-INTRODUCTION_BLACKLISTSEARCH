package edu.eci.arsw.threads;
import edu.eci.arsw.threads.CountThread;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {
    public static void main(String a[]){
        Scanner scanner = new Scanner(System.in);
        int initialValue = 0;
        int finalValue = 0;
        System.out.println("Escribe el valor inicial (debe ser entero): ");

        while (!scanner.hasNextInt()) {
            System.out.println("Valor incorrecto, ingrese un numero entero ");
            System.out.println("Escribe el valor inicial (debe ser entero): ");
            scanner.next();
            }

        initialValue = scanner.nextInt();

        System.out.println("Escribe el valor final (entero y mayor al inicial): ");

        while (!scanner.hasNextInt()) {
            System.out.println("Valor incorrecto, ingrese un numero entero ");
            System.out.println("Escribe el valor inicial (debe ser entero): ");
            scanner.next();
            }

        finalValue = scanner.nextInt();

        while (finalValue <= initialValue) {
            System.out.println("valor final debe ser mayor al inicial");
            while (!scanner.hasNextInt()) {
                System.out.println("Valor incorrecto, ingrese un numero entero ");
                System.out.println("Escribe el valor inicial (debe ser entero): ");
                scanner.next();
                }
            finalValue = scanner.nextInt();
            }

        int interval = finalValue - initialValue + 1;
        int miniInterval = interval / 3;

        int firstEnd = initialValue + miniInterval - 1;

        int secondStart = firstEnd + 1;
        int secondEnd = secondStart + miniInterval - 1;

        int thirdStart = secondEnd + 1;

        CountThread firstCountThread = new CountThread(initialValue, firstEnd);
        CountThread secondCountThread = new CountThread(secondStart, secondEnd);
        CountThread threeCountThread = new CountThread(thirdStart, finalValue);

        firstCountThread.start();
        secondCountThread.start();
        threeCountThread.start();

    }
}
