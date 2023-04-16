package com.bridgelabz.addressbook;
import java.util.Scanner;
public class AddressBookMain {
	public static void main(String[] args) {

		AddressBookSystem addressBook = new AddressBookSystem();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Enter 1 to add Address Book");
			System.out.println("Enter 2 to display Address Book");
			System.out.println("Enter 3 to open Address Book");
			System.out.println("Enter 4 to add contact");
			System.out.println("Enter 5 to search Contacts By City Or State");
			System.out.println("Enter 6 to search & view Contacts By City");
			System.out.println("Enter 7 to search Contacts By State");
			System.out.println("Enter 8 to display all contacts");
			System.out.println("Enter 9 to edit a contact");
			System.out.println("Enter 10 to delete a contact");
			System.out.println("Enter 11 to exit Address Book");

			System.out.println("Enter 0 to exit");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 0:
				System.out.println("Exiting Address Book");
				System.exit(0);
			case 1:
				addressBook.addAddressBook();
				break;
			case 2:
				addressBook.displayAddressBooks();
				break;
			case 3:
				addressBook.openAddressBook();
				break;
			case 4:
				addressBook.addContacts();
				break;
			case 5:
				addressBook.searchContactsByCityOrState();

				break;
			case 6:
				addressBook.viewPersonByCity();
				break;
			case 7:
				addressBook.viewContactsByState();
				break;
			case 8:
				addressBook.displayContacts();
				break;
			case 9:
				System.out.println("Enter the first name of the contact to edit:");
				String firstName = scanner.nextLine();
				System.out.println("Enter the last name of the contact to edit:");
				String lastName = scanner.nextLine();
				addressBook.editContact(firstName, lastName);
				break;
			case 10:
				System.out.println("Enter the first name of the contact to delete:");
				String firstName1 = scanner.nextLine();
				System.out.println("Enter the last name of the contact to delete:");
				String lastName1 = scanner.nextLine();
				addressBook.deleteContact(firstName1, lastName1);
				break;
			case 11:
				System.exit(0);
			default:
				System.out.println(" Contact details not found. ");
			}
		}
	}
}