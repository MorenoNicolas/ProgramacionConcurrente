package TPractico6.EJ4;

public class Buffer {
    private int capacidad;
    private int usados;

    public Buffer(int cap){
        capacidad = cap;
        usados = 0;
    }

    public synchronized void producir() throws InterruptedException{
        while(capacidad==usados){
            System.out.println("No hay espacio");
            this.wait();
        }
        Thread.sleep(1000);
        usados++;
        System.out.println("Se coloco un producto: "+usados);
        this.notifyAll();
    }

    public synchronized void consumir() throws InterruptedException{
        while(usados==0){
            System.out.println("No hay productos");
            this.wait();
        }
        //Thread.sleep(1000);
        usados--;
        System.out.println("Se saco un producto: "+usados);
        this.notifyAll();
    }
}
