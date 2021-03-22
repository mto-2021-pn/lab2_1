package utils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayUtils {
  public static boolean isSorted(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] > array[i + 1]) {
        return false;
      }
    }
    return true;
  }

  public static boolean arrayHasDuplicates(int[] array) {
    Set<Integer> set = Arrays.stream(array).boxed().collect(Collectors.toSet());
    return array.length != set.size();
  }
}
