package TPractico6.EJ5;

public class Buffer {
    private int capacidad;
    private int usados;

    public Buffer(int cap) {
        capacidad = cap;
        usados = 0;
    }

    public synchronized void producir() throws InterruptedException {
        while (capacidad == usados) {
            System.out.println("No hay espacio");
            this.wait();
        }
        Thread.sleep(500);
        usados++;
        System.out.println(
                "El productor: " + Thread.currentThread().getName() + " puso un producto, ACTUALES: " + usados);
        this.notifyAll();
    }

    public synchronized void consumir() throws InterruptedException {
        while (usados == 0) {
            System.out.println("No hay productos");
            this.wait();
        }
        Thread.sleep(500);
        usados--;
        System.out.println(
                "El consumidor: " + Thread.currentThread().getName() + " saco un producto, ACTUALES: " + usados);
        this.notifyAll();
    }
}
