package com.exam.app;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ClientService implements Service {
    private final Reader fileReader;
    private final Writer fileWriter;
    private static HashMap<Long, Client> clients;


    public ClientService(Reader fileReader, Writer fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        clients = new HashMap<Long, Client>();
//        clients = fileReader.readData();
//        setNextID();
    }

    public static HashMap<Long, Client> getClients() {
        return clients;
    }

    @Override
    public void AddClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data separated by commas:%n Name, Industry, ContactPerson, Revenue");
        while (true) {
            String[] input = scanner.nextLine().trim().split(",");
            if (input.length == 4) {
                String name = Validation.validateData(input[0].trim(), new Validation.validateName());
                Industry industry = Industry.valueOf(Validation.validateData(input[1].trim().toUpperCase(), new Validation.validateIndustry()));
                String contactPerson = Validation.validateData(input[2].trim(), new Validation.validateName());
                double revenue = Double.parseDouble(Validation.validateData(input[3].trim(), new Validation.validateRevenue()));
                Client client = new Client(name, industry, contactPerson, revenue);
                clients.put(client.getId(), client);
                break;
            } else
                System.out.println("Check if data is valid and separated by commas, then enter again");
        }
    }

    @Override
    public void EditClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID of client");
        String idInp = Validation.validateData(scanner.nextLine(), new Validation.validateID());
        if (getClients().isEmpty()) {
            System.out.println("There is no clients");
        } else if (getClients().containsKey(Long.parseLong(idInp))) {
            long id = Long.parseLong(idInp);
            Client client = getClients().get(id);
            System.out.println("Enter new name or press enter key to skip");
            String inputName = scanner.nextLine();
            if (!inputName.isEmpty()) {
                String name = Validation.validateData(inputName, new Validation.validateName());
                client.setName(name);
            }
            System.out.println("Enter new industry from list or press enter key to skip");
            Validation.validateIndustry.printIndustry();
            String inputIndustry = scanner.nextLine();
            if (!inputIndustry.isEmpty()) {
                Industry industry = Industry.valueOf(Validation.validateData(scanner.nextLine(), new Validation.validateIndustry()));
                client.setIndustry(industry);
            }
            System.out.println("Enter new contact person or press enter key to skip");
            String inputContactPerson = scanner.nextLine();
            if (!inputContactPerson.isEmpty()) {
                String contactPerson = Validation.validateData(scanner.nextLine(), new Validation.validateName());
                client.setContactPerson(contactPerson);
            }
            System.out.println("Enter new contact person or press enter key to skip");
            String inputRevenue = scanner.nextLine();
            if (!inputRevenue.isEmpty()) {
                double revenue = Double.parseDouble(Validation.validateData(scanner.nextLine(), new Validation.validateRevenue()));
                client.setRevenue(revenue);
            }
        } else {
            System.out.printf("Client with ID: %s doesn't exist", idInp);
        }
        scanner.close();
    }

    @Override
    public void RemoveClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID of client");
        String idInp = Validation.validateData(scanner.nextLine().trim(), new Validation.validateID());
        if (getClients().isEmpty()) {
            System.out.println("There is no clients");
        } else if (getClients().containsKey(Long.parseLong(idInp))) {
            clients.remove(Long.parseLong(idInp));
        } else {
            System.out.printf("Client with ID: %s doesn't exist", idInp);
        }
        scanner.close();
    }

    @Override
    public void ViewClients() {
        for (Map.Entry<Long, Client> entry : clients.entrySet()) {
            System.out.printf(entry.getValue().info());
            System.out.println();
        }
    }

    @Override
    public void SearchByIndustry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter industry from list to find clients: ");
        Validation.validateIndustry.printIndustry();
        Industry industry = Industry.valueOf(Validation.validateData(scanner.nextLine().trim().toUpperCase(), new Validation.validateIndustry()));
        for (Map.Entry<Long, Client> entry : clients.entrySet()) {
            if (entry.getValue().getIndustry().equals(industry)) {
                System.out.printf(entry.getValue().info());
                System.out.println();
            } else {
                System.out.println("There is no such clients for these industry");
            }
        }

    }

    @Override
    public void SearchByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client ID to find client: ");
        String idInp = Validation.validateData(scanner.nextLine(), new Validation.validateID());
        if (clients.containsKey(Long.parseLong(idInp))) {
            System.out.printf(clients.get(Long.parseLong(idInp)).info());
        } else {
            System.out.println("No client with this ID");
        }
    }

    @Override
    public void SearchByName() {

    }

    @Override
    public void Save() {

    }

}
