package impl;

import interfaces.MyList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.function.Predicate;

public class SinglyLinkedList<T> implements MyList<T> {

    private Node<T> start;
    /**
     * This nested class is the node of linked list
     * @param <T> T is type runtime of data which contain in node of linked list
     */

    private static class Node<T> {
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
    }

    private class MyIterator implements Iterator<Node<T>> {
        private Node<T> currentLink;

        public MyIterator() {
            currentLink = start;
        }

        @Override
        public boolean hasNext() {
            return currentLink.getNext() != null;
        }

        @Override
        public Node<T> next() {
            return currentLink = currentLink.getNext();
        }

    }
    LinkedList list;
    /**
     * This method add a node to the list after the last node
     * @param data it is data then will to contain in the new node
     * @return Returns true if node was inserted else false
     */

    @Override
    public boolean push_front(T data) {


        return false;
    }

    /**
     * This method remove the last node.
     * @return T. Returns data then contained in the removed node
     */

    @Override
    public T pop_front() {
        return null;
    }

    /**
     * This method add a node to the list before the first node
     * @param data The data is data then will to contain in the new node
     * @return Returns true if node was inserted else false
     */

    @Override
    public boolean push_back(T data) {
        return false;
    }

    /**
     * This method remove the first node.
     * @return T. Returns data then contained in the removed node
     */

    @Override
    public T pop_back() {
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
    public boolean push_after(int position, T data) {
        return false;
    }

    /**
     * This method remove the node which locate .
     * @param position This parameter specify the number of node
     * after which will removed node
     * @return T. Returns data then contained in the removed node
     */

    @Override
    public T pop_after(int position) {
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
}
