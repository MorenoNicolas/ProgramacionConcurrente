package TPractico8.EjercicioObservatorio;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Observatorio {
    private int ocupacion;
    private int capacidadMax;
    private int investigadorEsperando;
    private int mantenimientoTrabajando;
    private int visVisitando;
    //private boolean discapacitado;
    //locks
    private Lock mutex = new ReentrantLock();
    Condition investigador = mutex.newCondition();
    Condition mantenimiento = mutex.newCondition();
    Condition visitante = mutex.newCondition();
    
    public Observatorio(int num){
        this.capacidadMax = num;
    }

    public void entrarVisitante() throws InterruptedException{
        try {
            mutex.lock();
        while(ocupacion>=capacidadMax&&mantenimientoTrabajando>0&&investigadorEsperando!=0){
            visitante.await();
        }
        ocupacion++;
        visVisitando++;
        System.out.println(Thread.currentThread().getName()+" entro visitante comun");
        
        } catch (Exception e) {
        }finally{mutex.unlock();}
    }

    public void entrarMantenimiento(){
        try {
            mutex.lock();
            while(ocupacion>=capacidadMax&&investigadorEsperando!=0&&visVisitando>0){
                mantenimiento.await();
            }
            ocupacion++;
            mantenimientoTrabajando++;
            System.out.println(Thread.currentThread().getName()+" entro mantenimiento"); 
        } catch (Exception e) {
        }finally{mutex.unlock();}
    }

    public void entrarInvestigador(){
        try {
            mutex.lock();
            investigadorEsperando++;
            while(ocupacion>=1&&visVisitando>0&&mantenimientoTrabajando>0){
                investigador.await();
            }
            ocupacion++;
            investigadorEsperando--;
            System.out.println(Thread.currentThread().getName()+" entro un investigador"); 
        } catch (Exception e) {
        }finally{mutex.unlock();}
    }
    public void salirInvestigador(){
        mutex.lock();
        try {
            ocupacion--;
            System.out.println(Thread.currentThread().getName()+" el investigador salio");
            if(investigadorEsperando>0){
                investigador.signalAll();
            }else{
                mantenimiento.signalAll();
                visitante.signalAll();
            }
        } catch (Exception e) {
        }finally{mutex.unlock();}
    }
    public void salirMantenimiento(){
        mutex.lock();
        try {
            ocupacion--;
            System.out.println(Thread.currentThread().getName()+" un conserje salio");
            mantenimientoTrabajando--;
            if(mantenimientoTrabajando>0){
                mantenimiento.signalAll();
            }else{
                investigador.signalAll();
                visitante.signalAll();
            }
        } catch (Exception e) {
        }finally{mutex.unlock();}
    }
    public void salirVisitante(){
        mutex.lock();
        try {
            ocupacion--;
            System.out.println(Thread.currentThread().getName()+" un visitante salio");
            visVisitando--;
            if(visVisitando==0&&mantenimientoTrabajando==0){
                investigador.signalAll();
            }else{
                mantenimiento.signalAll();
                visitante.signalAll();
            }
        } catch (Exception e) {
        }finally{mutex.unlock();}
    }
}
            // ocupacion--;
            // if(ocupacion==0){
            //     investigador.signalAll();
            // }else if(mantenimientoTrabajando>=0){
            //     mantenimiento.signalAll();

            // }else{
            //     visitante.signalAll();
            // }