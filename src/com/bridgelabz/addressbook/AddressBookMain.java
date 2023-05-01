package com.bridgelabz.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AddressBookMain extends Contacts{

	private static Scanner in = new Scanner(System.in);
	private static File file = new File("Addresses.txt");
	static List<Contacts> people = new ArrayList<>();

	AddressBookMain(String firstName, String lastName, String state, String zip, String phoneNumber,String email) {
		super(firstName, lastName,state,zip, phoneNumber, email);
	}

	public static void main(String[] args) throws IOException {
		readPeopleFromFile();
		showMainMenu();
	}

	private static void findPerson() throws IOException {
		System.out.println("1. Find with FirstName");
		System.out.println("2. Find with LastName");

		String choice;
		do {
			choice = in.nextLine();
			switch (choice) {
			case "1":
				findByFirstName();
				break;
			case "2":
				findByLastName();
				break;
			default:
				System.out.print("Choose 1 or 2: ");
			}
		} while (!choice.equals("1") && !choice.equals("2"));
		System.out.println();
		showMainMenu();
	}

	private static void findByLastName() {
		System.out.print("Enter surname: ");
		String surnameToFind = in.nextLine();
		int matches = 0;
		for(Contacts person : people) {
			if(person.getLastName().equals(surnameToFind)) {
				System.out.println(person);
				matches++;
			}
		}
		if(matches<=0) {
			System.out.println("There is no Person with this surname");
		}
	}

	private static void findByFirstName() {
		System.out.print("Enter name: ");
		String nameToFind = in.nextLine();
		int matches = 0;
		for(Contacts person : people) {
			if(person.getFirstName().equals(nameToFind)) {
				System.out.println(person);
				matches++;
			}
		}
		if(matches<=0) {
			System.out.println("There is no Person with this name ");
		}
	}

	private static void addPerson() throws IOException {

		System.out.println("Enter firstname: ");
		String firstName = in.nextLine();
		System.out.println("Enter Lastame: ");
		String lastName = in.nextLine();
		System.out.println("Enter phone number: ");
		String phoneNumber = in.nextLine();
		System.out.println("Enter email: ");
		String email = in.nextLine();
		System.out.println("Enter state: ");
		String state = in.nextLine();
		System.out.println("Enter zip: ");
		String zip = in.nextLine();

		Contacts person = new Contacts(firstName, lastName, phoneNumber, email, zip,state);
		addToFile(person);
		people.add(person);
		System.out.println("Added Person number: "  + person);
		System.out.println();
		showMainMenu();
	}

	private static void addToFile(Contacts person) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
			writer.write(person.getFirstName()+"\r\n" + person.getLastName() + "\r\n" + person.getPhoneNumber() + "\r\n" + person.getEmail() +
					"\r\n" + person.getState() + "\r\n\r\n" + person.getEmail() + "\r\n\r\n");
		} catch(IOException e) {
			System.out.println(e);
		}
	}

	private static boolean readPeopleFromFile() throws IOException {
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String FirstName = null;
			while((FirstName = reader.readLine()) != null) {
				Contacts person = new Contacts(FirstName + reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(),reader.readLine());
				people.add(person);        //adds Person to the list
				reader.readLine();
			}
			return true;
		}
		catch ( IOException e) {
			System.out.println(e);
		}
		return false;
	}

	private static void showMainMenu() throws IOException {
		System.out.println("1. Add Person");
		System.out.println("2. Find Person");
		System.out.println("3. Show all contacts");
		System.out.println("4. Close program");

		String choice;
		do {
			choice = in.nextLine();
			switch (choice) {
			case "1":
				addPerson();
				break;
			case "2":
				findPerson();
				break;
			case "3":
				System.out.println(people);
				System.out.println();
				showMainMenu();
				break;
			case "4":
				System.exit(0);
				break;
			default:
				System.out.println("Enter numer from 1 to 4");
			}
		}while(!choice.equals("4"));
	}
}
