package PhoneSearch.Logic;

import PhoneSearch.*;
import java.util.*;

public class Person {

    private Set<String> numbers;
    private String address;
    private String name;

    public Person(String name, HashSet<String> numbers, String address) {
        this.name = name;
        this.numbers = numbers;
        this.address = address;
    }

    public Person(String name, HashSet<String> numbers) {
        this(name, numbers, null);
    }

    public Person(String name, String address) {
        this(name, null, address);
    }

    public Person(String name) {
        this(name, null, null);
    }

    public void addNumber(String number) {
        if (this.numbers == null) {
            this.numbers = new HashSet<String>();
        }
        this.numbers.add(number);
    }

    public void addAddress(String adress) {
        this.address = adress;
    }

    public String getAddress() {
        return this.address;
    }

    public String getName() {
        return this.name;
    }

    public Set getNumbers() {
        return this.numbers;
    }

    public String getAddressFromName(String name) {
        if (name.equals(this.name)) {
            return this.address;
        }
        return null;
    }

    public Set getNumberFromName(String name) {
        if (name.equals(this.name)) {
            return this.numbers;
        }
        return null;
    }

    public String getNameFromNumber(String searchedNumber) {
        for (String number : this.numbers) {
            if (number.equals(searchedNumber)) {
                return this.name;
            }
        }
        return null;
    }

    public Person searchForPersonalInfo(String name) {
        if (name.equals(this.name)) {
            return this;
        }
        return null;
    }

    public boolean checkName(String name) {
        if (name.equals(this.name)) {
            return true;
        }
        return false;
    }

    public String printNumbers() {
        for (String number : this.numbers) {
            System.out.println("   " + number);
        }
        return "";
    }

    public Set<String> NumbersThatContainString(String input) {
        Set<String> relevantNumbers = new HashSet<String>();
        for (String number : this.numbers) {
            if (number.contains(input)) {
                relevantNumbers.add(number);
            }
        }
        return relevantNumbers;
    }

    @Override
    public String toString() {
        String output = "  address: " + this.address + "\n" + "  phone numbers:" + "\n" + this.printNumbers();
        return output;
    }

    public String numbersToString(Set<String> input) {
        String output = "  phone numbers:\n";
        for (String number : input) {
            output += "   " + number + "\n";
        }
        return output;
    }
}
