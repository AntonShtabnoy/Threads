package by.shtabnoy.threads.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ClientReader {

    private static final Logger LOGGER = LogManager.getLogger();

    public ArrayList<String> readClientData(String filename) {
        ArrayList<String> clientData = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
            while (scanner.hasNext()) {
                clientData.add(scanner.nextLine());
            }
            return clientData;
        } catch (FileNotFoundException e) {
            LOGGER.fatal(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
