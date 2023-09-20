package TPractico4.EJ4;

public class RecursoCompartido {
    
    private Impresora impresora1;
    private Impresora impresora2;
    private Impresora impresora3;

    public RecursoCompartido(){
        impresora1 = new Impresora(1, true);
        impresora2 = new Impresora(1, true);
        impresora3 = new Impresora(1, true);
    }
    public void imprimir(){
        
    }
}
