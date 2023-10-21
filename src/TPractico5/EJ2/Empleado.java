package TPractico5.EJ2;

public class Empleado extends Thread{
    private Confiteria conf;
    private int tipo;

    public Empleado(Confiteria conf, int tipo){
        this.conf = conf;
        this.tipo = tipo;
    }
    public void run(){
        try {
            conf.sentarse();
            switch(tipo){
                case 1: 
                conf.pedirBebida();
                conf.empezarABeber();
                ;break; 
                case 2:
                conf.pedirComida();
                conf.empezarAComer();
                ;break;
                case 3:
                conf.pedirBebida();
                conf.empezarABeber();
                conf.pedirComida();
                conf.empezarAComer();
                ;break;
            }
            conf.levantarse();
        } catch (Exception e) {
        }
    }
}

