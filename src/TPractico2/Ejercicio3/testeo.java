package TPractico2.Ejercicio3;

public class testeo {   
}
class ThreadEjemplo extends Thread {

    public ThreadEjemplo(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
        }
        System.out.println("Termina thread " + getName());
    }

    public static void main(String[] args) { 
        ThreadEjemplo eje =  new ThreadEjemplo("Maria Jose");
        eje.start();
        try{
            eje.join();
        }catch(Exception ex){
        }
        new ThreadEjemplo("Jose Maria").start();
        System.out.println("Termina thread main");
    }
}
