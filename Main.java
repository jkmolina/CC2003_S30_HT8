import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        Generator generator = new Generator();
        ArrayList<Patient> pacientes=generator.preparePatients();
        PriorityQueue<Patient> orderedPatients=new PriorityQueue<>(pacientes.size(), new Comparable());
        for(int i=0;i<pacientes.size();i++)
        {
            System.out.println("adding: "+pacientes.get(i).name());
            orderedPatients.add(pacientes.get(i));
        }
        System.out.println("wa");
        System.out.println(orderedPatients.peek().name());
        orderedPatients.remove();
        System.out.println(orderedPatients.peek().name());
    }
}