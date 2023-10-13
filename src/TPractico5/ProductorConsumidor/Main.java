package TPractico5.ProductorConsumidor;

public class Main {
    public static void main(String[] args) {
        Buffer bufer = new Buffer();
        Consumidor cons = new Consumidor(bufer, 2);
        Productor pro = new Productor(bufer, 2);
        Productor pro2 = new Productor(bufer, 2);

        cons.start();
        pro.start();
        pro2.start();
    }
}
