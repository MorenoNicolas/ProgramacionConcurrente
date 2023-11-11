package TPractico8.EjercicioHemoterapia;

public class CentroHemoterapia {
    private int revistasTotal = 3;
    private int camTotales = 1;
    private int sillaTotales = 6;
    private int revDisponibles = revistasTotal;
    private int camDisponibles = camTotales;
    private int sillaDisponibles = sillaTotales;

    public synchronized void donarSangre() throws InterruptedException {
        while (camDisponibles <= 0) {
            while (sillaDisponibles <= 0) {
                this.wait();
            }
            sillaDisponibles--;
            System.out.println("El donador: "+ Thread.currentThread().getName()+" se sento en una silla");
            while (revDisponibles <= 0) {
                this.wait();
            }
            revDisponibles--;
            System.out.println("El donador: "+ Thread.currentThread().getName()+" agarro una revista");
            this.wait();
        }
        if(sillaDisponibles<12&&revDisponibles<9){
            revDisponibles++;
            sillaDisponibles++;
        }
        System.out.println("El donador: "+ Thread.currentThread().getName()+" se acosto en una camilla");
        camDisponibles--;
        this.notifyAll();
    }   

    public synchronized void salirCentro() throws InterruptedException {
        System.out.println("---- El donador: "+ Thread.currentThread().getName()+" se fue del centro de hemoterapia ----");
        camDisponibles++;
        this.notifyAll();
    }
}
