package TPractico8.EjercicioPasteleria;

import java.util.Random;

public class Horno extends Thread{
    Random random = new Random();

    private PasteleriaRC paste;
    private char tipoHorno;

    public Horno(PasteleriaRC p, char tipo){
        paste = p;
        tipoHorno = tipo;
    }

    public void run(){
        try {
            while(true){
                switch (tipoHorno) {
                    case 'A': paste.hornearPastel(5); break;
                    case 'B':paste.hornearPastel(10);break;
                    case 'C':paste.hornearPastel(25);break;
                    default: System.out.println("No existe ese tipo de Horno");break;
                }
                //Thread.sleep(random.nextInt(2000, 3500));
            }            
        } catch (Exception e) {
        }
    }
}
