package TPractico8.EjercicioCanibales;

public class Main {
    public static void main(String[] args) {
        Olla olla = new Olla(5);
        Cocinero cocinero = new Cocinero(olla);
        Canibales[] arrCan = new Canibales[30];

        for(int i=0; i<arrCan.length; i++){
            arrCan[i] = new Canibales(olla);
            arrCan[i].start();
        }
        cocinero.start();
    }
}
