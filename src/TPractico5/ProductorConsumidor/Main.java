package TPractico5.ProductorConsumidor;

public class Main {
    public static void main(String[] args) {
        Buffer bufer = new Buffer();
        Consumidor cons = new Consumidor(bufer, 2);
        Productor pro = new Productor(bufer, 1);
        Productor pro2 = new Productor(bufer, 3);
        Productor pro3 = new Productor(bufer, 1);

        cons.start();
        pro.start();
        pro2.start();
    }
}
