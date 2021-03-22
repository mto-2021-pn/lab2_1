package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    public void isInTheSequence() {
        int[] array = {1, 2, 3, 4};
        int key = 3;
        SearchResult search = BinarySearch.search(key, array);
        assertEquals(key, search.getPosition());
        assertTrue(search.isFound());
    }

    @Test
    public void isNotInTheSequence() {
        int[] array = {1, 2, 3, 4};
        int key = 6;
        SearchResult search = BinarySearch.search(key, array);
        assertEquals(-1, search.getPosition());
        assertFalse(search.isFound());
    }

    @Test
    public void isTheFirstElementInTheSequence() {
        int[] array = {1, 2, 3, 4};
        int key = 1;
        SearchResult search = BinarySearch.search(key, array);
        assertEquals(1, search.getPosition());
        assertTrue(search.isFound());
    }

    @Test
    public void isTheLastElementInTheSequence() {
        int[] array = {1, 2, 3, 4};
        int key = 2;
        SearchResult search = BinarySearch.search(key, array);
        assertEquals(key, search.getPosition());
        assertTrue(search.isFound());
    }

    @Test
    public void isTheMiddleElementInTheOddSequence() {
        int[] array = {1, 2, 3, 4, 5};
        int key = 3;
        SearchResult search = BinarySearch.search(key, array);
        assertEquals(3, search.getPosition());
        assertTrue(search.isFound());
    }

    @Test
    public void isTheMiddleElementInTheEvenSequence() {
        int[] array = {1, 2, 3, 4};
        int key = 2;
        SearchResult search = BinarySearch.search(key, array);
        assertEquals(2, search.getPosition());
        assertTrue(search.isFound());
    }

    @Test
    public void isTheSequenceEmpty()
    {
        int[] array = {};
        int key = -3;
        SearchResult search = BinarySearch.search(key,array);
        assertEquals(-1,search.getPosition());
        assertFalse(search.isFound());
    }
}
