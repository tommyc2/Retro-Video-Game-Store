package dataStructures.Hashing;

public class HashTable<T> {

    T[] hashTable;

    public HashTable(int size){
        hashTable = (T[]) new Object[size];
    }
}
