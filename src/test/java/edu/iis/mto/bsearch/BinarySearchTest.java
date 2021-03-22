package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    void shouldFindElementWhenSequenceContainsOnlyThisElement() {
        // given
        int element = 100;
        int[] sequence = {element};

        // when
        SearchResult result = BinarySearch.search(element, sequence);

        // then
        assertTrue(result.isFound(), "Expected element should be found");
        assertEquals(0, result.getPosition(), "Position of found element should be 0");
    }

    @Test
    void shouldNotFindElementInSingleElementSequence() {
        // given
        int element = 100;
        int[] sequence = {200};

        // when
        SearchResult result = BinarySearch.search(element, sequence);

        // then
        assertFalse(result.isFound(), "Expected element should not be found");
        assertEquals(-1, result.getPosition(), "Position should be set to -1 for an item that's not found");
    }

    @Test
    void shouldFindElementWhenTheElementIsFirstInMultiSequence() {
        // given
        int element = 50;
        int[] sequence = {50, 100};

        // when
        SearchResult result = BinarySearch.search(element, sequence);

        // then
        assertTrue(result.isFound(), "Expected element should be found");
        assertEquals(0, result.getPosition(), "Position of found element should be 0");
    }

    @Test
    void shouldFindElementWhenTheElementIsLastInMultiSequence() {
        // given
        int element = 50;
        int[] sequence = {25, 50};

        // when
        SearchResult result = BinarySearch.search(element, sequence);

        // then
        assertTrue(result.isFound(), "Expected element should be found");
        assertEquals(1, result.getPosition(), "Position of found element should be 1");
    }

    @Test
    void shouldFindElementWhenTheElementIsInTheMiddleOfMultiSequence() {
        // given
        int element = 50;
        int[] sequence = {25, 50, 75};

        // when
        SearchResult result = BinarySearch.search(element, sequence);

        // then
        assertTrue(result.isFound(), "Expected element should be found");
        assertEquals(1, result.getPosition(), "Position of found element should be 1");
    }

    @Test
    void shouldNotFindElementInMultiElementSequence() {
        // given
        int element = 100;
        int[] sequence = {150, 200, 350};

        // when
        SearchResult result = BinarySearch.search(element, sequence);

        // then
        assertFalse(result.isFound(), "Expected element should not be found");
        assertEquals(-1, result.getPosition(), "Position should be set to -1 for an item that's not found");
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSequenceIsEmpty() {
        // given
        int element = 100;
        int[] sequence = {};
        String expectedMessage = "Sequence cannot be empty";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(element, sequence),
                "IllegalArgumentException should be thrown when sequence is empty");

        // then
        assertEquals(expectedMessage, exception.getMessage(), "Message of exception should be: " + expectedMessage);

    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSequenceUnsorted() {
        // given
        int element = 5;
        int[] sequence = {1, 2, 8, 4, 3, 5, 17};
        String expectedMessage = "Sequence cannot be unsorted";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(element, sequence),
                "IllegalArgumentException should be thrown when sequence is unsorted");

        // then
        assertEquals(expectedMessage, exception.getMessage(), "Message of exception should be: " + expectedMessage);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSequenceContainsDuplicates() {
        // given
        int[] sequence = {1, 2, 3, 3, 5};
        String expectedMessage = "Sequence cannot contain duplicates";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(5, sequence),
                "IllegalArgumentException should be thrown when sequence is unsorted");

        // then
        assertEquals(expectedMessage, exception.getMessage(), "Message of exception should be: " + expectedMessage);
    }

}
