/**
 * @author: Joonho Kim
 * @version 1.0
 * @since 29/03/2020
 *
 * Bailey, D. A. (2002).
 * Java structures: Data structures in Java for the principled programmer.
 * McGraw-Hill.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 * The VectorHeap class stores all the E-type objects in ascendant order with the Priority Queue implementation
 * one can easily remove the smaller E-type object. Also, the operation of adding is merely from this class
 * @param <E> the Object that the VectorHeap data will store
 */

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    protected Vector<E> data; // the data, kept in heap order

    public VectorHeap()
    // post: constructs a new priority queue
    {
        data = new Vector<E>();
    }

    public VectorHeap(Vector<E> v)
    // post: constructs a new priority queue from an unordered vector
    {
        int i;
        data = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++) { // add elements to heap
            add(v.get(i));
        }
    }

/**
 * Gets the parent of a given position in the data vector
 * @param i the index of the current heap
 * @return the integer of the index of the parent
 */

    protected static int parent(int i)
    // pre: 0 <= i < size
    // post: returns parent of node at location i
    {
        return (i - 1) / 2;
    }



/**
 * Gets the left child of the specific node according to a given index in the data vector
 * @param i the index of the heap
 * @return the index of the left child of the heap
 */

    protected static int left(int i)
    // pre: 0 <= i < size
    // post: returns index of left child of node at location i
    {
        return 2 * i + 1;
    }

/**
 * Gets the right child of the specific node according to a given index in the data vector
 * @param i the index in the data vector of the heap to get the child from
 * @return the right child of that specific node
 */

    protected static int right(int i)
    // pre: 0 <= i < size
    // post: returns index of right child of node at location i
    {
        return (2 * i + 1) + 1;
    }

       /**
     * Used to move a new added leaf up until it reaches the apropiate position to match the heaps rules
     * @param leaf the index of the new leaf
     */

    protected void percolateUp(int leaf)
    // pre: 0 <= leaf < size
    // post: moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

/**
 * Adds a new E-type value to the vectorHeap
 * @param value the E-type object  that will be added to the vectorHeap
 */

    public void add(E value)
    // pre: value is non-null comparable
    // post: value is added to priority queue
    {
        data.add(value);
        percolateUp(data.size() - 1);
    }

/**
 * Function to push the root down until the root is located in the correct position to make the vectorHeap oredered
 * @param root the index in of the vectorHeap of the root
 */

    protected void pushDownRoot(int root)
    // pre: 0 <= root < size
    // post: moves node at index root down
    // to appropriate position in subtree
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root, value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root, value);
                return;
            }
        }
    }
    
    Vector<E> pacientes=new Vector<>();

/**
 * Removes the smallest object in the vectorHeap, and uses the pushDownRoot method to rearrange the splay tree and
 * thus make the vectorHeap be in order again
 * @return the minimum value in the heap if it does exist, according to the priority queue implementation
 * otherwise returns null
 */
    public E remove()
    // pre: !isEmpty()
    // post: returns and removes minimum value from queue
    {
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1)
            pushDownRoot(0);
        pacientes.add(minVal);
        return minVal;
    }

/**
 * Gets the minimum value in the vectorHeap but without rearranging the data in the SplayTree
 * @return the patient with the maximum priority
 */
    @Override
    public E getFirst() {
        return data.get(0);
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

}
