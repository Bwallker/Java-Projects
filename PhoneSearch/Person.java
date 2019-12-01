

import java.util.*;

public class Person implements Comparable<Person> {

    private Set<String> numbers;
    private String address;
    private String name;

    public Person(String name, String number, String address) {
        this.numbers = new HashSet<String>();
        this.name = name;
        this.numbers.add(number);
        this.address = address;
    }

    public Person(String name, String number) {
        this(name, number, null);
    }

    public Person(String name) {
        this.numbers = new HashSet<String>();
        this.name = name;
        this.address = null;
    }

    public void addNumber(String number) {
        this.numbers.add(number);
    }

    public void addAddress(String address) {
        this.address = address;
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

    public Set<String> getNumberFromName(String name) {
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
    @Override
    public int compareTo(Person secondPerson) {
        int outcome = this.name.compareTo(secondPerson.getName());
        return outcome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
    
    
}
