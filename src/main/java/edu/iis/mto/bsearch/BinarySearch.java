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
        if(seq.length == 0){
            throw new IllegalArgumentException("Sequence is empty");
        }
        if(checkDuplicates(seq)){
            throw new IllegalArgumentException("Sequence contains duplicate values");
        }

        if (! checkSorted(seq)){
            throw new IllegalArgumentException("Sequence must be sorted ");
        }
        int start = 0;
        int end = seq.length - 1;
        int center;

        SearchResult result = new SearchResult();

        while (start <= end) {
            center = (start + end) / 2;
            if (seq[center] == key) {
                result.setPosition(center + 1);
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

    /**
     * Metoda sprawdza czy podana tablica zawiera duplikaty
     * @param seq tablica
     * @return true - jezeli zawiera; false - jeżeli nie
     */
    private  static boolean checkDuplicates(int [] seq){
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<seq.length; i++){
            if( ! set.add(seq[i])){
                return true;
            }
        }
        return false;
    }

    /***
     * Metoda sprawdza czy tablica jest posortowana
     * @param seq tablica
     * @return true - jeżeli jest posortowana; false jeżeli nie
     */
    private static boolean checkSorted(int [] seq){
        for (int i = 0; i < seq.length - 1; i++) {
            if (seq[i] > seq[i + 1])
                return false;
        }
        return true;
    }
}


