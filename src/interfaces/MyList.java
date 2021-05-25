package interfaces;

import java.util.function.Predicate;

public interface MyList<T> {

    /**
     * This method add a node to the list after the last node
     * @param data it is data then will to contain in the new node
     * @return Returns true if node was inserted else false
     */

    boolean push_front(T data);

    /**
     * This method remove the last node.
     * @return T. Returns data then contained in the removed node
     */

    T pop_front();

    /**
     * This method add a node to the list before the first node
     * @param data The data is data then will to contain in the new node
     * @return Returns true if node was inserted else false
     */

    boolean push_back(T data);

    /**
     * This method remove the first node.
     * @return T. Returns data then contained in the removed node
     */

    T pop_back();

    /**
     * This method add a node to the list after specified position
     * @param position This parameter specify the number of node
     * after which will inserted new node
     * @param data The data is data then will to contain in the new node
     * @return Returns true if node was inserted else false
     */

    boolean push_after(int position, T data);

    /**
     * This method remove the node which locate .
     * @param position This parameter specify the number of node
     * after which will removed node
     * @return T. Returns data then contained in the removed node
     */

    T pop_after(int position);

    /**
     * This method remove all nodes which match the specified predicate
     * @param predicate Functional interface which check match a data of node the requirement
     * @return Returns true if list was updated else false
     */

    boolean removeIf(Predicate<T> predicate);
}
