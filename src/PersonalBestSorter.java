import java.util.Arrays;
import java.util.Comparator;

public class PersonalBestSorter implements Comparator<KonkurrenceSvømmer> {


    @Override
    public int compare(KonkurrenceSvømmer o1, KonkurrenceSvømmer o2) {
        String [] i = (o1.getPersonalBest().split(":"));
        int j = Integer.parseInt(i[0])*60+Integer.parseInt(i[1]);
        String [] k = (o2.getPersonalBest().split(":"));
        int l = Integer.parseInt(k[0])*60+Integer.parseInt(k[1]);

        return j - l;


    }
}
