package impl;

import java.util.Iterator;
import java.util.function.Predicate;
import interfaces.MyList;

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

        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * This class is the iterator by nodes
     * of this linked list
     */

    private class MyIterator implements Iterator<Node<T>> {

        private Node<T> currentLink;
        private Node<T> previousLink;
        private final Node<T> preStart = new Node<>(null);
        int counterOfIterations;

        public MyIterator() {
            resetIterator();
        }

        @Override
        public boolean hasNext() {
            return (currentLink != null && currentLink.next != null);
        }

        @Override
        public Node<T> next() {
            previousLink = currentLink;
            return (currentLink = currentLink.next);
        }

        /**
         * This method set iterator to the initial state
         */

        public void resetIterator() {
            preStart.next = start;
            currentLink = preStart;
            previousLink = currentLink;
            counterOfIterations = -1;
        }

        /**
         * This method perform iterations by this list
         * until it reaches the specified index.
         * @param index index + 1 this number of nodes
         * by which necessary perform iterations.
         * @return Returns the node which match to index
         */

        public Node<T> getNodeByIndex(int index) {
            while (counterOfIterations != index && hasNext()) {
                next();
                counterOfIterations++;
            }
            return currentLink;
        }

        /**
         * This method remove the current node from this list
         */

        @Override
        public void remove() {
            if (currentLink == null) {
                return;
            }
            if (currentLink == start && currentLink== end) {
                start = null;
                end = null;
                resetIterator();
            } else if (currentLink == start) {
                start = start.next;
                currentLink = start;
                preStart.next = start;
            } else if (currentLink == end) {
                end = previousLink;
                currentLink = previousLink;
                currentLink.next = null;
            } else {
                Node<T> newNextNode = currentLink.next;
                currentLink.next = null;
                previousLink.next = newNextNode;
                currentLink = newNextNode;
            }
            sizeList--;
        }

        /**
         * This method insert new node to this list
         * @param data Data which necessary to insert
         * @return Returns true if insert had success
         * else false.
         */

        public boolean insert(T data) {
            if (data == null || currentLink == null) {
                return false;
            }
            if (start == null) {
                start = new Node<>(data);
                end = start;
                resetIterator();
            } else if (currentLink == end) {
                currentLink.next = new Node<>(data);
                end = end.next;
            } else if (currentLink == preStart) {
                Node<T> newNode = new Node<>(data);
                newNode.next = start;
                start = newNode;
                resetIterator();
            } else {
                Node<T> newNode = new Node<>(data);
                newNode.next = currentLink.next;
                currentLink.next = newNode;
            }
            sizeList++;
            return true;
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
        iterator.insert(data);
    }

    public SinglyLinkedList(T[] array) {
        this();
        for (int i = 0; i < array.length; i++) {
            if (iterator.insert(array[i])) {
                iterator.next();
            }
        }
    }

    public SinglyLinkedList(SinglyLinkedList<T> list) {
        this();
        for (Node<T> node : list) {
            this.iterator.insert(node.data);
            this.iterator.next();
        }
    }

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
        if (start != null) {
            iterator.currentLink = end;
        }
        boolean success = iterator.insert(data);
        iterator.resetIterator();
        return success;
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
        for (Node<T> node : this) {
            if (node.next == null) {
                data = node.data;
                iterator.remove();
            }
        }
        iterator.resetIterator();
        return data;
    }

    /**
     * This method add a node to the list before the first node
     * @param data The data is data then will to contain in the new node
     * @return Returns true if node was inserted else false
     */

    @Override
    public boolean pushBack(T data) {
        boolean success = iterator.insert(data);
        iterator.resetIterator();
        return success;
    }

    /**
     * This method remove the first node.
     * @return T. Returns data then contained in the removed node
     */

    @Override
    public T popBack(T data) {
        if (start == null) {
            return data;
        }
        data = start.data;
        iterator.next();
        iterator.remove();
        iterator.resetIterator();
        return data;
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
        if (!indexValid(position, true)) {
            return false;
        }
        iterator.getNodeByIndex(position);
        boolean success = iterator.insert(data);
        iterator.resetIterator();
        return success;
    }

    /**
     * This method remove the node which locate .
     * @param position This parameter specify the number of node
     * after which will removed node
     * @return T. Returns data then contained in the removed node
     */

    @Override
    public T popAfter(int position, T data) {
        if (!indexValid(position, false)) {
            return data;
        }
        data = iterator.getNodeByIndex(position + 1).data;
        iterator.remove();
        iterator.resetIterator();
        return data;
    }

    /**
     * This method remove all nodes which match the specified predicate
     * @param predicate Functional interface which check match a data of node the requirement
     * @return Returns true if list was updated else false
     */

    @Override
    public boolean removeIf(Predicate<T> predicate) {
        if (start == null) {
            return false;
        }
        boolean success = false;
        iterator.next();
        for (int i = 0, size = sizeList; i < size; i++) {
            if (predicate.test(iterator.currentLink.data)) {
                iterator.remove();
                success = true;
            } else {
                iterator.next();
            }
        }
        iterator.resetIterator();
        return success;
    }

    /**
     * This method remove all nodes of list
     */

    @Override
    public void clear() {
        if (start == null) {
            return;
        }
        iterator.next();
        for (int i = 0, size = sizeList; i < size; i++) {
            iterator.remove();
        }
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
        iterator.resetIterator();
        return (builder.toString().strip() + "]");
    }

    public int getSizeList() {
        return sizeList;
    }

    public boolean indexValid(int index, boolean isPush) {
        if (isPush) {
            return (index >= 0 && index < sizeList);
        }
        return (index >= 0 && index < sizeList - 1);
    }
}
