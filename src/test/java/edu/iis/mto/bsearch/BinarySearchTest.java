package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private final int NOT_FOUND = -1;
    private SearchResult searchResult;
    private int[] arrayOfOneElements = new int[]{1};
    private int[] arrayOfFiveElements = new int[]{1, 2, 3, 4, 5};
    private int[] arrayOfZeroElements = new int[]{};

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void shouldFindInOneElementSequence() {
        int expectedPosition = 1;

        searchResult = BinarySearch.search(1, arrayOfOneElements);
        assertTrue(searchResult.isFound());
        assertEquals(expectedPosition, searchResult.getPosition());
    }

    @Test
    void shouldNotFindInOneElementSequence() {
        searchResult = BinarySearch.search(2, arrayOfOneElements);
        assertFalse(searchResult.isFound());
        assertEquals(NOT_FOUND, searchResult.getPosition());
    }

    @Test
    void shouldBeTheFirstElement() {
        int expectedPosition = 1;

        searchResult = BinarySearch.search(1, arrayOfFiveElements);
        assertTrue(searchResult.isFound());
        assertEquals(expectedPosition, searchResult.getPosition());
    }

    @Test
    void shouldBeTheLastElement() {
        int expectedPosition = arrayOfFiveElements.length;

        searchResult = BinarySearch.search(5, arrayOfFiveElements);
        assertTrue(searchResult.isFound());
        assertEquals(expectedPosition, searchResult.getPosition());
    }

    @Test
    void shouldBeTheMiddleElement() {
        int expectedPosition = 3;

        searchResult = BinarySearch.search(3, arrayOfFiveElements);
        assertTrue(searchResult.isFound());
        assertEquals(expectedPosition, searchResult.getPosition());
    }

    @Test
    void shouldNotFindInSequenceOfSeveralNumbers() {
        searchResult = BinarySearch.search(10, arrayOfFiveElements);
        assertFalse(searchResult.isFound());
        assertEquals(NOT_FOUND, searchResult.getPosition());
    }

    @Test
    void passingNullShouldThrowAnException() {
        assertThrows(NullPointerException.class, () -> BinarySearch.search(10, null));
    }

    @Test
    void passingNegativeNumberShouldNotFind() {
        searchResult = BinarySearch.search(-1, arrayOfFiveElements);
        assertFalse(searchResult.isFound());
        assertEquals(NOT_FOUND, searchResult.getPosition());
    }

    @Test
    void passingEmptyTableShouldThrowAnException() {
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(10, arrayOfZeroElements));
    }
}
