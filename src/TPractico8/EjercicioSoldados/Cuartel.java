package TPractico8.EjercicioSoldados;

import java.util.concurrent.Semaphore;

public class Cuartel {
    private Semaphore mostradorAlmuerzo;
    private Semaphore mostradorPostre;
    private Semaphore abridor;
    private Semaphore espacioDisponible;

    public Cuartel(){
        mostradorAlmuerzo = new Semaphore(5);
        mostradorPostre = new Semaphore(3);
        abridor = new Semaphore(10);
    }

    public void ocupaMostradorAlmuerzo() throws InterruptedException{
        mostradorAlmuerzo.acquire();
        Thread.sleep(1000);
        mostradorAlmuerzo.release();
    }

    public void usaAbridor() throws InterruptedException{
        abridor.acquire();
        Thread.sleep(2000);
        abridor.release();
    }

    public void ocuparMostradorPostre() throws InterruptedException{
        mostradorPostre.acquire();
        Thread.sleep(500);
        mostradorPostre.release();
    }
}
