package TPractico4.EJ4;

public class Cliente extends Thread {
    
    private RecursoCompartido rc;
    @Override
    public void run(){
        for(int i=0; i<=5;i++){
            try {
                //System.out.println(Thread.currentThread().getName());
                rc.imprimir();
            } catch (InterruptedException e) {
            }
        }
    }
    public Cliente(RecursoCompartido rc){
        this.rc = rc;
    }
}
