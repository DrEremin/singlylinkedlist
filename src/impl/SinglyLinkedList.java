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
    private final MyIterator iterator;
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

        /*public Node<T> getNext() {
            return next;
        }*/

        public void setData(T data) {
            this.data = data;
        }

        /*public void setNext(Node<T> next) {
            this.next = next;
        }*/
    }

    /**
     * This class is the iterator by nodes
     * of this linked list
     */

    private class MyIterator implements Iterator<Node<T>> {

        private Node<T> currentLink;
        private final Node<T> preStart = new Node<>(null);

        public MyIterator() {
            preStart.next = start;
            currentLink = preStart;
        }

        @Override
        public boolean hasNext() {
            return (currentLink != null && currentLink.next != null);
        }

        @Override
        public Node<T> next() {
            return (currentLink = currentLink.next);
        }

        public Node<T> current() {
            return currentLink;
        }

        public void resetIterator() {
            preStart.next = start;
            currentLink = preStart;
        }
    }

    /**
     * Constructors of class SinglyLinkedList<T>
     */

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
        for(; index < array.length; index++) {
            if (array[index] != null) {
                start = new Node<>(array[index++]);
                end = start;
                sizeList++;
                iterator.resetIterator();
                break;
            }
        }
        if (start != null) {
            for(; index < array.length; index++) {
                if(array[index] != null) {
                    end.next = new Node<>(array[index]);
                    end = end.next;
                    sizeList++;
                }
            }
        }
    }


    public SinglyLinkedList(SinglyLinkedList<T> list) {
        this();
        for (Node<T> node : list) {
            if (start != null) {
                end.next = new Node<>(node.data);
                end = end.next;
            } else {
                start = new Node<>(node.data);
                end = start;
                iterator.resetIterator();
            }
            sizeList++;
        }
    }

    /**
     * Methods of class SinglyLinkedList<T>
     */

    /**
     * This method don't create new MyIterator,
     * but reset it.
     * @return Returns single MyIterator for this list.
     */

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
                end.next = new Node<>(data);
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
    public T popFront(T data) {
        if (start == null) {
            return data;
        }
        if (end == start) {
            data = start.data;
            end = null;
            start = null;
            iterator.resetIterator();
        } else {
            for (Node<T> node : this) {
                if (node.next == end) {
                    data = end.data;
                    end = node;
                    end.next = null;
                    break;
                }
            }
        }
        sizeList--;
        return data;
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
        if (start == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder("[");
        for (Node<T> node: this) {
            builder.append(node.data);
            builder.append(" ");
        }
        return (builder.toString().strip() + "]");
    }

    public int getSizeList() {
        return sizeList;
    }
}
