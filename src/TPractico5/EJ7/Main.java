package TPractico5.EJ7;

public class Main {
    public static void main(String[] args) {
        int cantidad = 10;
        ParqueAcuatico parquesito = new ParqueAcuatico(4);
        Encargado Marcelo = new Encargado(parquesito);
        Marcelo.start();

        Visitante[] arrVisitantes = new Visitante[cantidad];
        for(int i=0; i<cantidad;i++){
            arrVisitantes[i] = new Visitante(parquesito);
            arrVisitantes[i].start();
        }
        
    }
}
