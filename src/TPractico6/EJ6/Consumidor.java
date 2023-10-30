package TPractico6.EJ6;

public class Consumidor extends Thread {
    private int numero;
    private Buffer buffer;

    public Consumidor(int numero, Buffer buffer) {
        this.numero = numero;
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                buffer.consumir(numero);
            } catch (Exception ex) {

            }
        }
    }
}
