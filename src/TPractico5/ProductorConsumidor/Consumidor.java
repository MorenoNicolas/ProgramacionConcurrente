package TPractico5.ProductorConsumidor;

public class Consumidor extends Thread {
    private Buffer recursoC;
    private int cantidad;

    public Consumidor(Buffer nuevo, int cant){
        recursoC = nuevo;
        cantidad = cant;
    }
    public void run(){
        while(true){
            try {
                recursoC.sacar(cantidad);
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

}
