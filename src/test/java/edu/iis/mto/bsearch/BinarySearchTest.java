package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    private final int[] singleSeq = {16};
    private final int[] seq = {10, 34, 123, 767};

    private SearchResult searchResult;

    @BeforeEach
    void setUp() {
    }


    @Test
    void keyInSingleSeq() {
        int key = 16;
        searchResult = BinarySearch.search(key, singleSeq);
        assertTrue(searchResult.isFound());
    }

    @Test
    void keyNotInSingleSeq() {
        int key = 786;
        searchResult = BinarySearch.search(key, singleSeq);
        assertFalse(searchResult.isFound());
    }

    @Test
    void keyAsFirstElement() {
        int key = 10;
        searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(1, searchResult.getPosition());
    }

    @Test
    void keyAsLastElement() {
        int key = 767;
        searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq.length, searchResult.getPosition());
    }

    @Test
    void keyInSeq() {
        int key = 123;
        searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
    }

    @Test
    void keyNotInSeq() {
        int key = 99;
        searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
    }

    @Test
    void keyAsMidElementInEvenLengthSeq() {
        final int[] bigSeq = {4, 67, 88, 517, 900, 8912};
        int key = 88;
        searchResult = BinarySearch.search(key, bigSeq);
        assertTrue(searchResult.isFound());
        assertEquals(bigSeq.length / 2, searchResult.getPosition());
    }

    @Test
    void keyAsMidElementInOddLengthSeq() {
        final int[] bigSeq = {456, 670, 10293, 19900, 63412, 123456, 1000000};
        int key = 19900;
        searchResult = BinarySearch.search(key, bigSeq);
        assertTrue(searchResult.isFound());
        assertEquals((bigSeq.length / 2) + 1, searchResult.getPosition());
    }

    @Test
    void checkEmptySeq() {
        int key = -99;
        int[] seq = {};
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> BinarySearch.search(key, seq));
    }

    @Test
    void isArraySorted() {
        int[] seq = {32, 45, 89, 120, 500, 9213, 1, 2, -8};
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> BinarySearch.search(-1, seq));
    }

    @Test
    void hasDuplicates() {
        int[] seq = {111, 111, 900, 1230, 12300, 12300};
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> BinarySearch.search(-1, seq));
    }

}
