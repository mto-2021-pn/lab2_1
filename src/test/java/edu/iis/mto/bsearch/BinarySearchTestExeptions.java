package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTestExeptions {
  @Test
  void should_thorw_IllegalArgumentException_seq_size_0() {
    int key = 1;
    int[] seq = new int[0];
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          BinarySearch.search(key, seq);
        });
  }

  @Test
  void should_thorw_IllegalArgumentException_duplicates() {
    int[] seq = {1, 2, 3, 4, 5, 6, 6, 7, 8, 9};
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          BinarySearch.search(1, seq);
        });
  }

  @Test
  void should_thorw_IllegalArgumentException_seq_is_not_sorted() {
    int[] seq = {Integer.MAX_VALUE, 2, 3, 4, 5, 6, 6, 7, 8, Integer.MIN_VALUE};
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          BinarySearch.search(1, seq);
        });
  }
}
