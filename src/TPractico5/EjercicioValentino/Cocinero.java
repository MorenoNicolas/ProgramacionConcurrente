package TPractico5.EjercicioValentino;



/**
 *
 * @author giuli
 */
public class Cocinero extends Thread {
     private Confiteria conf;

    public Cocinero(Confiteria unaConf) {
        conf = unaConf;
    }
      public void run() {
    while (true) {
            try {
                conf.hacerRecetas(); //se bloquea hasta que un empleado le de el ok de preparar
                            } catch (InterruptedException ex) {
                           
            }
            System.out.println("Haciendo el pollito");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
               
            }
            System.out.println("listo el polloo");
            conf.entregarComida();
        }
}
}