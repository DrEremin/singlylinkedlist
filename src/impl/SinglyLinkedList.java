package impl;

import interfaces.MyList;

import java.util.function.Predicate;

public class SinglyLinkedList<T> implements MyList<T> {

    /**
     * This nested class is the node of linked list
     * @param <T> T is type runtime of data which contain in node of linked list
     */

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

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
