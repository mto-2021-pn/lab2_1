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

    private BinarySearch() {}

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
        if (seq.length == 0)
            throw new IllegalArgumentException("Sequence cannot be empty");
        if (checkIfSequenceContainsDuplicates(seq))
            throw new IllegalArgumentException("Sequence cannot contain duplicates");
        if (!checkIfSequenceIsSortedAscending(seq))
            throw new IllegalArgumentException("Sequence cannot be unsorted");
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

    private static Boolean checkIfSequenceIsSortedAscending(int[] seq) {
        int previous = seq[0];

        for (int i = 1; i < seq.length; ++i) {
            if (previous > seq[i])
                return false;
            previous = seq[i];
        }
        return true;
    }

    private static Boolean checkIfSequenceContainsDuplicates(int[] seq) {
        Set<Integer> set = new HashSet<>();
        for (Integer element : seq) {
            if (!set.add(element))
                return true;
        }
        return false;
    }
}
