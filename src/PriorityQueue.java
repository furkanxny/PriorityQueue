/**
 * Interface for a priority queue list that holds house object.
 * Provides methods for adding house, getting the most expensive house, clearing the list,
 * getting the length of the list, and checking if the list is empty.
 */
public interface PriorityQueue {

    /**
     * Adds a house to the priority queue list based on the value of the house.
     *
     * @param a house object that will be added.
     */
    void add(House a);

    /**
     * Gets the most expensive house in the priority queue list and removes it.
     *
     * @return The most expensive house in the list.
     */
    House getMostExpensive();

    /**
     * Clears the priority queue list.
     */
    void clear();

    /**
     * Gets the length of the priority queue list.
     *
     * @return The length of the list.
     */
    int getLength();

    /**
     * Checks if the priority queue list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    boolean isEmpty();
}
