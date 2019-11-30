package PhoneSearch.Logic;
import PhoneSearch.*;
import java.util.*;
public class Person {
    private Set<String> numbers;
    private String adress;
    private String name;
    public Person (String name) {
        this.name = name;
        this.numbers = new HashSet<String>();
    }
    public void addNumber(String number) {
        if (!this.numbers.contains(number)) {
            this.numbers.add(number);
        }
    }
    public void addAdress(String adress) {
        this.adress = adress;
    }
    public String getAdress() {
        return this.adress;
    }
    public String getName() {
        return this.name;
    }
    public Set getNumbers() {
        return this.numbers;
    }
    public String getAdressFromName(String name){
        if (name.equals(this.name)) {
            return this.adress;
        }
        return null;
    }
    public Set getNumberFromName(String name) {
        if(name.equals(this.name)) {
            return this.numbers;
        }
        return null;
    }
    public String getNameFromNumber(Set searchedNumbers) {
        if(searchedNumbers == this.numbers) {
            return this.name;
        }
        return null;
    }
    public List searchForPersonalInfo(String name) {
        List list = new ArrayList();
        if(name.equals(this.name)) {
            list.add(this.numbers);
            list.add(this.adress);
        }
        if(list.isEmpty()) {
            return null;
        }
        return list;
    }
    public boolean checkName(String name) {
        if(name.equals(this.name)) {
            return true;
        }
        return false;
    }
}
