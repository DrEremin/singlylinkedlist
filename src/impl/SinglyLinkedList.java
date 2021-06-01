package impl;

import interfaces.MyList;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SinglyLinkedList<T> implements MyList<T>, Iterable<SinglyLinkedList.Node<T>> {

    private Node<T> start;
    private Node<T> end;
    private MyIterator iterator;
    private int sizeList;

    /**
     * This nested class is the node of this linked list
     * @param <T> T is type runtime of data which contain
     * in node of linked list
     */

    public static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    /**
     * This class is the iterator by nodes
     * of this linked list
     */

    private class MyIterator implements Iterator<Node<T>> {
        private Node<T> currentLink;

        public MyIterator() {
            currentLink = start;
        }

        @Override
        public boolean hasNext() {
            return (currentLink != null && currentLink.getNext() != null);
        }

        @Override
        public Node<T> next() {
            return currentLink = currentLink.getNext();
        }

        public void resetIterator() {
            currentLink = start;
        }
    }

    public SinglyLinkedList() {
        start = null;
        end = null;
        iterator = new MyIterator();
        sizeList = 0;
    }

    public SinglyLinkedList(T data) {
        this();
        if (data != null) {
            start = new Node<T>(data);
            end = start;
            sizeList++;
        }
    }

    public SinglyLinkedList(T[] array) {
        this();
        int index = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                start = new Node<>(array[i]);
                end = start;
                index = ++i;
                sizeList++;
                iterator.resetIterator();
                break;
            }
        }
        if (index > 0) {
            for(; index < array.length; index++) {
                if(array[index] != null) {
                    end.setNext(new Node<>(array[index]));
                    end = end.next;
                    sizeList++;
                }
            }
            iterator.resetIterator();
        }
    }


    /*public SinglyLinkedList(SinglyLinkedList<T> list) {
        this();
        for (:
             ) {

        }
        //start = new Node<T>(data);
        iterator = new MyIterator();
    }*/

    @Override
    public Iterator<SinglyLinkedList.Node<T>> iterator() {
        iterator.resetIterator();
        return iterator;
    }

    /**
     * This method add a node to the list after the last node
     * @param data it is data then will to contain in the new node
     * @return Returns true if node was inserted else false
     */

    @Override
    public boolean pushFront(T data) {
        if (data != null) {
            if (end != null) {
                end.setNext(new Node<>(data));
                end = end.next;
            } else {
                start = new Node<T>(data);
                end = start;
            }
            sizeList++;
            return true;
        }
        return false;
    }

    /**
     * This method remove the last node.
     * @return T. Returns data then contained in the removed node
     */

    @Override
    public T popFront() {
        return null;
    }

    /**
     * This method add a node to the list before the first node
     * @param data The data is data then will to contain in the new node
     * @return Returns true if node was inserted else false
     */

    @Override
    public boolean pushBack(T data) {
        return false;
    }

    /**
     * This method remove the first node.
     * @return T. Returns data then contained in the removed node
     */

    @Override
    public T popBack() {
        return null;
    }

    /**
     * This method add a node to the list after specified position
     * @param position This parameter specify the number of node
     * after which will inserted new node
     * @param data The data is data then will to contain in the new node
     * @return Returns true if node was inserted else false
     */

    @Override
    public boolean pushAfter(int position, T data) {
        return false;
    }

    /**
     * This method remove the node which locate .
     * @param position This parameter specify the number of node
     * after which will removed node
     * @return T. Returns data then contained in the removed node
     */

    @Override
    public T popAfter(int position) {
        return null;
    }

    /**
     * This method remove all nodes which match the specified predicate
     * @param predicate Functional interface which check match a data of node the requirement
     * @return Returns true if list was updated else false
     */

    @Override
    public boolean removeIf(Predicate<T> predicate) {
        return false;
    }

    /**
     * This method remove all nodes of list
     */

    @Override
    public void clear() {

    }

    /**
     * @return This implementation returns the string representation
     * this list
     */

    @Override
    public String toString() {
        return super.toString();
    }

    public int getSizeList() {
        return sizeList;
    }
}
