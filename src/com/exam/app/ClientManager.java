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
        System.out.println("5. Search Industry");
        System.out.println("6. Search ID");
        System.out.println("7. Search Name");
        System.out.println("8. Remove Client");
        System.out.println("9. Save");
        System.out.println("0. Exit");

    }

    @Override
    public void performAction(String command) {
//        Scanner scanner = new Scanner(System.in);
        switch (command) {
            case "1":
                service.AddClient();
            case "9":

        }

    }
}
