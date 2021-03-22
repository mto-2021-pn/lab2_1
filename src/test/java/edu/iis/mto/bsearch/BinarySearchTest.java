package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    private static final int NOT_FOUND = -1;

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void test() {

        int[] seq = {20};

        //test1
        SearchResult bs = BinarySearch.search(20, seq);
        assertTrue(bs.isFound());
        assertEquals(0, bs.getPosition());

        //test2
        bs = BinarySearch.search(4, seq);
        assertFalse(bs.isFound());
        assertEquals(NOT_FOUND, bs.getPosition());

        int[] seq2 = {-4, 0, 6, 34, 46, 689, 1234};

        //test3
        bs = BinarySearch.search(-4, seq2);
        assertTrue(bs.isFound());
        assertEquals(0, bs.getPosition());

        //test4
        bs = BinarySearch.search(1234, seq2);
        assertTrue(bs.isFound());
        assertEquals(seq2.length-1, bs.getPosition());

        //test5
        bs = BinarySearch.search(34, seq2);
        assertTrue(bs.isFound());
        assertEquals(seq2.length/2, bs.getPosition());

        //test6
        bs = BinarySearch.search(1, seq2);
        assertFalse(bs.isFound());
        assertEquals(NOT_FOUND, bs.getPosition());

        int[] seq3 = {-110000, -234, -34, -6, 0, 1, 4, 9, 12, 45, 67, 456, 999, 12345, 999999};

        //test6
        for(int i=0; i<seq2.length; i++){
            bs = BinarySearch.search(seq3[i], seq3);
            assertTrue(bs.isFound());
            assertEquals(i, bs.getPosition());
        }

        //test7
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(1, new int[]{}));

        //test8
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(1, null));

        //test9
        int[] seq4 = {-4, 0, 6, 34, 46, 689, 56};
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(1, seq4));

        //test10
        int[] seq5 = {5, 5, 5, 5, 4};
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(1, seq5));

        //test10
        int[] seq6 = {0, 1, 0, 1};
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(1, seq6));
    }

}
