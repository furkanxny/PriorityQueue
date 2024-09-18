import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main class where the program runs.
 * Reads from house.txt file to populate the priority queue list.
 * Print the most expensive house in a while loop until the list is empty by removing the most expensive house.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Create a new priority queue list.
        PriorityQueueList pql = new PriorityQueueList();

        // Read the owner and value of the house from the house.txt file.
        File houseFile = new File("houses.txt");

        try {
            //create a scanner object to read from the houseFile.
            Scanner sc = new Scanner(houseFile);

            // Read and populate the priority queue list with the house objects.
            while (sc.hasNextLine()) {
                String name = sc.nextLine(); //read the next line and assign it to the name variable.
                int value = Integer.parseInt(sc.nextLine());
                House house = new House(name, value);
                pql.add(house);
                //System.out.println("Added: " + house);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Create a deep copy of the priority queue list.
        PriorityQueueList copyList = pql.deepCopy();
        // Check if deep copy works.
        System.out.println("True if the copy works: " + (copyList.getLength() == pql.getLength()));

        // Print the most expensive house and remove it from the list until the list is empty.
        while (!pql.isEmpty()) {
            System.out.println(pql.getMostExpensive());
        }

        // Check if the list is empty after removing all the houses.
        System.out.println("True if the list is empty after removing all the houses: " + pql.isEmpty());

        // Check if clear works.
        System.out.println("Length of copyList before clearing it: " + copyList.getLength());
        copyList.clear();
        System.out.println("Length of copyList after clearing it: " + copyList.getLength());


    }
}