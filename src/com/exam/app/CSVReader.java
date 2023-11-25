package com.exam.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader implements Reader {
    @Override
    public void readData() {
        String path = "file.csv";
        try (
                Scanner scanner = new Scanner(new File(path))) {
            //skip first line
            scanner.nextLine();
            while (scanner.hasNextLine()) {

                Client client = new Client(scanner.nextLine().split(","));        //get array of data from string as an argument for constructor of client
                ClientService.getClients().put(client.getId(), client);
            }
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

