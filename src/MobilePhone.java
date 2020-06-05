import java.util.ArrayList;

public static class MobilePhone {
    private static String myNumber;
    private static String rootUser;
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public MobilePhone(String myNumber, String user) {
        this.myNumber = myNumber;
        this.rootUser = user;
        this.contacts = contacts;
    }

    public void printContacts() {
        for (int i = 0; i < this.contacts.size(); i++) {
            System.out.println(this.contacts.get(i));
        }
    }

    public boolean addContact(Contact contact) {
        if (isContact(contact) >= 0) {
            System.out.println(contact.getName() + "Already exists in contacts");
            return false;
        }

        contacts.add(contact);
        return true;


    }

    public boolean updateContact(Contact contact, Contact newContact) {
        if (isContact(contact) < 0) {
            System.out.println(contact.getName() + "does not exist in contacts");
            return false;
        }
        int i = isContact(contact);
        contacts.set(i, newContact);
        System.out.println(contact.getName() + "was updated to" + newContact.getName());
        return true;


    }

    public boolean removeContact(Contact contact) {
        if (isContact(contact) < 0) {
            System.out.println(contact.getName() + "does not exist is contacts");
            return false;
        }
        int i = isContact(contact);
        contacts.remove(i);
        System.out.println(contact.getName() + "Removed from contacts");
        return true;
    }

    int isContact(Contact contact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contact.getName() == contacts.get(i).getName()) {
                return i;
            }
        }
        return -1;
    }

    public void printContacts() {
        System.out.println("Printing Contacts");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i).getName() + contacts.get(i).getNumber());
        }
    }
}