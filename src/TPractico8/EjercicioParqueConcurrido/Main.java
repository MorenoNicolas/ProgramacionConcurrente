package TPractico8.EjercicioParqueConcurrido;

public class Main {
    public static void main(String[] args) {
        ParqueCentral p = new ParqueCentral(5);
        
        Vecinos[] vecinosVip = new Vecinos[10];
        Vecinos[] vecinosNormal = new Vecinos[20];

        for (int j = 0; j < vecinosNormal.length; j++) {
            vecinosNormal[j] = new Vecinos(p, false);
            vecinosNormal[j].start();
        }
        for (int i = 0; i < vecinosVip.length; i++) {
            vecinosVip[i] = new Vecinos(p, true);
            vecinosVip[i].start();
        }

    }
}
