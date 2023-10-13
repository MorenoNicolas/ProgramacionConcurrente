package TPractico5.ProductorConsumidor;

public class Consumidor extends Thread {
    private Buffer recursoC = new Buffer();
    private int cantidad;

    public Consumidor(Buffer nuevo, int cant){
        recursoC = nuevo;
        cantidad = cant;
    }
    public void run(){
        while(true){
            try {
                recursoC.agrega(cantidad);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

}
