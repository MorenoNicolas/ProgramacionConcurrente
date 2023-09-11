package TPractico3;

public class Ejercicio5 {
    public static void main(String[] args) {
        Auto hilo1 = new Auto(" 299 acb", 0, 15);
        Auto hilo2 = new Auto(" 123 aaa", 0, 15);
        Auto hilo3 = new Auto(" 567 acd", 0, 15);
        Auto hilo4 = new Auto(" 289 xxx", 0, 15);
        Auto hilo5 = new Auto(" 244 zzz", 0, 15);
        Surtidor surti = new Surtidor();

        hilo1.run(surti);
        hilo2.run(surti);
        hilo3.run(surti);
        hilo4.run(surti);
        hilo5.run(surti);
    }
}
class Auto extends Thread {
    private String patente;
    private String modelo;
    private String marca;
    private int km;
    private int kmHastaReserva;

    public Auto(String unaPat, int unosKm, int rese){
        this.patente=unaPat;
        this.km= unosKm;
        this.kmHastaReserva = rese;
    }
    public synchronized void run(Surtidor sur){
        int i=0;
        while( i<=kmHastaReserva&&sur.getCapacidad()>1){
            i += (int) (Math.random() * 10) + 1;
            sur.cargarAuto();
            this.km+=i;
            try {
                System.out.println("El auto "+this.getPatente()+" cargo combustible");
                System.out.println("Al surtidor le quedan: "+sur.getCapacidad()+" litros");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    public String getPatente(){
        return patente;
    }
}
class Surtidor{
    private int capacidad;

    public Surtidor(){
        capacidad = 30;
    }
    public int getCapacidad(){
        return capacidad;
    }
    public void cargarAuto(){
        this.capacidad -= 15;
    }
    //CONSULTAR SOBRE EL SYNCRONIZED EN RUN O OTROS METODOS
}
