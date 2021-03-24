package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    private static final int NOT_FOUND = -1;

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void searchValue_True_IsInOneElementSequence() {
        int[] sequence = {20};
        SearchResult bs = BinarySearch.search(sequence[0], sequence);
        assertTrue(bs.isFound());
        assertEquals(0, bs.getPosition());
    }

    @Test
    void searchValue_True_IsNotInOneElementSequence() {
        int[] sequence = {15};
        SearchResult bs = BinarySearch.search(4, sequence);
        assertFalse(bs.isFound());
        assertEquals(NOT_FOUND, bs.getPosition());

    }

    @Test
    void searchValue_True_IsFirstInSequence() {
        int[] sequence = {-4, 0, 6, 34, 46, 67, 89, 689, 1234};
        SearchResult bs = BinarySearch.search(sequence[0], sequence);
        assertTrue(bs.isFound());
        assertEquals(0, bs.getPosition());
    }

    @Test
    void searchValue_True_IsLastInSequence() {
        int[] sequence = {-4, 0, 6, 9, 34, 46, 689, 777, 1200};
        SearchResult bs = BinarySearch.search(sequence[sequence.length-1], sequence);
        assertTrue(bs.isFound());
        assertEquals(sequence.length-1, bs.getPosition());
    }

    @Test
    void searchValue_True_IsMiddleInSequence() {
        int[] sequence = {-4, 0, 6, 34, 46, 689, 1234};
        SearchResult bs = BinarySearch.search(sequence[sequence.length/2], sequence);
        assertTrue(bs.isFound());
        assertEquals(sequence.length/2, bs.getPosition());
    }

    @Test
    void searchValue_False_IsNotInSequence() {
        int[] sequence = {-4, 0, 1, 2, 3, 4, 5, 6, 34, 46, 689, 1234};
        SearchResult bs = BinarySearch.search(9, sequence);
        assertFalse(bs.isFound());
        assertEquals(NOT_FOUND, bs.getPosition());
    }

    @Test
    void searchValue_True_IsInSequence_WithOddNumberOfElements() {
        int[] sequence = {-110000, -234, -34, -6, 0, 1, 4, 9, 12, 45, 67, 456, 999, 12345, 999999};
        for(int i=0; i<sequence.length; i++){
            SearchResult bs = BinarySearch.search(sequence[i], sequence);
            assertTrue(bs.isFound());
            assertEquals(i, bs.getPosition());
        }
    }

    @Test
    void searchValue_True_IsInSequence_WithEvenNumberOfElements() {
        int[] sequence = {-110000, -234, -34, -6, 0, 1, 2, 3, 4, 9, 12, 45, 67, 87, 98, 99, 456, 999, 12345, 999999};
        for(int i=0; i<sequence.length; i++){
            SearchResult bs = BinarySearch.search(sequence[i], sequence);
            assertTrue(bs.isFound());
            assertEquals(i, bs.getPosition());
        }
    }

    @Test
    void searchValue_ThrowsException_IsEmptySequence() {
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(1, new int[]{}));
    }

    @Test
    void searchValue_ThrowsException_IsNoSequence() {
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(1, null));
    }

    @Test
    void searchValue_ThrowsException_IsDisorderedSequence() {
        int[] seq1 = {-4, 0, 6, 34, 46, 689, 56};
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(1, seq1));

        int[] seq2 = {5, 5, 5, 5, 4};
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(1, seq2));

        int[] seq3 = {0, 1, 0, 1};
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(1, seq3));
    }

}
