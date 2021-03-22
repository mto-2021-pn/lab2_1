package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    public void element_is_in_array()
    {
        int[] testArray={1};
        SearchResult a = BinarySearch.search(1, testArray);
        assertEquals(true, a.isFound());
        assertEquals(1, a.getPosition());
    }

    @Test
    public void element_is_not_in_array()
    {
        int[] testArray={2};
        SearchResult a = BinarySearch.search(1, testArray);
        assertEquals(false, a.isFound());
        assertEquals(-1, a.getPosition());
    }

    @Test
    public void element_is_first_in_array()
    {
        int[] testArray={1,3,4,7,8,10};
        SearchResult a = BinarySearch.search(1, testArray);
        assertEquals(true, a.isFound());
        assertEquals(1, a.getPosition());
    }

    @Test
    public void element_is_last_in_array()
    {
        int[] testArray={1,3,4,7,8,10};
        SearchResult a = BinarySearch.search(10, testArray);
        assertEquals(true, a.isFound());
        assertEquals(a.getPosition(), testArray.length);
    }

    @Test
    public void element_is_center_in_array()
    {
        int[] testArray={1,3,4,7,8,10,21};
        SearchResult a = BinarySearch.search(7, testArray);
        assertEquals(true, a.isFound());
        assertEquals(4, a.getPosition());
    }

    @Test
    public void element_is_not_in_multi_array()
    {
        int[] testArray={1,3,4,7,8,10,21};
        SearchResult a = BinarySearch.search(99, testArray);
        assertEquals(false, a.isFound());
        assertEquals(-1, a.getPosition());
    }


}
