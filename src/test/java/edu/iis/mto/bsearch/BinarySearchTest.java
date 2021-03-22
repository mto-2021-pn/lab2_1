package edu.iis.mto.bsearch;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {
    public static int[] tab1;
    public static int[] tab2;
    public static int[] tab3;
    public static BinarySearch binarySearch;
    public static SearchResult searchResult;

    @BeforeEach
    void setUp() throws Exception {
        tab1 = new int[]{3, 4, 5, 6, 7, 8, 9};
        tab2 = new int[]{3, 4, 5, 5, 5, 8, 9};
        tab3 = new int[]{3, 6, 5, 5, 7, 8, 9};
        binarySearch = new BinarySearch();
    }

    @Test
    void testLenOneIn() {
        int[] tab = {5};
        searchResult = binarySearch.search(5, tab);
        assertTrue(searchResult.isFound());
        assertEquals(5, tab[searchResult.getPosition()]);
    }

    @Test
    void testLenOneNotIn() {
        int[] tab = {4};
        searchResult = binarySearch.search(5, tab);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void testLenMoreThanOneNotIn() {
        searchResult = binarySearch.search(1111, tab1);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void testLenMoreThanOneFirstPlace() {
        searchResult = binarySearch.search(3, tab1);
        assertTrue(searchResult.isFound());
        assertEquals(3, tab1[searchResult.getPosition()]);
    }

    @Test
    void testLenMoreThanOneLastPlace() {
        searchResult = binarySearch.search(9, tab1);
        assertTrue(searchResult.isFound());
        assertEquals(9, tab1[searchResult.getPosition()]);
    }

    @Test
    void testLenMoreThanOneCenterPlace() {
        searchResult = binarySearch.search(6, tab1);
        assertTrue(searchResult.isFound());
        assertEquals(6, tab1[searchResult.getPosition()]);
    }

    @Test
    void testLenZero() {
        int[] tab = new int[0];
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BinarySearch.search(3, tab);
        });
    }

    @Test
    void testDuplicates() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BinarySearch.search(3, tab2);
        });
    }

    @Test
    void testNoSorted() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BinarySearch.search(3, tab3);
        });
    }

}
