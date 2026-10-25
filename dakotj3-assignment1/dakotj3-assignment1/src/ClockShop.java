import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that manages the collection of clock objects, files, sorting, searching ,
 * retrieving, sorting , updating, and writing to the files.
 *
 * @ author dakotj3
 * @ autumn 2026
 */

public class ClockShop {

    //holds the clock in the shop
    private ArrayList<Clock> myClocks;

    //creates an empty Clockshop collection
    public ClockShop() {
        myClocks = new ArrayList<>();
    }

    /**
     * Fills the clock shop reading clock times line by line
     *
     * @param theInputFileName the name of file that is read from
     * @throws FileNotFoundException if input can not be found
     */
    public void fillClockShop(final String theInputFileName) {
        try {
            File file = new File(theInputFileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");

                int hour = Integer.parseInt(parts[0]);
                int minute = Integer.parseInt(parts[1]);
                int second = Integer.parseInt(parts[2]);

                myClocks.add(new Clock(hour, minute, second));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    //sorts the clocks in order
    public void sortClocks() {
        for (int i = 0; i < myClocks.size() - 1; i++) {
            for (int j = 0; j < myClocks.size() - 1 - i; j++) {
                Clock current = myClocks.get(j);
                Clock next = myClocks.get(j + 1);
                if (current.compareTo(next) > 0) {
                    myClocks.set(j, next);
                    myClocks.set(j + 1, current);
                }
            }
        }
    }

    /**
     * finds the index of clock
     *
     * @param theClock searches for clock
     * @return first match or -1 if match can not be found
     */
    public int findClock(final Clock theClock) {
        int index = -1;
        for (int i = 0; i < myClocks.size(); i++) {
            if (myClocks.get(i).equals(theClock)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * retrieves clock at index
     * @param theIndex index of clock to retrieve
     * @return clock object at given index
     * @throws if index is out of bounds
     */
    public Clock getClock(final int theIndex) {
        if (theIndex < 0 || theIndex >= myClocks.size()) {
            throw new IllegalArgumentException("Index out of bounds: " + theIndex);
        }
        return myClocks.get(theIndex);
    }

    /**
     * replaces clock with new clock
     * @param theClock new clock object
     * @param theIndex index of clock to replace
     * @throws if index is out of bounds
     */
    public void setClock(final Clock theClock, final int theIndex) {
        if (theIndex < 0 || theIndex >= myClocks.size()) {
            throw new IllegalArgumentException("Index out of bounds: " + theIndex);
        }
        myClocks.set(theIndex, theClock);
    }

    /**
     * returns string of all clocks in shop
     * @return string containing each clock on a new line
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < myClocks.size(); i++) {
            result += myClocks.get(i).toString() + "\n";
        }
        return result;
    }

    /**
     * adds a new clock to the shop
     * @param theClock to add
     */
    public void addClock(final Clock theClock) {
        myClocks.add(theClock);
    }

    /**
     * writes all clocks in the shop to the file
     * @param theFilename the name of the file to write to
     */
    public void writeClocksToFile(final String theFilename) {
        try {
            PrintWriter writer = new PrintWriter(new File(theFilename));
            writer.print(this.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
