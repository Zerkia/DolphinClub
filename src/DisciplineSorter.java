import java.util.Comparator;
/**
 * @Mads
 */
public class DisciplineSorter implements Comparator<KonkurrenceSvømmer> {

    @Override
    public int compare(KonkurrenceSvømmer o1, KonkurrenceSvømmer o2) {
        return o1.getDiscipline().compareTo(o2.getDiscipline());

    }
}
