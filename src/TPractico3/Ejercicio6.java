package TPractico3;

import java.util.Random;

public class Ejercicio6 {
    public static void main(String[] args) {
        int cantCeldas = 50000;
        int[] arreglo = new int[cantCeldas];
        int cantHilos=5;
        HiloSumador[] arrHilos = new HiloSumador[cantHilos];
        Random random = new Random();
        //carga de los valores en el arreglo normal
        for(int j =0;j<cantCeldas; j++){
            arreglo[j] = random.nextInt(10);
        }
        //carga de arreglo de hilos sumadores
        for(int i = 0; i<cantHilos;i++){
            arrHilos[i]= new HiloSumador(cantHilos, arreglo, (cantCeldas*i)/cantHilos, (cantCeldas*i+1)/cantHilos );
            arrHilos[i].start();
        }
        try {
            Thread.sleep(4000);
            System.out.println("El valor final es: "+ arrHilos[0].getValorF());
        } catch (InterruptedException e) {
        }
    }
}
class HiloSumador extends Thread{
    private int cantidad;
    private int[] arreglo;
    private int comienzo;
    private int fin;
    private int valorParcial;
    private static int valorFinal;

    public HiloSumador(int cant, int arr[], int comienzo, int fin){
        this.cantidad = cant;
        this.arreglo = arr;
        this.comienzo = comienzo;
        this.fin=fin;
    }
    @Override
    public void run(){
        for(int i=comienzo;i<fin;i++){
            valorParcial += arreglo[i];
        }
        this.acumular(valorParcial);
    }
    public int getValorF(){
                System.out.println(valorParcial);
        return valorFinal;
    }
    public synchronized void acumular(int valor){
        HiloSumador.valorFinal += valor;
    }
}
