package com.exam.app;

import java.util.HashMap;

public class Client {
    private final long id;
    private String name;
    private Industry industry;
    private String contactPerson;
    private double revenue;

    public Client(String[] input) {
        this.id = Long.parseLong(input[0]);
        this.name = input[1];
        this.industry = Industry.valueOf(input[2].toUpperCase());
        this.contactPerson = input[3];
        this.revenue = Double.parseDouble(input[4]);
    }


    public Client(String name, Industry industry, String contactPerson, double Revenue) {
        this.name = name;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.revenue = Revenue;
        this.id = getNextID();
    }


    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }


    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }



    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String info() {
        return "ID: " + id +
                " %n Name: " + name +
                " %n Department: " + industry +
                " %n Contact person: " + contactPerson +
                " %n Salary: " + revenue;
    }

    public String toString() {
        return id + "," + name + "," + industry + "," + contactPerson + "," + revenue;
    }

    //generate unique ID
    public long getNextID() {
        HashMap<Long, Client> clients = ClientService.getClients();
        long nextID;
        if (clients.isEmpty()) {
            nextID = 0;
        } else {
            long maxID = clients.keySet().stream().max(Long::compare).orElse(0L);
            nextID = maxID;
        }

        return ++nextID;
    }
}
