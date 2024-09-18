/**
 * Priority Queue implementation using a linked list.
 * Implements the PriorityQueue interface.
 * Overrides the add, getMostExpensive, clear, getLength, and isEmpty methods.
 * Provides an inner class Node with value house and next.
 */
public class PriorityQueueList implements PriorityQueue {

    /**
     * Fields of the PriorityQueueList class.
     */
    private Node head;
    private int length;


    /**
     * Default constructor.
     */
    public PriorityQueueList() {
        this.length = 0;
        this.head = null;
    }

    /**
     * Adds a house to the priority queue list based on the value of the house.
     * Checks if the list is empty,
     * or if the head of the list is smaller than the value of the house that will be added.
     * Add the house based on the value of the house into the list based on the priority condition.
     *
     * @param a house object that will be added to the priority queue list.
     */
    @Override
    public void add(House a) {
        Node newNode = new Node(a);
        if (head == null || a.getValue() > head.house.getValue()) {
            newNode.next = head;
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null && currentNode.next.house.getValue() > a.getValue()) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        length++;
    }

    /**
     * Gets the most expensive house in the priority queue list and removes it.
     * Checks if the list is empty.
     *
     * @return The most expensive house in the list.
     */
    @Override
    public House getMostExpensive() {
        if (head == null) {
            return null;
        }

        House mostExpensiveHouse = head.house;
        head = head.next;
        length--;

        return mostExpensiveHouse;
    }

    /**
     * Clears the priority queue list by setting the head to null and the length to 0.
     */
    @Override
    public void clear() {
        head = null;
        length = 0;
    }

    /**
     * Gets the length of the priority queue list.
     *
     * @return The length of the list.
     */
    @Override
    public int getLength() {
        return length;
    }

    /**
     * Checks if the priority queue list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        } else
            return false;
    }

    /**
     * Constructor that creates a deep copy of the priority queue list into a new list.
     *
     * @param other PriorityQueueList object.
     */
    public PriorityQueueList(PriorityQueueList other) {
        this.length = 0;
        this.head = null;
        Node newNode = other.head;
        while (newNode != null) {
            this.add(newNode.house.deepCopy());
            newNode = newNode.next;
        }
    }

    /**
     * Creates deep copy of the priority queue list to a new list by using the deepCopy method of the house object.
     *
     * @return New PriorityQueueList object with deep copied values.
     */
    public PriorityQueueList deepCopy() {
        return new PriorityQueueList(this);
    }

    /**
     * Inner class Node that holds a house object and a next node.
     */
    private class Node {
        House house;
        Node next;

        /**
         * Constructor that creates a new Node object from a house object.
         * Sets the next node to null.
         *
         * @param house House object.
         */
        public Node(House house) {
            this.house = house;
            this.next = null;
        }
    }
}
