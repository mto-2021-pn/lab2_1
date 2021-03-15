package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void test() {
        fail("Not yet implemented");
    }

    @Test
    void shouldFindElementInOneElementArray() {
        int key = 1;
        int[] seq = {1};
        int expectedPosition = 0;
        boolean expectedFound = true;

        SearchResult result = BinarySearch.search(key, seq);

        assertEquals(expectedPosition, result.getPosition());
        assertEquals(expectedFound, result.isFound());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void shouldNotFindElementInOneElementArray() {
        int key = 1;
        int[] seq = {2};
        int expectedPosition = -1;
        boolean expectedFound = false;

        SearchResult result = BinarySearch.search(key, seq);

        assertEquals(expectedPosition, result.getPosition());
        assertEquals(expectedFound, result.isFound());
    }

    @Test
    void shouldFindElementWhichIsTheFirstElementInMultiElementArray() {
        int key = 1;
        int[] seq = {1, 2};
        int expectedPosition = 0;
        boolean expectedFound = true;

        SearchResult result = BinarySearch.search(key, seq);

        assertEquals(expectedPosition, result.getPosition());
        assertEquals(expectedFound, result.isFound());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void shouldFindElementWhichIsTheLastElementInMultiElementArray() {
        int key = 2;
        int[] seq = {1, 2};
        int expectedPosition = 1;
        boolean expectedFound = true;

        SearchResult result = BinarySearch.search(key, seq);

        assertEquals(expectedPosition, result.getPosition());
        assertEquals(expectedFound, result.isFound());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void shouldFindElementWhichIsInTheMiddleElementInMultiElementArray() {
        int key = 2;
        int[] seq = {1, 2, 3};
        int expectedPosition = 1;
        boolean expectedFound = true;

        SearchResult result = BinarySearch.search(key, seq);

        assertEquals(expectedPosition, result.getPosition());
        assertEquals(expectedFound, result.isFound());
        assertEquals(key, seq[result.getPosition()]);
    }
}
