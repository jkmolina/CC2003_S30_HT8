import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Patient implements Comparable<Patient>
{
    String name;
    String sickness;
    String priority;
    Map<String,Integer> map = getLetters();
    int index=returnIndex(priority);

    void setName(String name){
        this.name=name;
    }

    void setSickness(String sickness){
        this.sickness=sickness;
    }

    void setPriority(String priority){
        this.priority=priority;
    }


    String name()
    {
        return this.name;
    }
    String sickness()
    {
        return this.sickness;
    }
    String priority()
    {
        return this.priority;
    }

    //first we create a map to help us order patients by letters, since priority is given on letters and not in numbers
    Map<String,Integer> getLetters()
    {
        ArrayList<String> alphabet=new ArrayList<>();
        String alfabeto="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < alfabeto.length(); i++)
        {
            String c = String.valueOf(alfabeto.charAt(i));
            alphabet.add(c);
        }
        Map<String, Integer> indexes=new LinkedHashMap<>();


        for(int i=0;i<alphabet.size();i++)
        {
            indexes.put(alphabet.get(i),i);
        }
        return indexes;
    }

    //we make a function to return the index of the patient's priority
    int returnIndex(String letter)
    {
        Set<String> keysList=map.keySet();
        Object[] letters=keysList.toArray();
        int index=0;

        for(int i=0;i<letters.length;i++)
        {

            if(String.valueOf(letters[i]).equals(letter))
            {
                index=i;
                break;
            }
        }
        return index;
    }

    @Override
    public int compareTo(Patient arg0) {
        if(returnIndex(priority())<returnIndex(arg0.priority()))
        {
            return -1;
        }
        if(returnIndex(priority())>returnIndex(arg0.priority()))
        {
            return 1;
        }
        else{
            return 0;
        }
    }

}