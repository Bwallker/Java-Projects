

import java.util.*;

public class TextUserInterface {

    private Scanner reader;
    private Persons persons;

    public TextUserInterface() {
        this.reader = new Scanner(System.in);
        this.persons = new Persons();
    }

    public void start() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
        System.out.println();
        this.readInput();
    }

    private void readInput() {
        String input;
        while (true) {
            System.out.print("command: ");
            input = this.reader.nextLine();
            if (input.equals("1")) {
                this.addNumber();
            } else if (input.equals("2")) {
                this.searchForNumber();
            } else if (input.equals("3")) {
                this.searchForNameByNumber();
            } else if (input.equals("4")) {
                this.addAddress();
            } else if (input.equals("5")) {
                this.searchForPersonalInfo();
            } else if (input.equals("6")) {
                this.removePerson();
            } else if (input.equals("7")) {
                this.filteredSearch();
            } else if (input.equals("x")) {
                break;
            }
        }
    }

    private void addNumber() {
        String name = this.getName();
        String number = this.getNumber();
        Person person = new Person(name, number, null);
        this.persons.addPersonOrNumber(person, number);
        System.out.println();
    }

    private void searchForNumber() {
        String name = this.getName();
        Set<String> numbers = persons.getNumberFromName(name);
        if (numbers == null) {
            System.out.println(" not found");
        } else {
            for (String number : numbers) {
                System.out.println(" " + number);
            }
        }
        System.out.println();

    }

    private void searchForNameByNumber() {
        String number = this.getNumber();
        String name = this.persons.getNameFromNumber(number);
        if (name == null) {
            System.out.println(" not found");
        } else {
            System.out.println(" " + name);
        }
        System.out.println();
    }

    private void addAddress() {
        String name = this.getAddressName();
        String address = this.getAddress();
        Person person = new Person(name);
        person.addAddress(address);
        this.persons.addPersonOrAddress(person, address);
        System.out.println();
    }

    private void searchForPersonalInfo() {
        String name = this.getInfoName();
        Person person = this.persons.searchForPersonalInfo(name);
        this.printPerson(person);
        System.out.println();
    }

    private void removePerson() {
        String name = this.getName();
        this.persons.removePerson(name);
        System.out.println();
    }

    private void filteredSearch() {
        System.out.println("keyword (if empty, all listed): ");
        String keyword = this.reader.nextLine();
        System.out.println();
        ArrayList <HashMap<String, String>> maps = this.persons.filteredSearch(keyword);
        for (int i = 0; i < maps.size()-1; i++) {
            HashMap<String, String> index = maps.get(i);
            this.printInfo(index);
        }
        System.out.println();
    }

    private String getName() {
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        return name;
    }

    private String getNumber() {
        System.out.print("number: ");
        String number = this.reader.nextLine();
        return number;
    }

    private String getAddressName() {
        System.out.print("whose address: ");
        String name = this.reader.nextLine();
        return name;
    }

    private String getAddress() {
        System.out.print("street: ");
        String address = this.reader.nextLine();
        System.out.print("city: ");
        address += " " + this.reader.nextLine();
        return address;
    }
    
    private String getInfoName() {
        System.out.print("whose information: ");
        String info = reader.nextLine();
        return info;
    }

    private void printPerson(Person person) {
        if (person == null) {
            System.out.println(" not found");
        } else if (person.getAddress() == null && person.getNumbers().isEmpty()) {
            System.out.println("  address unknown");
            System.out.println("  phone number not found");
        } else if (person.getAddress() == null) {
            System.out.println("  address unknown");
            System.out.println(person.numbersToString(person.getNumbers()));
        } else if (person.getNumbers().isEmpty()) {
            System.out.println("  address: " + person.getAddress());
            System.out.println("  phone number not found");
        } else {
            System.out.println(person);
        }
    }
    private void printInfo(HashMap<String, String> input) {
        for (String key : input.keySet()) {
            String info = input.get(key);
            System.out.println(" " + key);
            System.out.println(info);
        }
    }
}