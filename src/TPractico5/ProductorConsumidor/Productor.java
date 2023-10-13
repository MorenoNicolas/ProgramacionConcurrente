package TPractico5.ProductorConsumidor;

public class Productor extends Thread{
    private Buffer recursoC = new Buffer();
    private int cantidad;

    public Productor(Buffer nuevo, int cant){
        recursoC = nuevo;
        cantidad = cant;
    }

    public void run(){
        while(true){
            try {
                recursoC.sacar(cantidad);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
