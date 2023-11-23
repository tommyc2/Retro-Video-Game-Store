package dataStructures.Hashing;

public class HashTable<T> {

    /* Hash Table using Quadratic Probing technique */
    /* Uses primitive array to store objects of a specified type */
    /* Written by: Tommy Condon */

    T[] hashTable;

    public HashTable(int size){
        hashTable = (T[]) new Object[size];
    }


    public int hashFunction(int key) {
        return key % hashTable.length;
    }


    //TODO
    public boolean add(T data){
        int home = hashFunction(Math.abs(data.hashCode()));
        int location = home;
        int probe = 1;
        do {
            if(hashTable[location]==null) {
                hashTable[location] = data;
                return true;
            }
            else {
                location = (location+(probe*probe++)) % hashTable.length;
            }

        } while(probe<=50);
        return false;
    }


    public String listTableElements(){
        String list = "";
        for(int id = 0; id < hashTable.length; id++){
            if(hashTable[id]!=null){
                list += "(" + (id) + ") " + hashTable[id].toString() +"\n";
            }
        }

        return list;

    }

    public T getByIndexID(int id){
        if(hashTable[id]!=null){
            return hashTable[id];
        }
        return null;
    }


    public int indexOf(T c){
        for(int i = 0; i < hashTable.length; i++){
            if(hashTable[i]!=null){
                if(hashTable[i].equals(c)){
                    return (i);
                }
            }
        }
        return -1;
    }

}


