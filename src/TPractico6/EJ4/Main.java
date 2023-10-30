package TPractico6.EJ4;

public class Main {
    public static void main(String[] args) {
        Buffer buf = new Buffer(5);
        Consumidor cons = new Consumidor(buf);
        Productor pro = new Productor(buf);

        cons.start();
        pro.start();
    }
}
