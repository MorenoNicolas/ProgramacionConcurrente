package TPractico3;

public class Ejercicio2 {
    public static void main(String[] args) {
        Thread hilo1 = new Criatura("Criatura Oscura");
        Thread hilo2 = new Criatura("Sanador");
        hilo2.start();
        hilo1.start();
    }
}
class Energia{
    private int orbes;

    public Energia(){
        orbes =10;
    }
    public int getOrbes(){
        return orbes;
    }
    public void drenar(){
        orbes = orbes - 3;
    }
    public void revitalizar(){
        orbes = orbes + 3;
    }
}
class Criatura extends Thread{
    private Energia energy;

    public Criatura(String name){
        super(name);
        energy = new Energia();
    }

    public synchronized void run(){
        while(energy.getOrbes()>0&&energy.getOrbes()<=30){
            if(Thread.currentThread().getName()=="Criatura Oscura"){
                energy.drenar();
                System.out.println("Se dreno 3 puntos de energia");
                System.out.println("El personaje tiene: "+energy.getOrbes()+" puntos de energia");
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {}

            }else{
                energy.revitalizar();
                System.out.println("Se revitalizo 3 puntos de energia");
                System.out.println("El personaje tiene: "+energy.getOrbes()+" puntos de energia");
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {}   
            }
        }
        if(energy.getOrbes()<=0){
            System.out.println("NO HAY ENERGIA");

        }else if (energy.getOrbes()>=30){
            System.out.println("ENERGIA MAXIMA");
        }
    }
}
