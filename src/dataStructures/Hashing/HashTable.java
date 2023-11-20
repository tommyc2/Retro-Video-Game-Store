package dataStructures.Hashing;

public class HashTable<T> {

    /* Hash Table using Quadratic Probing technique */
    /* Uses primitive array to store objects of a specified type */
    /* Written by: Tommy Condon */
    T[] hashTable;

    public HashTable(int size){
        hashTable = (T[]) new Object[size];
    }

    //TODO
    public int hashFunction(int key) {
        return key % hashTable.length;
    }


    //TODO
    public boolean add(int key, T data){
        int newIndex = hashFunction(key);
        int location = newIndex;
        int probe = 1;
        do {
            if(hashTable[location]!=null) {
                hashTable[location] = data;
                return true;
            }
            else {
                location = (location+(probe*probe++)) % hashTable.length;
            }

        } while(probe<=50);
        return false;
    }

    //TODO
    public String listTableElements(){
        return "";
    }

    //TODO
    public T getByIndexID(int id){
        T obj = (T) new Object();
        return obj;
    }




}
