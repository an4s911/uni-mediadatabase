import java.util.*;

/**
 * This class is a possible user interface for the Media Database
 * that uses the console to display the menu of command choices.
 */
public class MDConsoleIO {

    /**
     * A reference to the MediaDatabase object to be processed.
     * Globally available to the command-processing methods.
     */
    private MediaDatabase theDatabase = null;

    /** Scanner to read from input console. */
    private Scanner scIn = null;

    // Constructor
    /** Default constructor. */
    public MDConsoleIO() {
        scIn = new Scanner(System.in);
    }

    // Methods
    /**
     * Method to display the command choices and process user
     * commands.
     * 
     * @param theMediaDatabase A reference to the MediaDatabase
     *                         to be processed
     */
    public void processCommands(MediaDatabase theMediaDatabase) {
        String[] commands = {
                "Add Entry",
                "Get Details of Media",
                "Play Media",
                "List All Media",
                "List Media by Type",
                "Exit" };

        theDatabase = theMediaDatabase;
        int choice;
        do {
            for (int i = 0; i < commands.length; i++) {
                System.out.println("Select " + i + ": "
                        + commands[i]);
            }
            try {
                choice = scIn.nextInt(); // Read the next choice.
                scIn.nextLine(); // Skip trailing newline.
                switch (choice) {
                    case 0:
                        doAddEntry();
                        break;
                    case 1:
                        doGetDetails();
                        break;
                    case 2:
                        doPlayMedia();
                        break;
                    case 3:
                        doListAll();
                        break;
                    case 4:
                        doListByType();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("*** Invalid choice "
                                + choice
                                + " - try again!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("*** Incorrect data entry - "
                        + "enter an integer between 0 and "
                        + (commands.length - 1));
                scIn.nextLine(); // Discard bad input.
                choice = -1;
            }
        } while (choice != commands.length - 1);
        System.exit(0);
    }

    /**
     * Method to add an entry.
     * pre: The database exists.
     * post: A new media is added.
     */
    private void doAddEntry() {
        // complete this

        // Request Media type
        System.out.println("Enter media type (music/movie):");
        String type = scIn.nextLine().toLowerCase();
        if (type.equals("") || (!type.equals("movie") && !type.equals("music"))) {
            return;
        }

        System.out.println("Enter title: ");
        String title = scIn.nextLine();
        System.out.println("Enter location: ");
        String location = scIn.nextLine();
        System.out.println("Enter year: ");
        int year = scIn.nextInt();
        scIn.nextLine(); // dump \n
        System.out.println("Enter category: ");
        String category = scIn.nextLine();

        if (type.equals("music")) {
            System.out.println("Enter artist: ");
            String artist = scIn.nextLine();
            System.out.println("Enter number of songs: ");
            int numberOfSongs = scIn.nextInt();

            theDatabase.addEntry(new Music(title, location, year, category, artist, numberOfSongs));
        } else if (type.equals("movie")) {
            System.out.println("Enter director: ");
            String director = scIn.nextLine();
            System.out.println("Enter playing time: ");
            int playingTime = scIn.nextInt();

            theDatabase.addEntry(new Movie(title, location, year, category, director, playingTime));
        } else {
            System.out.println("Invalid type input!");
        }
    }

    /**
     * Method to get details of a media object.
     * pre: The database exists.
     * post: No changes made to the database.
     */
    private void doGetDetails() {
        // Request the title.
        System.out.println("Enter title");
        String theName = scIn.nextLine();
        if (theName.equals("")) {
            return; // Dialog was cancelled.
        }
        // Look up the name.
        Media m = theDatabase.lookupByTitle(theName);
        if (m != null) { // Title was found.
            System.out.println(m.toString());
        } else { // not found.
                 // Display the result.
            System.out.println(theName + " is not listed in the database");

        }
    }

    /**
     * Method to play a media object.
     * pre: The database exists.
     * post: No changes made to the database.
     */
    private void doPlayMedia() {
        // Request the title.
        System.out.println("Enter title");
        String theName = scIn.nextLine();
        if (theName.equals("")) {
            return; // Dialog was cancelled.
        }
        // Look up the name.
        Media m = theDatabase.lookupByTitle(theName);
        if (m != null) { // Title was found.
            m.playMedia();
        } else { // not found.
                 // Display the result.
            System.out.println(theName + " is not listed in the database");
        }
    }

    /**
     * Method to list all media objects in the database.
     * pre: The database has been loaded with data.
     * post: No changes to the database.
     */
    private void doListAll() {
        theDatabase.listAllMedia();
    }

    /**
     * Method to list media objects of a specific type.
     * pre: The database has been loaded with data.
     * post: No changes to the database.
     */
    private void doListByType() {
        // Request the type.
        System.out.println("Enter media type (music/movie/audiobook)");
        String type = scIn.nextLine();
        if (type.equals("") || (!type.equals("movie") && !type.equals("music"))) {
            return;
        }
        // validate type here

        theDatabase.listMediaByType(type);
    }

    public static void main(String args[]) {
        MDConsoleIO ui = new MDConsoleIO();
        MediaDatabase md = new MyMediaDatabase();
        ui.processCommands(md);
    }

}
