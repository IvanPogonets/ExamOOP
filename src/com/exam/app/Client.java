package com.exam.app;

import java.time.LocalDate;
import java.util.Date;

public class Client {
    private static long nextID = 0;
    private long id;
    private String name;
    private Industry industry;
    private String contactPerson;
    private double revenue;

    public Client(long id, String name, Industry industry, String contactPerson, double Revenue) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.revenue = Revenue;
    }
    public Client(String name, Industry industry, String contactPerson, double Revenue) {
        this.name = name;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.revenue = Revenue;
        this.id = nextID++;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String info() {
        return "ID: " + id +
                        "%n Name: " + name +
                        "%n Department: " + industry +
                        "%n Contact person: " + contactPerson +
                        "%n Salary: " + revenue;
    }

    public String toString() {
        return id + "," + name + "," + industry + "," + contactPerson + "," + revenue;
    }

    public static void setNextID(){
        if (ClientService.getClients().isEmpty()){
            nextID = 0;
        }
        else {
            int maxID = ClientService.getClients().keySet().stream()
                    .mapToInt(Integer::parseInt).max().orElse(0);
        }
    }
}
