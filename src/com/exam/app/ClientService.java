package com.exam.app;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class ClientService implements Service {
    private Reader fileReader;
    private Writer fileWriter;
    private HashMap<Integer, Client> clients;

    public ClientService(Reader fileReader, Writer fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.clients = new HashMap<Integer, Client>();
        clients = fileReader.readData();
    }

    public HashMap<Integer, Client> getClients() {
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
                Industry industry = Industry.valueOf(Validation.validateData(input[1], new Validation.validateIndustry()));
                String contactPerson = Validation.validateData(input[2], new Validation.validateName());
                double revenue = Double.parseDouble(Validation.validateData(input[3], new Validation.validateRevenue()));
                Client client = new Client(name, industry, contactPerson, revenue);
                break;
            } else
                System.out.println("Check if data is valid and separated by commas, then enter again");
        }
    }

    @Override
    public void EditClient() {

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
