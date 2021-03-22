package edu.iis.mto.bsearch;

import java.util.HashSet;
import java.util.Set;

public class ArrayChecker {

    public static boolean isSorted(int[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i] > inputArray[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasDuplicates(int[] inputArray){
        Set<Integer> set = new HashSet<>();
        for (int j : inputArray) set.add(j);
        if(set.size() == inputArray.length)
            return false;
        return true;
    }


}
