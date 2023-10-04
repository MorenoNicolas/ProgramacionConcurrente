package TPractico4.EJ4;

public class Principal {
    public static void main(String[] args) {
        RecursoCompartido recu = new RecursoCompartido();
        Cliente cliente1 = new Cliente(recu);
        Cliente cliente2 = new Cliente(recu);
        Cliente cliente3 = new Cliente(recu);

        cliente1.start();
        cliente2.start();
        cliente3.start();
    }
}
