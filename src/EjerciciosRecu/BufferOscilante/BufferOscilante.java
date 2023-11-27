package EjerciciosRecu.BufferOscilante;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class BufferOscilante {
    private Queue<Object> cola1 = new LinkedList<>();
    private Queue<Object> cola2 = new LinkedList<>();
    private Semaphore extraer = new Semaphore(1);
    private Semaphore insertar = new Semaphore(1);
    private Semaphore oscilar = new Semaphore(1);
    private Semaphore hayElem = new Semaphore(0);
    private boolean oscilaBoolean = true;//si es true inserta en cola1
    
    public void insertar(Object elem) throws InterruptedException{
        insertar.acquire();
        if(oscilaBoolean){
            cola1.add(elem);
            if(cola2.isEmpty()){
                oscilar();
            }
        }else{
            cola2.add(elem);
            if(cola1.isEmpty()){
                oscilar();
            }
        }
        hayElem.release();
        insertar.release();
    }
    public Object extraer() throws InterruptedException{
        hayElem.acquire();
        extraer.acquire();
        Object retorno=null;
        if(oscilaBoolean){
            if(!cola2.isEmpty()){
                retorno = cola2.remove();
            }else{
                retorno = cola1.remove();
                oscilar();
            }
        }else{
            if(!cola1.isEmpty()){
                retorno = cola1.remove();
            }else{
                retorno = cola2.remove();
                oscilar();
            }
        }
        extraer.release();
        return retorno;
    }

    public void oscilar() throws InterruptedException{
        oscilar.acquire();
        oscilaBoolean = !oscilaBoolean;
        oscilar.release();
    }
}
