package Day06.Activity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ContactManager {
    Scanner sc = new Scanner(System.in);

    // Add Contact
    public void addContacts(HashMap<Integer, Contact> contacts, int n) {
        for (int i = 1; i <= n; i++) {
            try {
                System.out.println("\nEnter Details of Conatct " + i);

                System.out.print("Enter Contact Number : ");
                int number = sc.nextInt();
                sc.nextLine();

                if (contacts.containsKey(number)) {
                    System.out.println("Contact number already exists. Skipping contact.");
                    continue;
                }

                System.out.print("Enter Name : ");
                String name = sc.nextLine();

                System.out.print("Enter Email : ");
                String email = sc.nextLine();

                if (!(email.contains("@") && email.endsWith(".com"))) {
                    throw new InvalidEmailException("Invalid Email");
                }

                System.out.print("Enter Age : ");
                int age = sc.nextInt();

                if (age < 0) {
                    throw new AgeInvalidException("Invalid Age");
                }

                Contact contact = new Contact(number, name, email, age);
                contacts.put(number, contact);

                System.out.println("Contact Added Succesfully");

            } catch (InvalidEmailException e) {
                System.out.println(e.getMessage());
            } catch (AgeInvalidException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid Input");
                sc.nextLine();
            }
        }
    }

    // Remove Contact
    public void removeContactsByName(HashMap<Integer, Contact> contacts, String name) {
        boolean found = false;
        Iterator<Map.Entry<Integer, Contact>> iterator = contacts.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Contact> entry = iterator.next();

            if (entry.getValue().getName().equalsIgnoreCase(name)) {
                iterator.remove();
                found = true;
            }
        }

        if (found) {
            System.out.println("Contacts removed successfully for name: " + name);
        } else {
            System.out.println("No contacts found with name: " + name);
        }
    }

    //Edit Contact
    public void editContact(HashMap<Integer,Contact> contacts,int number,Contact contact){
        if(contacts.containsKey(number)){
            Contact existingContact = contacts.get(number);

            existingContact.setName(contact.getName());
            existingContact.setEmail(contact.getEmail());
            existingContact.setAge(contact.getAge());

            System.out.println("Contact updated successfully");
        }else{

            System.out.println("Contact number not found. Update failed.");
        }
    }

    //Display Contact
    public void displayContactThreshold(HashMap<Integer, Contact> contacts, int startAge, int endAge){
        if (contacts.isEmpty()) {
            System.out.println("No contacts available");
            return;
        }

        boolean found = false;

        for (Contact contact : contacts.values()) {

            if (contact.getAge() >= startAge && contact.getAge() <= endAge) {

                if (!found) {
                    System.out.println("Contacts with age between "  + startAge + " and " + endAge + ":");
                }

                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contacts found in the age range " + startAge + " to " + endAge);
        }
    }

    // 5. Display Contacts By Name Filter
    public void displayContactThreshold(HashMap<Integer, Contact> contacts, String nameFilter) {

        if (contacts.isEmpty()) {
            System.out.println("No contacts available");
            return;
        }

        boolean found = false;

        for (Contact contact : contacts.values()) {

            if (contact.getName().startsWith(nameFilter)) {

                if (!found) {
                    System.out.println("Contacts starting with '"  + nameFilter + "':");
                }

                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contacts found starting with '" + nameFilter + "'");
        }
    }
}
