package TPractico2.Ejercicio6;
import java.util.Scanner;
public class testeoCorredores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        Corredor[] lista = new Corredor[3];
        for (int i = 0; i<lista.length; i++){
            lista[i] = new Corredor(scanner.nextLine(), 0);
        }
        lista[0].start();
        lista[1].start();
        lista[2].start();
       
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }
        int mayor = 0;
        String n = "";
        for (int i = 0; i<lista.length-1; i++){
            if(lista[i].getDistancia()>lista[i+1].getDistancia()){
                mayor = lista[i].getDistancia();
                n = lista[i].getName();
            }else{
                mayor = lista[i+1].getDistancia();
                n = lista[i+1].getName();
            }
        }
        System.out.println("El corredor: "+ n + " recorrio el mayor recorrido, siendo: "+ mayor+ " pasos");
    }

}
