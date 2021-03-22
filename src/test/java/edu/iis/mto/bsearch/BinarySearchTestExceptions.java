package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTestExceptions {

    @Test
    void checkExceptions_zeroLengthArray() {
        int key = 1;
        int[] seq = new int[0];

        Assertions.assertThrows(IllegalArgumentException.class, () -> {BinarySearch.search(key, seq);});
    }

    @Test
    void checkExceptions_hasDuplicates() {
        int key = 1;
        int[] seq = {1, 2, 2, 3, 4};

        Assertions.assertThrows(IllegalArgumentException.class, () -> {BinarySearch.search(key, seq);});
    }

    @Test
    void checkExceptions_notSorted() {
        int key = 1;
        int[] seq = {5, 4, 3, 2, 1};

        Assertions.assertThrows(IllegalArgumentException.class, () -> {BinarySearch.search(key, seq);});
    }

}
