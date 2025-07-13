package Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utility {
    // Base Directory Path
    public String BASE_DIRECTORY;

    // Constructor
    public Utility() {
        BASE_DIRECTORY = loadPath();
    }

    /**
     * Gets the base directory path from the assets/path.txt file.
     *
     * @return The base directory path if the file exists, otherwise null.
     */
    private String loadPath() {
        // Load the path from the assets/path.txt file
        InputStream path = getClass().getResourceAsStream("/assets/path.txt");

        // If the file does not exist, return null
        if (path == null) {
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(path))) {
            // Read the line from the file and return it
            return reader.readLine();
        } catch (IOException e) {
            // Handle the IO Exception
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}