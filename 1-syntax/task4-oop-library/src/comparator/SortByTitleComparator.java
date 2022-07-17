package comparator;
import java.util.Comparator;
import typography.Publication;

public class SortByTitleComparator implements Comparator<Publication> {
	@Override
	public int compare(Publication o1, Publication o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}
}
