import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private MobilePhone phone = new MobilePhone("555 555 5555", "david");

    public void main(String[] args) {
        boolean exit=false;
        printOptions();
        while (!exit){
            System.out.println("0 - Print Available Options");
            String opt = scanner.nextLine();
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
                    System.out.println("Enter contact name");
                    String name = scanner.nextLine();
                    System.out.println("Enter contact number");
                    String num = scanner.nextLine();
                    Contact contact = new Contact(name, num);
                    if (phone.addContact(contact)){
                        System.out.println("Added" + name + "to contacts");
                    } else{
                        System.out.println("Error:" + name + "Already in contacts");
                    }
                    break;
                case 4:
                    System.out.println("Enter contact name");
                    name = scanner.nextLine();
                    System.out.println("Enter contact number");
                    num = scanner.nextLine();
                    contact = new Contact(name, num);
                    if (phone.isContact(contact)>=0){
                        System.out.println("Added" + name + "to contacts");
                    } else{
                        System.out.println("Error:" + name + "Already in contacts");
                        break;
                    }
                    System.out.println("Enter new contact name");
                    String n_name = scanner.nextLine();
                    System.out.println("Enter new contact number");
                    String n_num = scanner.nextLine();
                    Contact n_contact = new Contact(n_name, n_num);
                    if (phone.isContact(n_contact)>=0){
                        System.out.println("Error:"+n_name+"Exists in contacts already");
                        break;
                    }

                    phone.updateContact(contact, n_contact);
                    break;
                case 5:
                    //removeContact();
                    break;
            }
        }
    }
    public static void printOptions(){
        System.out.println("0 - Print Options");
        System.out.println("1 - Quit");
        System.out.println("2 - Print Contacts");
        System.out.println("3 - New Contact");
        System.out.println("4 - Update Contacts");
        System.out.println("5 - Remove Contact");
        System.out.println("6 - Search Contacts");
    }