package TPractico8.EjercicioObservatorio;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Observatorio {
    private int capacidadMax;
    private int investigadorTrabajando;
    private boolean mantenimientoTrabajando;
    private boolean discapacitado;

    //locks
    private Lock mutex = new ReentrantLock();
    
    public Observatorio(int num){
        this.capacidadMax = num;
    }



}
