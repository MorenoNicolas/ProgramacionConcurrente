package TPractico5.EJ3;

import java.util.concurrent.Semaphore;

public class Comedor {
    private Semaphore semGatos;
    private Semaphore semPerros;
    private Semaphore mutex;
    private int espacio = 2;
    private int cantidad = 0;
    private boolean orden;

    public Comedor(int n, boolean orden) {
        semGatos = new Semaphore(n);
        semPerros = new Semaphore(n);
        mutex = new Semaphore(1);
        this.orden = orden;
    }
    public void entrarAnimal(){
        if(orden){
            

        }
    }
}
