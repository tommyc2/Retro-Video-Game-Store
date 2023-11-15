package dataStructures.CustomLinkedList;

public class Node<T> {
    public Node<T> next=null;
    private T contents;

    public T getContentsOfNode(){
        return this.contents;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setContents(T c){
        this.contents = c;
    }

}
