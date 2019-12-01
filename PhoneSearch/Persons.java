
import java.util.*;

public class Persons {

    private List<Person> persons;

    public Persons() {
        this.persons = new ArrayList<Person>();
    }

    /**
     *
     * @param person
     * @return
     */
    public boolean contains(Person person) {
        if (this.persons.contains(person)) {
            return true;
        }
        return false;
    }

    public void addPersonOrNumber(Person person, String number) {
        if (!this.persons.contains(person)) {
            this.persons.add(person);
        } else {
            for (Person p : this.persons) {
                if (person.equals(p)) {
                    p.addNumber(number);
                }
            }
        }
    }

    public void addPersonOrAddress(Person person, String address) {
        if (!this.persons.contains(person)) {
            this.persons.add(person);
        } else {
            for (Person p : this.persons) {
                if (person == p) {
                    p.addAddress(address);
                }
            }
        }
    }

    public String getAddressFromName(String name) {
        for (Person person : this.persons) {
            if (person.getName().equals(name)) {
                return person.getAddress();
            }
        }
        return null;
    }

    public Set<String> getNumberFromName(String name) {
        for (Person person : this.persons) {
            if (person.getName().equals(name)) {
                return person.getNumbers();
            }
        }
        return null;
    }

    public String getNameFromNumber(String searchedNumber) {
        for (Person person : this.persons) {
            Set<String> numbers = person.getNumbers();
            for (String number : numbers) {
                if (number.equals(searchedNumber)) {
                    return person.getName();
                }
            }
        }
        return null;
    }

    public Person searchForPersonalInfo(String name) {
        for (Person person : this.persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public void removePerson(String name) {
        Person toRemove = new Person(name);
        this.persons.remove(toRemove);
    }

    public Map<String, String> filteredSearch(String query) {
        Map<String, String> map = new HashMap<String, String>();
        for (Person person : this.persons) {
            String key = "";
            if (person.getName().contains(query)) {
                key += " " + person.getName() + "\n";
            }
            if (person.getAddress() != null && person.getAddress().contains(query)) {
                key += "  address: " + person.getAddress() + "\n";
            }
            Set<String> applicableNumbers = person.NumbersThatContainString(query);
            String numbersToString = person.numbersToString(applicableNumbers);
            key += numbersToString;
            map.put(person.getName(), key);
        }
        return map;
    }
}
