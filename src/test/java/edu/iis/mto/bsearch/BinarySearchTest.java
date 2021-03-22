package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    public void findExistOneElement_InOneElementArray_firstPosition()
    {
        int[] someArray = {1};
        SearchResult a = BinarySearch.search(1,someArray);
        assertEquals(true,a.isFound());
        assertEquals(1,a.getPosition());
    }
    @Test
    public void findDontExistOneElement_InOneElementArray()
    {
        int[] someArray = {1};
        SearchResult a = BinarySearch.search(2,someArray);
        assertEquals(false,a.isFound());
        assertEquals(-1,a.getPosition());
    }
    @Test
    public void findExistOneElement_InManyElementArray_firstPosition()
    {
        int[] someArray = {3, 4, 5, 9, 12, 22, 32, 65, 78};
        SearchResult a = BinarySearch.search(3,someArray);
        assertEquals(1,a.getPosition());
        assertEquals(true,a.isFound());
    }
    @Test
    public void findExistOneElement_InManyElementArray_LastPosition()
    {
        int[] someArray = {3, 4, 5, 9, 12, 22, 32, 65, 78};
        SearchResult a = BinarySearch.search(78,someArray);
        assertEquals(a.getPosition(),someArray.length);
        assertEquals(true,a.isFound());
    }
    @Test
    public void findExistOneElement_InManyElementArray_CenterPosition()
    {
        int[] someArray = {3, 4, 5, 9, 12, 22, 32, 65, 78};
        SearchResult a = BinarySearch.search(12,someArray);
        assertEquals(5,a.getPosition());
        assertEquals(true,a.isFound());
    }
    @Test
    public void findDontExistOneElement_InManyElementArray()
    {
        int[] someArray = {3, 4, 5, 9, 12, 22, 32, 65, 78};
        SearchResult a = BinarySearch.search(-22,someArray);
        assertEquals(-1,a.getPosition());
        assertEquals(false,a.isFound());
    }
    @Test
    public void TakeAsArgumentArrayNULL()
    {
        int[] someArray = null;
        try{
            SearchResult a = BinarySearch.search(-22,someArray);
        }catch (NullPointerException e)
        {
            //ignore
        }
    }
    @Test
    public void TakeAsArgumentArray_EmptyArray()
    {
        int[] someArray = {};
        SearchResult a = BinarySearch.search(-22,someArray);
        assertEquals(-1,a.getPosition());
        assertEquals(false,a.isFound());
    }
}
