package TPractico8.EjercicioObservatorio;

public class Main {
    public static void main(String[] args) {
        Observatorio observatorio = new Observatorio(15);
        Visitante[] arrVisi = new Visitante[50];
        for(int i =0; i<arrVisi.length;i++){
            arrVisi[i] = new Visitante(observatorio);
            arrVisi[i].start();
        }
        Mantenimiento[] arrMan =  new Mantenimiento[10];
        for(int i =0;i<arrMan.length;i++){
            arrMan[i] = new Mantenimiento(observatorio);
            arrMan[i].start();
        }
        Investigador invi = new Investigador(observatorio);
        invi.start();
    }
}
