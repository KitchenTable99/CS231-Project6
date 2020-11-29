/**
 * String comparator based on length
 *
 * @author cbitting
 */

import java.util.Comparator;
  
public class AscendingString implements Comparator<String> {

	/**
	 * @param o1 the first string to compare
	 * @param o2 the second string to compare
	 * @return -1 if o1 is longer, 0 if the same, 1 if o1 shorter
	 */
	@Override
	public int compare(String o1, String o2) {
		if (o1.length() > o2.length()) {
			return 1;
		} else if (o1.length() == o2.length()) {
			return 0;
		} else {
			return -1;
		}
	}

}
