package comparator;
import java.util.Comparator;
import typography.Publication;

public class SortByYearComparator implements Comparator<Publication> {
	@Override
	public int compare(Publication o1, Publication o2) {
		return Integer.compare(o1.getYear(), o2.getYear());
	}
}
