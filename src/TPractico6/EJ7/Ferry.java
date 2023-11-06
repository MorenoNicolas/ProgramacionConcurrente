package TPractico6.EJ7;

public class Ferry {
    private int capPasajeros;
    private int capAutos;
    private int pasajeroUsados;
    private int autosUsados;
    private int capacidadTotal;
    private int usadosTotal = pasajeroUsados + autosUsados;
    private boolean viajando = false;
    private boolean permiteBajar = false;

    public Ferry(int pas, int aut) {
        capPasajeros = pas;
        capAutos = aut;
        capacidadTotal = capAutos + capPasajeros;
    }

    public synchronized void subirFerry(boolean tipo) throws InterruptedException {
        while (pasajeroUsados == capPasajeros && autosUsados == capAutos && !permiteBajar) {
            this.wait();
        }

        if (tipo) {
            pasajeroUsados++;
            System.out.println("Se subio el pasajero: " + Thread.currentThread().getName());
        } else {
            autosUsados++;
            System.out.println("Se subio el auto: " + Thread.currentThread().getName());
        }

        if (pasajeroUsados == capPasajeros && autosUsados == capAutos) {
            viajando = true;
        }
        this.notifyAll();
    }

    public synchronized void bajarFerry(boolean tipo) throws InterruptedException {
        while (!permiteBajar) {
            this.wait();
        }
        if(tipo){
            pasajeroUsados--;
            System.out.println("Se bajo el pasajero: "+ Thread.currentThread().getName());
        }else{
            autosUsados--;
            System.out.println("Se bajo el auto: "+ Thread.currentThread().getName());
        }
        this.notifyAll();
        if(usadosTotal==0){
            permiteBajar=false;
        }

    }

    public synchronized void empezarFerry() throws InterruptedException {
        while (!viajando) {
            this.wait();
        }
        System.out.println("--------EL FERRY COMENZO EL VIAJE--------");
    }

    public synchronized void terminarFerry() {
        viajando = false;
        System.out.println("--------EL FERRY TERMINO EL VIAJE--------");
        permiteBajar = true;
    }

}
