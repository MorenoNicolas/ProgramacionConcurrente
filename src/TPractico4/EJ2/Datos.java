package TPractico4.EJ2;

import java.util.concurrent.Semaphore;

public class Datos {
    private static int dato;
    private Semaphore mutex;
    private Datos siguiente;

    public Datos(int nro, int per){
        dato = nro;
        mutex = new Semaphore(per);
    }
    public int getDato(){
        return dato;
    }
    public void setDato(Datos n){
        siguiente = n;
    }
    public void haceAlgo() throws InterruptedException {
        mutex.acquire();
        System.out.println("Hace algo:  "+dato);
        this.terminaAlgo();
    }
    public void terminaAlgo(){
        siguiente.permiteHacerAlgo();
    }
    public void permiteHacerAlgo(){
        mutex.release();
    }
}
class ProcesoI extends Thread{

    private Datos unDato;
    public ProcesoI(Datos d){
        unDato = d;
    }

    @Override
    public void run() {
        for(int i = 1; i<100;i++){
            try {
                unDato.haceAlgo();
            } catch (InterruptedException e) {
            }
        }    
    }
}
