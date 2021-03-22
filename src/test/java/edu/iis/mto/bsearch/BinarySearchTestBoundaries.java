package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTestBoundaries {

    @Test
    void checkBoundaries_forIntMAXValue() {
        int key = Integer.MAX_VALUE;
        int[] seq = {1, 2, 3, 4, key};

        SearchResult searchResult = BinarySearch.search(key, seq);

        Assertions.assertTrue(searchResult.isFound() && seq[searchResult.getPosition()] == key);
    }

    @Test
    void checkBoundaries_forIntMINValue() {
        int key = Integer.MIN_VALUE;
        int[] seq = {key, 1, 2, 3, 4};

        SearchResult searchResult = BinarySearch.search(key, seq);

        Assertions.assertTrue(searchResult.isFound() && seq[searchResult.getPosition()] == key);
    }

}
