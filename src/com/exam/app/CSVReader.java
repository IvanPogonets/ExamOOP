package com.exam.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CSVReader implements Reader {
    @Override
    public void readData() {
        String path = "file.csv";
        try (
                Scanner scanner = new Scanner(new File(path))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                Client client = new Client(scanner.nextLine().split(","));
                ClientService.getClients().put(client.getId(), client);
            }
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

