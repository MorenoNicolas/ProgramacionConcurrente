package TPractico5.EJ1;

public class Main {
    public static void main(String[] args) {
        int cant= 10;
        Piscina pile = new Piscina();
        GestorPiscina gestor = new GestorPiscina(pile);
        Persona[] arrPer = new Persona[cant];
        
        
        for(int i = 0 ; i<cant; i++){
            arrPer[i] = new Persona(pile);
            arrPer[i].start();
        }
        gestor.start();
    }
}
