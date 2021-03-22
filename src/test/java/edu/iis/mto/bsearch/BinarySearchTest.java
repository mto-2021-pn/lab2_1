package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void shouldFindElementInSingleElementSequence() {
        // given
        int key = 12;
        int[] sequence = {12};

        boolean expectedFindStatus = true;
        int expectedPosition = 0;

        // when
        SearchResult searchResult = BinarySearch.search(key, sequence);

        // then
        assertEquals(expectedFindStatus, searchResult.isFound());
        assertEquals(expectedPosition, searchResult.getPosition());
        assertEquals(key, sequence[searchResult.getPosition()]);
    }

    @Test
    void shouldNotFindElementInSingleElementSequence() {
        // given
        int key = 12;
        int[] sequence = {2};

        boolean expectedFindStatus = false;
        int expectedPosition = -1;

        // when
        SearchResult searchResult = BinarySearch.search(key, sequence);

        // then
        assertEquals(expectedFindStatus, searchResult.isFound());
        assertEquals(expectedPosition, searchResult.getPosition());
    }

    @Test
    void shouldFindFirstElementInMultiElementSequence() {
        // given
        int key = 1;
        int[] sequence = {1, 3, 7, 12, 35, 60};

        boolean expectedFindStatus = true;
        int expectedPosition = 0;

        // when
        SearchResult searchResult = BinarySearch.search(key, sequence);

        // then
        assertEquals(expectedFindStatus, searchResult.isFound());
        assertEquals(expectedPosition, searchResult.getPosition());
        assertEquals(key, sequence[searchResult.getPosition()]);
    }

    @Test
    void shouldFindLastElementInMultiElementSequence() {
        // given
        int key = 60;
        int[] sequence = {1, 3, 7, 12, 35, 60};

        boolean expectedFindStatus = true;
        int expectedPosition = 5;

        // when
        SearchResult searchResult = BinarySearch.search(key, sequence);

        // then
        assertEquals(expectedFindStatus, searchResult.isFound());
        assertEquals(expectedPosition, searchResult.getPosition());
        assertEquals(key, sequence[searchResult.getPosition()]);
    }

    @Test
    void shouldFindMiddleElementInMultiElementSequence() {
        // given
        int key = 12;
        int[] sequence = {1, 3, 7, 12, 35, 60, 80};

        boolean expectedFindStatus = true;
        int expectedPosition = 3;

        // when
        SearchResult searchResult = BinarySearch.search(key, sequence);

        // then
        assertEquals(expectedFindStatus, searchResult.isFound());
        assertEquals(expectedPosition, searchResult.getPosition());
        assertEquals(key, sequence[searchResult.getPosition()]);
    }

    @Test
    void shouldNotFindElementInMultiElementSequence() {
        // given
        int key = 32;
        int[] sequence = {1, 3, 7, 12, 35, 60, 80};

        boolean expectedFindStatus = false;
        int expectedPosition = -1;

        // when
        SearchResult searchResult = BinarySearch.search(key, sequence);

        // then
        assertEquals(expectedFindStatus, searchResult.isFound());
        assertEquals(expectedPosition, searchResult.getPosition());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSequenceIsEmpty() {
        // given
        int key = 32;
        int[] sequence = {};

        // when
        try {
            SearchResult searchResult = BinarySearch.search(key, sequence);

        // then
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException ignored) { }
    }

}
