package TPractico4.BarberoDormilon;

/**
 *
 * @author Giuli Vicentino
 */
public class Cliente extends Thread{
    
    private Asiento sillon;
    private int numero;
    
    public Cliente(Asiento sillon, int numero){
        this.sillon = sillon;
        this.numero = numero;
    }
    
    public void run(){
        try {
            sillon.ocuparLugar();
        } catch (InterruptedException ex) {
        }
        System.out.println("Bro "+numero+" toma el asiento");
        sillon.despertarBarbero();
        System.out.println("Bro "+numero+" despierta al barbero");
        System.out.println("Ya me desperté paaaaaaaaaa");
        try {
            sillon.salir();
        } catch (InterruptedException ex) {
        }
        sillon.liberarLugar();
    }
}
