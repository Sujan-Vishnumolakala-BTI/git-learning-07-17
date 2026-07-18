package Day06.Activity;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Contact> contacts = new HashMap<>();

        ContactManager manager = new ContactManager();

        // 1. Enter size → Call addContacts
        System.out.print("Enter size: ");
        int n = sc.nextInt();

        manager.addContacts(contacts, n);


        // 2. Enter name → Call removeContactsByName
        sc.nextLine();

        System.out.print("Enter name to remove: ");
        String removeName = sc.nextLine();

        manager.removeContactsByName(contacts, removeName);


        // 3. Enter number, name, email, age → Create Contact object → Call editContact
        System.out.print("Enter contact number to edit: ");
        int number = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        Contact contact = new Contact(number, name, email, age);

        manager.editContact(contacts, number, contact);


        // 4. Enter ageThreshold → Call displayContactThreshold(int)
        System.out.print("Enter start age threshold: ");
        int startAge = sc.nextInt();

        System.out.print("Enter end age threshold: ");
        int endAge = sc.nextInt();

        manager.displayContactThreshold(contacts, startAge, endAge);


        // 5. Enter nameFilter → Call displayContactThreshold(String)
        sc.nextLine();

        System.out.print("Enter name filter: ");
        String nameFilter = sc.nextLine();

        manager.displayContactThreshold(contacts, nameFilter);


        sc.close();
    }
}