package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    public void ifElementExists_oneElementArray_true () {
        int[] array={5};
        SearchResult res = BinarySearch.search(5,array);
        assertEquals(res.isFound(),true);
    }
    @Test
    public void ifElementExists_oneElementArray_false() {
        int[] array={15};
        SearchResult res = BinarySearch.search(5,array);
        assertEquals(res.isFound(),false);
    }
    @Test
    public void searchForFirstElement_manyElementArray() {
        int[] array={2,4,6,8,10,12};
        SearchResult res = BinarySearch.search(2,array);
        assertEquals(res.getPosition(),1);
    }
    @Test
    public void searchForLastElement_manyElementArray() {
        int[] array={3,6,9,12,15,18};
        SearchResult res = BinarySearch.search(18,array);
        assertEquals(res.getPosition(),6);
    }
    @Test
    public void searchForMiddleElement_manyElementArray() {
        int[] array={4,8,12,16,20};
        SearchResult res = BinarySearch.search(12,array);
        assertEquals(res.getPosition(),3);
    }
    @Test
    public void searchForElement_noSuchElement() {
        int[] array={3,5,18,24,85,148};
        SearchResult res = BinarySearch.search(2,array);
        assertEquals(res.isFound(),false);
    }

}
