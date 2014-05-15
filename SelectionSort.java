package main;

import java.util.*;

public class SelectionSort extends Sort {
	public <T extends Comparable<T>> void sortList(ArrayList<T> arr) {
		int i, k, posmax;
		for (i = arr.size() - 1; i > 0; i--) {
			posmax = 0;
			for (k = 1; k <= i; k++) {
				T next = arr.get(k);
				if (next.compareTo(arr.get(posmax)) > 0)
					posmax = k;
			}
			swap(arr, i, posmax);
		}
	}

	public <T extends Comparable<T>> void swap(ArrayList<T> arr, int pos,
			int posmax) {
		T temp = arr.get(pos);
		arr.set(pos, arr.get(posmax));
		arr.set(posmax, temp);
	}
}
