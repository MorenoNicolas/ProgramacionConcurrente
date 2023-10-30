package TPractico6.EJ6;

public class Productor extends Thread {
    private int numero;
    private Buffer buffer;

    public Productor(int numero, Buffer buffer) {
        this.numero = numero;
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                buffer.producir(numero);
            } catch (Exception ex) {

            }
        }
    }
}
