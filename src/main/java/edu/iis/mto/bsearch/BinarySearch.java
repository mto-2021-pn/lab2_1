/**
 *
 */
package edu.iis.mto.bsearch;

import java.util.HashSet;
import java.util.Set;

/**
 * Klasa implementująca wyszukiwanie binarne
 *
 */
public class BinarySearch {

    public BinarySearch() {
    }

    /**
     * Metoda realizujaca wyszukiwanie binarne
     *
     * @param key
     *            - szukany obiekt
     * @param seq
     *            - rosnaco uporzadkowana niepusta sekwencja
     * @return obiekt rezultatu o polach: - found (true jezeli znaleziony) - position (jezeli znaleziony - pozycja w
     *         sekwencji, jezeli nie znaleziony -1)
     */
    public static SearchResult search(int key, int[] seq) {
        if (seq.length == 0) {
            throw new IllegalArgumentException();
        }
        if (noDuplicate(seq) == false) {
            throw new IllegalArgumentException();
        }
        if (isSorted(seq) == false) {
            throw new IllegalArgumentException();
        }

        int start = 0;
        int end = seq.length - 1;
        int center;
        SearchResult result = new SearchResult();

        while (start <= end) {
            center = (start + end) / 2;
            if (seq[center] == key) {
                result.setPosition(center);
                break;
            } else {
                if (seq[center] < key) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            }
        }
        return result;
    }

    public static boolean noDuplicate(int[] seq) {
        Set<Integer> set = new HashSet<>();

        for (int el : seq) {
            if (!set.add(el)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(int[] seq) {
        for (int i = 0; i < seq.length - 1; i++) {
            if (seq[i] > seq[i + 1]) {
                return false;
            }
        }

        return true;
    }

}
