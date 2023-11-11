package TPractico8.EjercicioPasteleria;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class PasteleriaRC {
    
    private Queue<Integer> colaPasteles = new LinkedList<Integer>();
    private Semaphore caja = new Semaphore(1);
    private Semaphore empaquetadores;
    private Semaphore pasteles = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);
    private int cantPasteles;
    private int pesoCaja;
    private int pesoCajaActual;

    public PasteleriaRC(int numEmpaquetadores, int pesoCaja){
        this.empaquetadores = new Semaphore(numEmpaquetadores);
        this.pesoCaja = pesoCaja;
    }

    public void hornearPastel(int peso) throws InterruptedException{
        mutex.acquire();
        cantPasteles++;
        colaPasteles.add(peso);
        pasteles.release();
        mutex.release();
    }

    public void tomarPastel() throws InterruptedException{
        pasteles.acquire();
        caja.acquire();
        if(pesoPrimerPastel()+pesoCajaActual<=pesoCaja){
            pesoCajaActual += pesoPrimerPastel();
            colaPasteles.remove();
        }
    }

    public void reponerCaja(){

    }

    public void retirarCaja(){

    }

    public int pesoPrimerPastel(){
        return colaPasteles.peek();
    }
}
