import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Generator generator = new Generator();
        ArrayList<Patient> pacientes=generator.preparePatients();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Desea usar la implementacion del Libro (1) o del JCF(2)?: ");
        String number = myObj.nextLine();
        if(number.equals("2"))
        {
            System.out.println("Usando la Implementacion del JCF:");
            PQ pq= new PQ();
            pq.sort(pacientes);
            pq.attend();

        }

        else
        {
            System.out.println("Usando la implementacion del libro: ");
        }
        

    }
}