import java.io.IOException;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    @org.junit.jupiter.api.Test
    void add() throws IOException {
        Generator generator = new Generator();
        Vector<Patient> pacientes=generator.preparePatientsVector();
        VectorHeap<Patient> VH= new VectorHeap<>();
        for(int i=0;i<pacientes.size();i++)
        {
            VH.add(pacientes.get(i));
        }
        assertEquals(VH.getFirst().name(),"Maria Ramirez");
    }

    @org.junit.jupiter.api.Test
    void remove() throws IOException {
        Generator generator = new Generator();
        Vector<Patient> pacientes=generator.preparePatientsVector();
        VectorHeap<Patient> VH= new VectorHeap<>();
        for(int i=0;i<pacientes.size();i++) {
            VH.add(pacientes.get(i));
        }
        assertEquals(VH.remove().name(),"Maria Ramirez");
    }
}