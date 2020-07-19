package skilltesting.positivethinking.fr;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public final class Partition<T> extends AbstractList<List<T>> {

	private final List<T> list;
	private final int chunkSize;

	public Partition(List<T> list, int chunkSize) {
		this.list = new ArrayList<>(list);
		this.chunkSize = chunkSize;
	}

	/**
	 * function that takes a "list" parameter and a "size" parameter and returns a
	 * list of sublists, where each sublist has maximum "size" elements.
	 * 
	 * @param list : list of elements to split
	 * @param size : size of sublist
	 * @return a list of listSize / chunkSize sub-elements
	 */
	public static <T> Partition<T> ofSize(List<T> list, int size) {
		return new Partition<>(list, size);
	}

	@Override
	public List<T> get(int index) {
		int start = index * chunkSize;
		int end = Math.min(start + chunkSize, list.size());

		if (start > end) {
			throw new IndexOutOfBoundsException(
					"Index " + index + " is out of the list range <0," + (size() - 1) + ">");
		}

		return new ArrayList<>(list.subList(start, end));
	}

	@Override
	public int size() {
		return (int) Math.ceil((double) list.size() / (double) chunkSize);
	}
}