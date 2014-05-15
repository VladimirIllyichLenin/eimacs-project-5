package main;

import java.util.*;

public class MergeSort extends Sort {
	public <T extends Comparable<T>> void sortList(ArrayList<T> ilist) {

		ArrayList<T> a = mergeSort(ilist);
		ilist.clear();
		for (T x : a) {
			ilist.add(x);
		}

	}

	public <T extends Comparable<T>> ArrayList<T> mergeSort(ArrayList<T> ilist) {

		if (ilist.size() <= 1) {

			return ilist;
		} else {
			ArrayList<T> left = new ArrayList<T>();
			ArrayList<T> right = new ArrayList<T>();

			int middle = ilist.size() / 2; // int division
			for (int i = 0; i < middle; i++) {
				left.add(ilist.get(i));
			}
			for (int i = middle; i < ilist.size(); i++) {
				right.add(ilist.get(i));
			}

			return merge(mergeSort(left), mergeSort(right));
		}
	}

	private <T extends Comparable<T>> ArrayList<T> merge(ArrayList<T> a,
			ArrayList<T> b) {

		ArrayList<T> ret = new ArrayList<T>(); // return list
		int a_idx = 0, b_idx = 0; // counters of items left in respective lists

		while (a_idx + 1 <= a.size() || b_idx + 1 <= b.size()) {
			if (a_idx + 1 <= a.size() && b_idx + 1 <= b.size()) {
				if (a.get(a_idx).compareTo(b.get(b_idx)) <= 0.0) {
					ret.add(a.get(a_idx));
					a_idx++;
				} else {
					ret.add(b.get(b_idx));
					b_idx++;
				}
			} else if (a_idx + 1 <= a.size()) {
				ret.add(a.get(a_idx));
				a_idx++;
			} else if (b_idx + 1 <= b.size()) {
				ret.add(b.get(b_idx));
				b_idx++;
			}
		}

		return ret;
	}
}
