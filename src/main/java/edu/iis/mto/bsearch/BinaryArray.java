package edu.iis.mto.bsearch;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryArray {
    public static boolean isSorted(int[] array) {
        return IntStream.range(0, array.length - 1).allMatch(i -> array[i] <= array[i + 1]);
    }

    public static boolean hasDuplicates(int[] array) {
        return array.length!=Arrays.stream(array).distinct().count();
    }
}