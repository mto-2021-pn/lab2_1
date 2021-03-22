package edu.iis.mto.bsearch;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class BinarySearchTest {

    int list[];
    SearchResult searchResult;

    @BeforeEach
    void setUp() throws Exception {
        searchResult = new SearchResult();
    }

    @Test
    void singleElmExistsInSeq() {
        list = new int[]{5};
        searchResult.setPosition(1);
        assertThat(BinarySearch.search(5, list), Matchers.equalTo(searchResult));
    }

    @Test
    void singleElmNotInSeq(){
        list = new int[]{5};
        searchResult.setPosition(-1);
        assertThat(BinarySearch.search(3, list), Matchers.equalTo(searchResult));
    }

    @Test
    void elmFirstInSeq() {
        list = new int[]{5, 6, 7, 8, 9};
        searchResult.setPosition(1);
        assertThat(BinarySearch.search(5, list), Matchers.equalTo(searchResult));
    }

    @Test
    void elmLastInSeq() {
        list = new int[]{5, 6, 7, 8, 9};
        searchResult.setPosition(list.length);
        assertThat(BinarySearch.search(9, list), Matchers.equalTo(searchResult));
    }

    @Test
    void elmMiddleInSeq() {
        list = new int[]{5, 6, 7, 8, 9};
        searchResult.setPosition((int)list.length/2 + 1);
        assertThat(BinarySearch.search(7, list), Matchers.equalTo(searchResult));
    }

    @Test
    void elmNotInSeq() {
        list = new int[]{5, 6, 7, 8, 9};
        searchResult.setPosition(-1);
        assertThat(BinarySearch.search(10, list), Matchers.equalTo(searchResult));
    }

    @Test
    void emptySeq(){
        list = new int[]{};
        searchResult.setPosition(-1);
        assertThat(BinarySearch.search(10, list), Matchers.equalTo(searchResult));
    }

}
