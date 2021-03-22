package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BinarySearchTest {

    int NOT_FOUND = -1;
    int FIRST = 0;

    @Test
    public void sequenceLengthEqualsOneAndElementInSequence() {
        int[] seq = {5};
        int key = 5;

        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    public void sequenceLengthEqualsOneAndElementNotInSequence() {
        int[] seq = {5};
        int key = 1;

        SearchResult result = BinarySearch.search(key, seq);
        assertFalse(result.isFound());
        assertEquals(NOT_FOUND, result.getPosition());
    }

    @Test
    public void sequenceLengthMoreThanOneAndElementFirstInSequence() {
        int[] seq = {1, 2, 3};
        int key = seq[0];

        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(FIRST, result.getPosition());
    }

    @Test
    public void sequenceLengthMoreThanOneAndElementLastInSequence() {
        int[] seq = {1, 2, 3};
        int LAST = seq.length - 1;
        int key = seq[LAST];

        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(LAST, result.getPosition());
    }

    @Test
    public void sequenceLengthMoreThanOneAndOddAndElementCenterOfSequence() {
        int[] seq = {1, 2, 3};
        int CENTER = seq.length / 2;
        int key = seq[CENTER];

        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(CENTER, result.getPosition());
    }

    @Test
    public void sequenceLengthMoreThanOneAndEvenAndElementCenterOfSequence() {
        int[] seq = {1, 2};
        int CENTER = seq.length / 2;
        int key = seq[CENTER];

        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(CENTER, result.getPosition());
    }

    @Test
    public void sequenceLengthMoreThanOneAndElementNotInSequence() {
        int[] seq = {1, 2, 3};
        int key = 4;

        SearchResult result = BinarySearch.search(key, seq);
        assertFalse(result.isFound());
        assertEquals(NOT_FOUND, result.getPosition());
    }

    @Test
    public void IllegalArgumentExceptionThrown() {
        int[] seq = {};
        int key = 2;

        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(key, seq));
    }

}
