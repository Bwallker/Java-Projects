package PhoneSearch.UI;

import PhoneSearch.*;
import java.util.*;

public class TextUserInterface {

    Scanner reader;

    public TextUserInterface() {
        this.reader = new Scanner(System.in);
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
        this.readInput();
    }

    private void readInput() {
        System.out.print("command: ");
        String input = this.reader.nextLine();
        while (true)  {
            if (input.equals("1")) {
                this.addNumber();
            } else if (input.equals("2")) {
                this.searchForNumber();
            } else if (input.equals("3")) {
                this.searchForNameByNumber();
            } else if (input.equals("4")) {
                this.addAdress();
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
        
    }
    private void searchForNumber() {
        
    }
    private void searchForNameByNumber() {
        
    }
    private void addAdress() {
        
    }
    private void searchForPersonalInfo() {
        
    }
    private void removePerson() {
        
    }
    private void filteredSearch() {
        
    }
}
