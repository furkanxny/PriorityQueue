import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        PriorityQueueList pql = new PriorityQueueList();


        File houseFile = new File("houses.txt");
        //BufferedReader br = new BufferedReader();
        try {
            Scanner sc = new Scanner(houseFile);

            while (sc.hasNextLine()) {
                String name = sc.nextLine();
                int value = Integer.parseInt(sc.nextLine());
                House house = new House(name, value);
                pql.add(house);
                System.out.println("Added: " + house);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (!pql.isEmpty()) {
            System.out.println(pql.getMostExpensive());
        }


        PriorityQueueList copy = pql.deepCopy();
        System.out.println("Deep copy works: " + (copy.getLength() == pql.getLength()));
        System.out.println("Queue length: " + pql.getLength());


    }
}