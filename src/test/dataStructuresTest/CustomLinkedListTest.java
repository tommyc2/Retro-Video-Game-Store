package dataStructuresTest;

import dataStructures.CustomLinkedList.CustomLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTest {

    private CustomLinkedList<String> customList;

    @BeforeEach
    void setUp() {
        // Create a new CustomLinkedList instance before each test
        customList = new CustomLinkedList<>();
    }

    @Test
    void testAddAndGet() {
        customList.add("Element1");
        customList.add("Element2");

        assertEquals("Element2", customList.get(0));
        assertEquals("Element1", customList.get(1));
    }

    @Test
    void testIndexOf() {
        customList.add("Element1");
        customList.add("Element2");

        assertEquals(0, customList.indexOf("Element2"));
        assertEquals(1, customList.indexOf("Element1"));
        assertEquals(-1, customList.indexOf("Element3")); // Element not in the list
    }

    @Test
    void testResetList() {
        customList.add("Element1");
        customList.add("Element2");

        assertTrue(customList.resetList());
        assertEquals(0, customList.size());
    }

    @Test
    void testSize() {
        customList.add("Element1");
        customList.add("Element2");

        assertEquals(2, customList.size());

        customList.resetList();

        assertEquals(0, customList.size());
    }

    @Test
    void testListElements() {
        customList.add("Element1");
        customList.add("Element2");

        assertEquals("(0) Element2\n(1) Element1\n", customList.listElements());
    }

    @Test
    void testRemove() {
        customList.add("Element1");
        customList.add("Element2");
        customList.add("Element3");

        customList.remove(1); // Remove Element2

        assertEquals(2, customList.size());
        assertEquals("(0) Element3\n(1) Element1\n", customList.listElements());
    }

    @Test
    void testIterator() {
        customList.add("Element1");
        customList.add("Element2");

        int count = 0;
        for (String element : customList) {
            count++;
        }

        assertEquals(2, count);
    }
}

