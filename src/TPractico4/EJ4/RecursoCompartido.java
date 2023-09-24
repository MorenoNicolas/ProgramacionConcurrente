package TPractico4.EJ4;

public class RecursoCompartido {
    
    private int cant = 3;
    private Impresora[] impresora = new Impresora[cant];
    

    public RecursoCompartido(){
        for(int i =0; i<cant ;i++){
            impresora[i] = new Impresora(1, true);
        }
    }
    public void imprimir() throws InterruptedException{
        int i =0;
        boolean esperando = true;
        while(esperando){
            if(impresora[i].getDisponibilidad()==true){
                //System.out.println(Thread.currentThread().getName());
                impresora[i].noDisponible();
                impresora[i].acquire();
                System.out.println("La impresora: "+i+" esta imprimiendo...");
                Thread.sleep(2000);
                System.out.println("La impresora: "+i+" termino");
                impresora[i].release();
                esperando = false;
                impresora[i].liberarDisponible();
            }
            i++;
        }
    }
}
