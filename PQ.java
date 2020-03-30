import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PQ {

    PriorityQueue<Patient> lista;

    PriorityQueue<Patient> sort(ArrayList<Patient> pacientes){
        PriorityQueue<Patient> orderedPatients=new PriorityQueue<>(pacientes.size(), new Comparables());
        for(int i=0;i<pacientes.size();i++)
        {
            System.out.println("Entra al hospital: "+((pacientes.get(i)).name()));
            orderedPatients.add(pacientes.get(i));
        }
        this.lista=orderedPatients;
        return orderedPatients;
    }

    void attend()
    {
        int listSize=lista.size();
        for(int i=0;i<listSize;i++)
        {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Presione Enter para Atender al Siguiente");
            String userName = myObj.nextLine();
            System.out.println("Atendiendo: "+lista.peek().name()+" con enfermedad: "+lista.peek().sickness()+ " y prioridad: "+lista.peek().priority());
            lista.poll();
        }
        System.out.println("ha atendido a todos los pacientes! Que Dios los bendiga. Pero sobre todo, que Dios bendiga Guatemala.");
    }
}