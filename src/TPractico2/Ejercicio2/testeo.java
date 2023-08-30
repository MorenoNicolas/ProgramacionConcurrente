package TPractico2.Ejercicio2;

public class testeo {

}

class TesteoHilos {
    public static void main(String[] args) {
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        try {
            miHilo.join();
        } catch (Exception ex) {
        }
        System.out.println("En el main");
    }
}

class MiEjecucion extends Thread {

    public void run() {
        ir();
    }
    public void ir() {
        hacerMas();
    }
    public void hacerMas() {
        System.out.println("En la pila");
    }
}
