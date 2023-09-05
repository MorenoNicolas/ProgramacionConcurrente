package TPractico2.TpoPrueba;

class Dato {

    private int valor;
    synchronized void contar() {
        valor = ++valor;
    }
    int obtenerValor() {
        return valor;
    }
}
class RunnableCdor implements Runnable {

    Dato unContador;
public RunnableCdor (Dato elCdor){
unContador = elCdor;
}

    public void run() {
        for (int x = 0; x < 10000; ++x)
            unContador.contar();
    }
}

 class Contador {

    public static void main(String[] args) throws InterruptedException {

        final Dato unContador = new Dato();

        RunnableCdor unRunCdor = new RunnableCdor(unContador);

        Thread h1 = new Thread(unRunCdor);
        Thread h2 = new Thread(unRunCdor);
        h1.start();
        h2.start();
        h1.join();
        h2.join();
        System.out.println("en main-" + unContador.obtenerValor());
    }
}