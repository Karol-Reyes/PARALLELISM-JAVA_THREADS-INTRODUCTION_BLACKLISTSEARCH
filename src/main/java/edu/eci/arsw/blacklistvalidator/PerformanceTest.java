package edu.eci.arsw.blacklistvalidator;

import java.util.List;

public class PerformanceTest {
    public static void main(String a[]) {
        String ip = "202.24.34.55";
        
        int n = a.length > 0 ? Integer.parseInt(a[0]) : Runtime.getRuntime().availableProcessors();

        HostBlackListsValidator host = new HostBlackListsValidator();
        long startTime = System.currentTimeMillis();
        List<Integer> resultado = host.checkHost(ip, n);
        long endTime = System.currentTimeMillis();

        System.out.println("N hilos: " + n + " | Tiempo: " + (endTime - startTime) + " ms");
        System.out.println("Ocurrencias: " + resultado);
    }
}