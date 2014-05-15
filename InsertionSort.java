package main;

import java.util.*;

public class InsertionSort extends Sort {
	public <T extends Comparable<T>> void sortList(ArrayList<T> arr) {

		int i, j;
		T newValue;

		for (i = 1; i < arr.size(); i++) {
			newValue = arr.get(i);
			j = i;
			while (j > 0 && arr.get(j - 1).compareTo(newValue) > 0) {
				arr.set(j, arr.get(j - 1));
				j--;
			}
			arr.set(j, newValue);
		}
	}
}
