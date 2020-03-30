import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Generator {

    ArrayList<Patient> preparePatients() throws IOException {
        ArrayList<Patient> patientList= new ArrayList<>();
        Vector<String> patientVector=new Vector<>();
        BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"));
        String line;
        while ((line = br.readLine()) != null) 
        {
            Patient patient= new Patient();
            String[] data = line.split("\\,");
            patient.setName(data[0]);
            patient.setSickness(data[1]);
            patient.setPriority(data[2]);

            patientList.add(patient);
        }

        return patientList;
    }

    Vector<Patient> preparePatientsVector() throws IOException {
        Vector<Patient> patientVector=new Vector<>();
        BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"));
        String line;
        while ((line = br.readLine()) != null) 
        {
            Patient patient= new Patient();
            String[] data = line.split("\\,");
            patient.setName(data[0]);
            patient.setSickness(data[1]);
            patient.setPriority(data[2]);
            patientVector.add(patient);
        }

        return patientVector;
    }
}
