package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

  @BeforeEach
  void setUp() throws Exception {}

  @Test
  void should_return_true_seq_Size_1_and_Element_Is_In_Seq() {
    int key = 87;
    int[] seq = {key};
    SearchResult searchResult = BinarySearch.search(key, seq);
    Assertions.assertTrue(searchResult.isFound() && seq[searchResult.getPosition()] == key);
  }

  @Test
  void should_return_true_seq_Size_1_and_Element_Is_Not_In_Seq() {
    int key = 87;
    int[] seq = {7};
    SearchResult searchResult = BinarySearch.search(key, seq);
    Assertions.assertTrue(searchResult.isFound() == false && searchResult.getPosition() == -1);
  }

  @Test
  void should_return_true_seq_Size_10_and_Element_Is_In_Seq_In_Position_1() {
    int key = 1;
    int[] seq = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    SearchResult searchResult = BinarySearch.search(key, seq);
    Assertions.assertTrue(searchResult.isFound() && seq[searchResult.getPosition()] == key);
  }

  @Test
  void should_return_true_seq_Size_10_and_Element_Is_In_Seq_In_Last_Position() {
    int key = 10;
    int[] seq = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    SearchResult searchResult = BinarySearch.search(key, seq);
    Assertions.assertTrue(searchResult.isFound() && seq[searchResult.getPosition()] == key);
  }

  @Test
  void should_return_true_seq_Size_11_and_Element_Is_In_Seq_In_The_Middle() {
    int key = 6;
    int[] seq = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    SearchResult searchResult = BinarySearch.search(key, seq);
    Assertions.assertTrue(searchResult.isFound() && seq[searchResult.getPosition()] == key);
  }

  @Test
  void should_return_true_seq_Size_11_and_Element_Is_Not_In_Seq() {
    int key = 874;
    int[] seq = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    SearchResult searchResult = BinarySearch.search(key, seq);
    Assertions.assertTrue(searchResult.isFound() == false && searchResult.getPosition() == -1);
  }
}
