import java.util.*;

public class Main {



    public static void main(String[] args) {
        PhoneBook ph=new PhoneBook();
        ph.addContact("Юра","111");
        ph.addContact("Юра","222");
        ph.addContact("Юра","333");

        ph.addContact("Сеня","444");
        ph.addContact("Беня","555");
        ph.addContact("Сергей","666");
        ph.addContact("Витя","777");
        ph.addContact("Митя","888");


        ph.printSortedContacts();

    }

}
