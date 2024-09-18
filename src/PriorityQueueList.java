public class PriorityQueueList implements PriorityQueue {

    private Node head;
    private int length;


    public PriorityQueueList() {
        this.length = 0;
        this.head = null;
    }

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

    @Override
    public void clear() {
        head = null;
        length = 0;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        } else
            return false;
    }


    public PriorityQueueList(PriorityQueueList other) {
        this.length = 0;
        this.head = null;
        Node newNode = other.head;
        while (newNode != null) {
            this.add(newNode.house.deepCopy());
            newNode = newNode.next;
        }
    }

    public PriorityQueueList deepCopy() {
        return new PriorityQueueList(this);
    }

    private class Node {
        House house;
        Node next;

        Node(House house) {
            this.house = house;
            this.next = null;
        }
    }
}
