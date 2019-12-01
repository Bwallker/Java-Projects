package PhoneSearch.Logic;

import PhoneSearch.*;
import java.util.*;

public class Persons {

    private List<Person> persons;

    public Persons() {
        this.persons = new ArrayList<Person>();
    }
    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public String getAddressFromName(String name) {
        String adress = null;
        for (Person person : this.persons) {
            adress = person.getAddressFromName(name);
        }
        return adress;
    }

    public Set<String> getNumberFromName(String name) {
        Set<String> numbers = null;
        for (Person person : this.persons) {
            numbers = person.getNumberFromName(name);
        }
        return numbers;
    }

    public String getNameFromNumber(String searchedNumber) {
        String name = null;
        for (Person person : this.persons) {
            name = person.getNameFromNumber(searchedNumber);
        }
        return name;
    }

    public Person searchForPersonalInfo(String name) {
        Person target = null;
        for (Person person : this.persons) {
            target = person.searchForPersonalInfo(name);
        }
        return target;
    }

    public void removePerson(String name) {
        for (Person person : this.persons) {
            Boolean ifTrue = person.checkName(name);
            if (ifTrue) {
                this.persons.remove(person);
            }
        }
    }
    
    public Map<String,String> filteredSearch (String query) {
        Map<String, String> map = new HashMap<String, String>();
        for (Person person : this.persons) {            
            String key = "";
            if (person.getName().contains(query)) {
                key += " " + person.getName() + "\n";
            }
            if (person.getAddress().contains(query)) {
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