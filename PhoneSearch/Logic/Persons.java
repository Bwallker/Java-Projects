package PhoneSearch.Logic;

import PhoneSearch.*;
import java.util.*;

public class Persons {

    private List<Person> persons;

    public Persons() {
        this.persons = new ArrayList<Person>();
    }

    public String getAdressFromName(String name) {
        String adress = null;
        for (Person person : this.persons) {
            adress = person.getAdressFromName(name);
        }
        return adress;
    }

    public Set getNumberFromName(String name) {
        Set numbers = null;
        for (Person person : this.persons) {
            numbers = person.getNumberFromName(name);
        }
        return numbers;
    }

    public String getNameFromNumber(Set searchedNumbers) {
        String name = null;
        for (Person person : this.persons) {
            name = person.getNameFromNumber(searchedNumbers);
        }
        return name;
    }

    public List searchForPersonalInfo(String name) {
        List list = null;
        for (Person person : this.persons) {
            list = person.searchForPersonalInfo(name);
        }
        return list;
    }

    public void removePerson(String name) {
        for (Person person : this.persons) {
            Boolean ifTrue = person.checkName(name);
            if (ifTrue) {
                this.persons.remove(person);
            }
        }
    }
    
    public List<String> filteredSearch (String query) {
        List<String> list = new ArrayList<String>();
        for (Person person : this.persons) {            
            String name = person.getName();
            String adress = person.getAdress();
            if (name.contains(query)) {
                list.add(name);
            }
            if (adress.contains(query)) {
                list.add(adress);
            }
            list.add("person processed");
        }
        return list;
    }
}