package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void searchForElem_singleElemSequence_elemFound(){
        int key = 1;
        int[] seq = {1};

        SearchResult sr = BinarySearch.search(key, seq);

        Assertions.assertTrue(sr.isFound() && seq[sr.getPosition()] == key);
    }

    @Test
    void searchForElem_singleElemSequence_elemNotFound(){
        int key = 2;
        int[] seq = {1};

        SearchResult sr = BinarySearch.search(key, seq);

        Assertions.assertTrue(!sr.isFound() && sr.getPosition() == -1);
    }

    @Test
    void searchForElem_multiElemSequence_elemFound_firstPos(){
        int key = 1;
        int[] seq = {1, 2, 3, 4, 5};

        SearchResult sr = BinarySearch.search(key, seq);

        Assertions.assertTrue(sr.isFound() && seq[sr.getPosition()] == key);
    }

    @Test
    void searchForElem_multiElemSequence_elemFound_lastPos(){
        int key = 5;
        int[] seq = {1, 2, 3, 4, 5};

        SearchResult sr = BinarySearch.search(key, seq);

        Assertions.assertTrue(sr.isFound() && seq[sr.getPosition()] == key);
    }

    @Test
    void searchForElem_multiElemSequence_elemFound_middlePos(){
        int key = 3;
        int[] seq = {1, 2, 3, 4, 5};

        SearchResult sr = BinarySearch.search(key, seq);

        Assertions.assertTrue(sr.isFound() && seq[sr.getPosition()] == key);
    }

    @Test
    void searchForElem_multiElemSequence_elemNotFound_elemBiggerThenMax(){
        int key = 6;
        int[] seq = {1, 2, 3, 4, 5};

        SearchResult sr = BinarySearch.search(key, seq);

        Assertions.assertTrue(!sr.isFound() && sr.getPosition() == -1);
    }

    @Test
    void searchForElem_multiElemSequence_elemNotFound_elemSmallerThenMin(){
        int key = 0;
        int[] seq = {1, 2, 3, 4, 5};

        SearchResult sr = BinarySearch.search(key, seq);

        Assertions.assertTrue(!sr.isFound() && sr.getPosition() == -1);
    }

    @Test
    void searchForElem_multiElemSequence_elemNotFound_elemInMiddlePos(){
        int key = 3;
        int[] seq = {1, 2, 4, 5};

        SearchResult sr = BinarySearch.search(key, seq);

        Assertions.assertTrue(!sr.isFound() && sr.getPosition() == -1);
    }

}
