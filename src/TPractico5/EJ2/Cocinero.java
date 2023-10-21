package TPractico5.EJ2;

public class Cocinero extends Thread {
    private Confiteria conf;

    public Cocinero(Confiteria conf) {
        this.conf = conf;
    }

    public void run() {
        while (true) {
            try {
                conf.entregarComida();

                conf.indicarComer();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
