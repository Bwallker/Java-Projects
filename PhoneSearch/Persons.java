
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
                if (person.getName().equals(p.getName())) {
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

    public HashMap<String, String> filteredSearch(String query) {
        HashMap<String, String> map = new HashMap<String, String>();
        Collections.sort(this.persons);
        for (Person person : this.persons) {
            String info = "";
            String name = person.getName();
            Set<String> numbers = person.getNumbers();
            String address = person.getAddress();
            if (name.contains(query) && address != null && !numbers.isEmpty()) {
                info += " " + name + "\n";
                info += "  address: " + address + "\n";
                info += person.numbersToString();
                map.put(name, info);
            } else if (name.contains(query) && address != null) {
                info += " " + name + "\n";
                info += "  address: " + address + "\n";
                info += "phone number not found \n";
                map.put(name, info);
            } else if (name.contains(query) && !numbers.isEmpty()) {
                info += " " + name + "\n";
                info += "  address unknown \n";
                info += person.numbersToString();
                map.put(name, info);
            } else if (name.contains(query)) {
                info += " " + name + "\n";
                info += "  address unknown \n";
                info += "phone number not found \n";
                map.put(name, info);
            } else if (address != null && address.contains(query) && !numbers.isEmpty()) {
                info += " " + name + "\n";
                info += "  address: " + address + "\n";
                info += person.numbersToString();
                map.put(name, info);
            } else if (address != null && address.contains(query)) {
                info += " " + name + "\n";
                info += "  address: " + address + "\n";
                info += "phone number not found \n";
                map.put(name, info);
            }
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }
}
