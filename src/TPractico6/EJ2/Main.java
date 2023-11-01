package TPractico6.EJ2;

public class Main {
    public static void main(String[] args) {
        
        Estudiante[] arrEst = new Estudiante[30];
        SalaDeEstudio salita = new SalaDeEstudio(0, 5);

        for(int i=0; i<arrEst.length;i++){
            arrEst[i]= new Estudiante(salita);
            arrEst[i].start();
        }
        
    }
}
