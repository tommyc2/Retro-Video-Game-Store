package dataStructures.CustomLinkedList;

import java.util.Iterator;

public class CustomLinkedListIterator<T> implements Iterator<T> {

    /* Written by: Tommy Condon */
    private Node<T> currentPosition;

    public CustomLinkedListIterator(Node<T> node) {
        currentPosition = node;
    }

    @Override
    public boolean hasNext() {
        return currentPosition!=null;
    }

    @Override
    public T next(){
        Node<T> temp = currentPosition;
        currentPosition=currentPosition.next;
        return temp.getContentsOfNode();
    }

}
