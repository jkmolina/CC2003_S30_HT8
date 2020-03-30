import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        Generator generator = new Generator();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Desea usar la implementacion del Libro (1) o del JCF(2)?: ");
        String number = myObj.nextLine();
        if(number.equals("2"))
        {
            System.out.println("Usando la Implementacion del JCF:");
            ArrayList<Patient> pacientes=generator.preparePatients();
            PQ pq= new PQ();
            pq.sort(pacientes);
            pq.attend();

        }

        else
        {
            System.out.println("Usando la implementacion del libro: ");
            Vector<Patient> pacientes=generator.preparePatientsVector();
            VectorHeap<Patient> VH= new VectorHeap<>();
            for(int i=0;i<pacientes.size();i++)
            {
                VH.add(pacientes.get(i));
            }
            for(int i=pacientes.size()-1;i>=0;i--)
            {
            Scanner myObj1 = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Presione Enter para Atender al Siguiente");
            String userName = myObj1.nextLine();
            System.out.println("Atendiendo: "+VH.getFirst().name()+" con enfermedad: "+VH.getFirst().sickness()+ " y prioridad: "+VH.getFirst().priority());
            VH.remove();
            }
            System.out.println("ha atendido a todos los pacientes! Que Dios los bendiga. Pero sobre todo, que Dios bendiga Guatemala.");

        }
        

    }
}