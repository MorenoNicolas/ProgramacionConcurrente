package EjerciciosRecu.EjercicioEmbotelladora;

import java.util.concurrent.Semaphore;

public class PlantaEmbotelladora {
    private Semaphore mutex1 = new Semaphore(1);
    private Semaphore mutex2 = new Semaphore(1);
    private Semaphore empaquetadora = new Semaphore(0);
    private Semaphore transportador = new Semaphore(0);
    private Semaphore cajaLista = new Semaphore(0);
    private int cantBotellasAgua, cantBotellasVino, cantCajas;
    private boolean esAgua;

    public void embotellarAgua() throws InterruptedException{
        mutex1.acquire();
        System.out.println("El embotellador puso una botella de agua en la caja");
        cantBotellasAgua++;
        System.out.println("Hay");
        if(cantBotellasAgua==10){
            esAgua = true;
            System.out.println("Un embotellador pidio reponer la caja de agua");
            empaquetadora.release();
            cantBotellasAgua=0;
            cajaLista.acquire();
        }
        mutex1.release();
    }

    public void embotellarVino() throws InterruptedException { 
        mutex2.acquire();
        System.out.println("El embotellador puso una botella de vino en la caja");
        cantBotellasVino++;
        if(cantBotellasVino==10){
            esAgua = false;
            System.out.println("Un embotellador pidio reponer la caja de vino");
            empaquetadora.release();
            cantBotellasVino=0;
            cajaLista.acquire();
        }
        mutex2.release();
    }
    
    public void empaquetarCaja() throws InterruptedException{
        empaquetadora.acquire();
        if(esAgua){
            System.out.println("El empaquetador se llevo la caja de agua al almacen");
            cantCajas++;
        }else{
            System.out.println("El empaquetador se llevo la caja de vino al almacen");
            cantCajas++;
        }
        if(cantCajas==10){
            System.out.println("El almacen esta lleno se llevaron las cajas para su envio");
            transportador.release();
        }
    }
    public void reponerCaja(){
        System.out.println("El empaquetador repuso la caja");
        cajaLista.release();
    }

    public void transportarCajas() throws InterruptedException{
        transportador.acquire();
        System.out.println("El camion fue a repartir 10 cajas");
        cantCajas=0;
    }
}
