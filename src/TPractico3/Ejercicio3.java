package TPractico3;

public class Ejercicio3 {  
    public static void main(String[] args) {
        Tienda tiendita = new Tienda();
        int numHamsters = 3;

        for (int i = 1; i <= numHamsters; i++) {
            Thread hamster = new Hamster(i, tiendita);
            hamster.start();
        }
    }
}
class Tienda {
        
    public synchronized void comer(int numeroHamster) {
        System.out.println("Hamster " + numeroHamster + " esta comiendo.");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            
        }
    }

    public synchronized void correr(int numeroHamster) {
        System.out.println("Hamster " + numeroHamster + " corriendo.");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            
        }
    }

    public synchronized void descansar(int numeroHamster) {
        System.out.println("Hamster " + numeroHamster + " esta descansando.");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            
        }
    }
}

class Hamster extends Thread {
    private int numero;
    private Tienda tiendita;

    public Hamster(int numero, Tienda tiendita) {
        this.numero = numero;
        this.tiendita = tiendita;
    }

    public void run() {
        while (true) {
            tiendita.comer(numero);
            tiendita.correr(numero);
            tiendita.descansar(numero);
        }
    }
}
