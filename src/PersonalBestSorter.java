import java.util.Comparator;

public class PersonalBestSorter implements Comparator<KonkurrenceSvømmer> {


    @Override
    public int compare(KonkurrenceSvømmer o1, KonkurrenceSvømmer o2) {
        return Integer.parseInt(o1.getPersonalBest().replace(":","")) - Integer.parseInt(o2.getPersonalBest().replace(":",""));

    }
}
