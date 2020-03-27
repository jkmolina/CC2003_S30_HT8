import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Generator {

    ArrayList<Patient> preparePatients() throws IOException {
        ArrayList<Patient> patientList= new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"));
        String line;
        while ((line = br.readLine()) != null) 
        {
            Patient patient= new Patient();
            String[] data = line.split("\\,");
            System.out.println(data[1]);
            patient.setName(data[0]);
            patient.setSickness(data[1]);
            patient.setPriority(data[2]);

            patientList.add(patient);
        }

        return patientList;
    }
}
