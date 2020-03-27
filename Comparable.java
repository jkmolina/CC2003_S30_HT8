import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Comparable implements Comparator<Patient>
{
    Map<String,Integer> map = getLetters();

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
        System.out.println(alphabet);
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
        System.out.println("LETTER IS: ."+letter+".");
        Set<String> keysList=map.keySet();
        Object[] letters=keysList.toArray();
        int index=0;

        for(int i=0;i<letters.length;i++)
        {
            System.out.println("Trying: "+letters[i]);
            if(String.valueOf(letters[i]).equals(letter))
            {
                System.out.println("got it! "+index+" "+letters[i]);
                index=i;
                break;
            }
        }
        System.out.println(index+"foku");
        return index;
    }

    Map<String, Integer> getMap(){
        System.out.println(this.map);
        return this.map;
    }

    @Override
    public int compare(Patient one, Patient two) {
        //System.out.println(returnIndex(one.priority())-returnIndex(two.priority()));
        return returnIndex(one.priority())-returnIndex(two.priority());
    }
}