import java.util.*;
import javax.swing.*;

public class PhoneBook {
    public static void main(String args[]) {

        AddressBook adb = new AddressBook();

        while (true) {
            String s = "Enter 1 for Add\n Enter 2 for search\n Enter 3 for delete\n Enter 4 for Exit.";

            String input = JOptionPane.showInputDialog(null, s);

            char in = input.charAt(0);

            switch (in) {
                case '1':
                    adb.addNew();
                    break;
                case '2':
                    String n1 = JOptionPane.showInputDialog(null, "Put Name for search");
                    adb.search(n1);
                    break;

                case '3':
                    String n2 = JOptionPane.showInputDialog(null, "Put Name for delete record");
                    adb.delete(n2);
                    break;

                case '4':
                    System.exit(0);
            }
        }
    }
}

class Person {
    String name;
    String address;
    String phoneNum;

    // Constructor
    public Person(String n, String a, String p) {
        this.name = n;
        this.address = a;
        this.phoneNum = p;
    }

    // print info
    public void print() {
        JOptionPane.showMessageDialog(null,
                "name: " + this.name + "\nAddress: " + this.address + "\nPhone: " + this.phoneNum);
    }

}

class AddressBook {
    ArrayList<Person> personList;

    // Constructor
    public AddressBook() {
        personList = new ArrayList<>();
    }

    public void addNew() {
        String nm = JOptionPane.showInputDialog("Put Name");
        String ad = JOptionPane.showInputDialog("Put Adress");
        String ph = JOptionPane.showInputDialog("Put Phone Number");

        Person p = new Person(nm, ad, ph);

        personList.add(p);
    }

    public void search(String n) {
        for (int i = 0; i < personList.size(); i++) {
            Person p = (Person) personList.get(i);
            if (p.name.equals(n)) {
                p.print();
            }
        }
    }

    public void delete(String n) {
        for (int i = 0; i < personList.size(); i++) {
            Person p = (Person) personList.get(i);
            if (p.name.equals(n)) {
                personList.remove(i);
            }
        }
    }
}