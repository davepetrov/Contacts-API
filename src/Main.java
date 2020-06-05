import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone phone = new MobilePhone("555 555 5555", "david");
    private static boolean exit = false;

    public static void main(String[] args) {
        welcome();
        printOptions();

        while (!exit) {
            System.out.println("0 - Print Available Options");
            int opt = scanner.nextInt();
            scanner.nextLine();
            switch (opt) {
                case 0:
                    printOptions();
                    break;
                case 1:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                case 2:
                    phone.printContacts();
                    break;
                case 3:
                    System.out.println("Enter new contact name ");
                    String name = scanner.nextLine();
                    System.out.println("Enter new contact # ");
                    String num = scanner.nextLine();
                    Contact contact = new Contact(name, num);
                    if (phone.addContact(contact)) {
                        System.out.println("Added " + name + " to contacts");
                    } else {
                        System.out.println("Error: " + name + " Already in contacts");
                    }
                    break;
                case 4:
                    System.out.println("Enter old contact name");
                    name = scanner.nextLine();
                    System.out.println("Enter old contact # ");
                    num = scanner.nextLine();
                    contact = new Contact(name, num);
                    if (phone.isContact(contact) >= 0) {
                        System.out.println("Added " + name + " to contacts");
                    } else {
                        System.out.println("Sorry: " + name + " Already in contacts");
                        break;
                    }
                    System.out.println("Enter new contact name ");
                    String n_name = scanner.nextLine();
                    System.out.println("Enter new contact # ");
                    String n_num = scanner.nextLine();
                    Contact n_contact = new Contact(n_name, n_num);
                    if (phone.isContact(n_contact) >= 0) {
                        System.out.println("Error: " + n_name + " Exists in contacts already");
                        break;
                    }

                    phone.updateContact(contact, n_contact);
                    break;
                case 5:
                    System.out.println("Enter old contact name");
                    name = scanner.nextLine();
                    System.out.println("Enter old contact # ");
                    num = scanner.nextLine();
                    contact = new Contact(name, num);
                    if (phone.isContact(contact) < 0) {
                        System.out.println("Removed " + name + " from contacts");
                    } else {
                        System.out.println("Sorry: " + name + " is not a contact");

                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + opt);
            }
        }
    }

    private static void welcome(){
        System.out.println("What is root user's name? ");
        phone.setRootUser(scanner.nextLine());
        System.out.println("What is root user's #? ");
        phone.setMyNumber(scanner.nextLine());
        System.out.println("Welcome "+phone.getRootUser() + "to Contacts-API");
    }
    private static void printOptions() {
        System.out.println("0 - Print Options");
        System.out.println("1 - Quit");
        System.out.println("2 - Print Contacts");
        System.out.println("3 - New Contact");
        System.out.println("4 - Update Contacts");
        System.out.println("5 - Remove Contact");
        System.out.println("6 - Search Contacts");
    }
}