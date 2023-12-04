package dataStructures.CustomLinkedList;

import java.util.Iterator;

public class CustomLinkedList<T> implements Iterable<T> {

    /* Written by: Tommy Condon */

    public Node<T> head=null;

    public boolean add(T c){
        Node<T> newNode = new Node<T>();
        newNode.setContents(c);
        newNode.next = head;
        head = newNode;
        return false;
    }

    public T get(int index){
        Node<T> temp = head;

        int i = 0;
        while( (temp!=null) && (i < size()) ){
            if(i==index){
                return temp.getContentsOfNode();
            }
            i++;
            temp = temp.getNext();
        }
        return null;
    }

    public int indexOf(T c){
        Node<T> temp = head;

        while(temp!=null){
            for(int index = 0; index < size(); index++){
                if(c.equals(temp.getContentsOfNode())){ // Checking if object contents = to temp's contents
                    return index;
                }
                temp = temp.getNext();
            }
        }
        return -1; // No elements in list, hence return -1;
    }

    public boolean resetList(){
        this.head=null;
        return true;
    }

    public int size() {
        Node<T> temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.getNext();
        }
        return size;
    }

    public String listElements(){
        Node<T> temp = head;
        String list = "";
        while(temp!=null){
            list += "(" + (indexOf(temp.getContentsOfNode())) + ") " + temp.getContentsOfNode().toString()+"\n";
            temp = temp.getNext();
        }
        return list;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomLinkedListIterator<T>(head);
    }

    public void remove(int index) {
        Node<T> temp = head;

        if (index==0){
            head=head.next;
        }

        int i = 0;
        while(i<index-1 && temp!=null) {
            temp = temp.next;
            i++;
        }
        if(temp!=null && temp.next!=null) {
            temp.next=temp.next.next;
        }
    }


}
