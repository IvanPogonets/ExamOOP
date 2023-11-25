package com.exam.app;

public class ClientManager implements Manager {
    private Service service;

    public ClientManager(Service service) {
        this.service = service;
    }

    public static void displayOptions() {
        System.out.println("1. Add Client ");
        System.out.println("2. Update Client");
        System.out.println("3. View Clients");
        System.out.println("4. Remove Client");
        System.out.println("5. Search by industry");
        System.out.println("6. Search by ID");
        System.out.println("7. Search by Name");
        System.out.println("8. Save");
        System.out.println("9. Exit");

    }

    @Override
    public void performAction(String command) {
        switch (command) {
            case "1":
                service.AddClient();
                break;
            case "2":
                service.EditClient();
                break;
            case "3":
                service.ViewClients();
                break;
            case "4":
                service.RemoveClient();
                break;
            case "5":
                service.SearchByIndustry();
                break;
            case "6":
                service.SearchByID();
                break;
            case "7":
                service.SearchByName();
                break;
            case "8":
                service.Save();
                break;
            case "9":
                break;
            default:
                System.out.println("Wrong command. Please enter command from list");
        }

    }
}
