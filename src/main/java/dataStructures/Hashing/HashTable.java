package dataStructures.Hashing;

import dataStructures.CustomLinkedList.Node;

public class HashTable<K,T> {

    /* Hash Table using Linear Probing technique */
    /* Uses primitive array to store objects of a specified type */
    /* Written by: Tommy Condon */
    /* Open Addressing */
    T[] hashTable;
    K[] keys;

    public HashTable(int size){
        hashTable = (T[]) new Object[size];
        keys = (K[]) new Object[size];
    }

    public int hashFunction(int key) {
        return key % hashTable.length;
    }

    public boolean add(K k, T data){
        int key = Math.abs(k.hashCode());
        int location = hashFunction(key);
        int startLoc = location;
        int probe = 1;
        do {
            if(hashTable[location]==null) {
                hashTable[location] = data;
                keys[location] = k;
                return true;
            }
            else {
                location = (location + 1) % hashTable.length;
            }

        } while(location!=startLoc);
        return false;
    }

    // Returns value pair of key
    public T getValuePair(K key) {
        int map = Math.abs(key.hashCode());
        int location = hashFunction(map);
        int startLoc = location;

        do {
            if(keys[location].equals(key)) {
                return hashTable[location];
            }
            else{
                location = (location+1) % keys.length;
            }
        } while(startLoc!=location);

        return null;
    }

    public String listTableElements(){
        String list = "";
        for(int id = 0; id < hashTable.length; id++){
            if(hashTable[id]!=null){
                list += "(" + (id) + ") " + hashTable[id].toString() +"\n";
            }
        }

        if (list.isEmpty()) return "List is empty";

        else {
            return list;
        }
    }

    public T getByIndex(int id){
        if(hashTable[id]!=null){
            return hashTable[id];
        }
        return null;
    }


    public T remove(T obj){
        for(int i = 0; i < hashTable.length; i++){
            if (hashTable[i].equals(obj)){
                hashTable[i] = null;
                return obj;
            }
        }
        return null;
    }

}
