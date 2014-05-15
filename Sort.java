package main;

import java.util.*;

public abstract class Sort {
	public abstract <T extends Comparable<T>> void sortList(ArrayList<T> arr);

}
