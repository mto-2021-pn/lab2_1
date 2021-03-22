package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.Buffer;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void oneElementSeqFoundTest() {
        int key = 10;
        int seq [] = {10};
        SearchResult search = BinarySearch.search(key, seq);
        assertTrue(search.isFound());
        assertEquals(search.getPosition(), 1);
    }

    @Test
    void oneElementSeqNotFoundTest(){
        int key = 100;
        int seq [] = {10};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
        assertEquals(searchResult.getPosition(), -1);

    }

    @Test
    void firstElementTest(){
        int key = 10;
        int seq [] = {10, 12, 89, 124, 400};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(searchResult.getPosition(), 1);
    }

    @Test
    void lastElementTest(){
        int key = 10;
        int seq [] = {-40, 3, 5, 8, 10};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(searchResult.getPosition(), 5);
    }

    @Test
    void centerElementTest(){
        int key = 10;
        int seq [] = {-4, 0, 1, 4, 5, 10, 14, 214, 500};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(searchResult.getPosition(), 6);
    }

    @Test
    void emptySeqTest(){
        int key = 10;
        int seq [] = {};
        try {
            SearchResult searchResult = BinarySearch.search(key, seq);
            fail("Expected exception");

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void longSeqNotFoundTest(){
        int key = 10;
        int seq [] = {-120, 30, 102, 405, 555, 1244, 9054, 10000, 12000, 4567890, 44444444};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
        assertEquals(searchResult.getPosition(), -1);

    }

    @Test
    void sequenceWithDuplicatesTest(){
        int key = 10;
        int seq [] = {102, 103, 400, 400};
        try {
            SearchResult searchResult = BinarySearch.search(key, seq);
            fail("Expected exception");

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void notSortedSequence(){
        int key = 10;
        int seq [] = {-2, 10, 0, 34};
        try {
            SearchResult searchResult = BinarySearch.search(key, seq);
            fail("Excepted exception");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}
