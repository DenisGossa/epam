package comparator;
import java.util.Comparator;
import typography.Publication;

public class SortByPagesComparator implements Comparator<Publication> {	
	@Override
	public int compare(Publication obj1, Publication obj2) {
		return Integer.compare(obj1.getPages(), obj2.getPages());
	}	
}
