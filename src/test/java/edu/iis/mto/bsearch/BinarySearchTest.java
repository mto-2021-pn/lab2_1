package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void SequenceLengthEqualsOneAndElementInSequence() {
        int[] seq = {5};
        int key = 5;

        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void SequenceLengthEqualsOneAndElementNotInSequence() {
        int[] seq = {5};
        int key = 1;
        int NOT_FOUND = -1;

        SearchResult result = BinarySearch.search(key, seq);
        assertFalse(result.isFound());
        assertEquals(NOT_FOUND, result.getPosition());
    }

    @Test
    void SequenceLengthMoreThanOneAndElementFirstInSequence() {
        int[] seq = {1, 2, 3};
        int key = seq[0];
        int FIRST = 0;

        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(FIRST, result.getPosition());
    }

    @Test
    void SequenceLengthMoreThanOneAndElementLastInSequence() {
        int[] seq = {1, 2, 3};
        int LAST = seq.length - 1;
        int key = seq[LAST];

        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(LAST, result.getPosition());
    }

    @Test
    void SequenceLengthMoreThanOneAndElementCenterOfSequence() {
        int[] seq = {1, 2, 3};
        int CENTER = seq.length / 2;
        int key = seq[CENTER];

        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(CENTER, result.getPosition());
    }

    @Test
    void SequenceLengthMoreThanOneAndElementNotInSequence() {
        int[] seq = {1, 2, 3};
        int key = 4;
        int NOT_FOUND = -1;

        SearchResult result = BinarySearch.search(key, seq);
        assertFalse(result.isFound());
        assertEquals(NOT_FOUND, result.getPosition());
    }

}
