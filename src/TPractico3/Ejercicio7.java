package TPractico3;

import java.util.Random;

public class Ejercicio7 {
    public static void main(String[] args) {
        Impresora hilo = new Impresora();
        Thread hiloA = new Thread(hilo, "Hilo A");
        Thread hiloB = new Thread(hilo, "Hilo B");
        Thread hiloC = new Thread(hilo, "Hilo C");
        hiloA.start();
        hiloB.start();
        hiloC.start();
    }
}

class Impresora implements Runnable {
    private static char caracter = 'A';
    

    @Override
    public synchronized void run() {
        try {
            while (true) {
                Random Random = new Random();
                if (caracter == 'A') {
                    int cantidad = Random.nextInt(5) + 1, j;
                    for (j = 1; j <= cantidad; j++) {
                        System.out.print("A");
                        Thread.sleep(500);
                    }
                    caracter = 'B';
                } else if (caracter == 'B') {
                    int cantidad = Random.nextInt(5) + 1, j;
                    for (j = 1; j <= cantidad; j++) {
                        System.out.print("B");
                        Thread.sleep(500);
                    }
                    caracter = 'C';
                } else {
                    int cantidad = Random.nextInt(5) + 1, j;
                    for (j = 1; j <= cantidad; j++) {
                        System.out.print("C");
                        Thread.sleep(500);
                    }
                    caracter = 'A';
                }
            }
        } catch (Exception ex) {//cambiar el run por una parte mas
        }
    }
}
