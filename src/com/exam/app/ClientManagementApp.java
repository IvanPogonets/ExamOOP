package com.exam.app;

import java.util.Scanner;

import static com.exam.app.ClientManager.displayOptions;

public class ClientManagementApp {
    public static void main(String[] args) {
        Writer fileWriter = new CSVWriter();
        Reader fileReader = new CSVReader();
        Service service = new ClientService(fileReader, fileWriter);
        Manager manager = new ClientManager(service);
        System.out.println("Welcome to the Client Management System");
        boolean active = true;
        while (active) {
            if (ClientService.getClients().isEmpty()){
                System.out.println("Keep in mind that there is no clients base. Please enter the new client." );
            }
            displayOptions();
            System.out.println("Enter the command");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            manager.performAction(command);
            if (command.equals("9")){
                service.Save();
                active = false;
                scanner.close();
            }
        }
    }
}