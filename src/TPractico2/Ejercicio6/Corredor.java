package TPractico2.Ejercicio6;

public class Corredor extends Thread {
    private int distancia;

    public Corredor (String st, int dis){
        super(st);
        distancia=dis;
    }

    public void run(){
        int pasos;
        for (pasos = 0; pasos <= 100;){
            pasos += (int) (Math.random() * 10) + 1;
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
            }
        }
        distancia =  pasos;
        System.out.println("Corredor: "+this.getName() +" llego a los 100 pasos");
    }
    public int getDistancia(){
        return distancia;
    }
}
