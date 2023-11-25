package com.exam.app;

import java.util.Date;
import java.util.HashMap;
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
                String name = Validation.validateData(input[0], new Validation.validateName());
//                Industry industry = Industry.valueOf(Validation.validateData(input[1], new Validation.validateIndustry()));
                String contactPerson = Validation.validateData(input[2], new Validation.validateName());
                double revenue = Double.parseDouble(Validation.validateData(input[3], new Validation.validateRevenue()));
//                Client client = new Client(name, industry, contactPerson, revenue);
                break;
            } else
                System.out.println("Check if data is valid and separated by commas, then enter again");
        }
    }

    @Override
    public void EditClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID of client");
        String Id = Validation.validateData(scanner.nextLine(), new Validation.validateID());
       if (getClients().isEmpty()){
           System.out.println("There is no clients");
       }
        else if (getClients().containsKey(Long.parseLong(Id))) {
            System.out.println("Enter new name or press enter key to skip");
            String name = Validation.validateData(scanner.nextLine(), new Validation.validateName());
            System.out.println("Enter new industry from list or press enter key to skip");
            Validation.validateIndustry.printIndustry();
            Industry industry = Industry.valueOf(Validation.validateData(scanner.nextLine(), new Validation.validateIndustry()));
            System.out.println("Enter new contact person or press enter key to skip");
            String contactPerson = Validation.validateData(scanner.nextLine(), new Validation.validateName());
            double revenue = Double.parseDouble(Validation.validateData(scanner.nextLine(), new Validation.validateRevenue()));
            Client client = new Client(name, industry, contactPerson, revenue);
        }
        else
            System.out.printf("Client with ID: %s doesn't exist", Id);
    }

    @Override
    public void RemoveClient(long id, Date date) {

    }

    @Override
    public void ViewClients() {

    }

    @Override
    public void SearchIndustry() {

    }

}
