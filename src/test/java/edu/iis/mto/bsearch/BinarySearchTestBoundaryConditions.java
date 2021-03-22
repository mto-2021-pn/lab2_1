package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTestBoundaryConditions {
  @Test
  void should_return_true_key_Integer_MAX_VALUE() {
    int key = Integer.MAX_VALUE;
    int[] seq = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, key};
    SearchResult searchResult = BinarySearch.search(key, seq);
    Assertions.assertTrue(searchResult.isFound() && seq[searchResult.getPosition()] == key);
  }

  @Test
  void should_return_true_key_Integer_MIN_VALUE() {
    int key = Integer.MIN_VALUE;
    int[] seq = {key, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    SearchResult searchResult = BinarySearch.search(key, seq);
    Assertions.assertTrue(searchResult.isFound() && seq[searchResult.getPosition()] == key);
  }
}
