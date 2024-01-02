package dataStructuresTest;

import dataStructures.Hashing.HashTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    private HashTable<Integer, String> hashTable;

    @BeforeEach
    void setUp() {
        // Create a new HashTable instance before each test
        hashTable = new HashTable<>(10);
    }

    @Test
    void testAdd() {
        assertTrue(hashTable.add(1, "Value1"));
        assertTrue(hashTable.add(2, "Value2"));
        assertTrue(hashTable.add(11, "Value11")); // should go to the same index as key 1 due to linear probing

        // Check if values are added
        assertEquals("Value1", hashTable.getValuePair(1));
        assertEquals("Value2", hashTable.getValuePair(2));
        assertEquals("Value11", hashTable.getValuePair(11));
    }



    @Test
    void testListTableElements() {
        // Add values to the hash table
        hashTable.add(1, "Value1");
        hashTable.add(2, "Value2");

        // Check the list of elements
        assertEquals("(1) Value1\n(2) Value2\n", hashTable.listTableElements());

        // Remove a value
        hashTable.remove(1);

        // Check the updated list of elements
        assertEquals("(2) Value2\n", hashTable.listTableElements());
    }

    @Test
    void testRemove() {
        // Add values to the hash table
        hashTable.add(1, "Value1");
        hashTable.add(2, "Value2");

        // Remove a value
        assertTrue(hashTable.remove(1));

        // Check that the value is removed
        assertNull(hashTable.getByIndex(1));
    }

    @Test
    void testSwapElements() {
        // Add values to the hash table
        hashTable.add(0, "Value1");
        hashTable.add(1, "Value2");

        // Swap elements
        hashTable.swapElements(0, 1);

        // Check that elements are swapped
        assertEquals("Value2", hashTable.getByIndex(0));
        assertEquals("Value1", hashTable.getByIndex(1));
    }
}

