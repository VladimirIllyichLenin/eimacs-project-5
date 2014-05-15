package main;


import java.util.*;

public class SortingTest
{

    private static final Random RANDOM = new Random();

    public static ArrayList<Integer> randomArrayList(int n) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int x = 0; x < n; x ++) {
            list.add(RANDOM.nextInt(100));
        }
        
        return list;
    }
    
    public static ArrayList<ArrayList<Integer>> arrayListOfArrayList(int m, int n) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        for(int x = 0; x < m; x++) { 
            list.add(randomArrayList(n));
        }
        
        return list;
    }
    
    public static void main(String[] args) {
       
        @SuppressWarnings("unused")
		TestingInterface myInterface = new TestingInterface();

    }
}