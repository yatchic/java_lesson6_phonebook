import java.util.*;

public class PhoneBook {
    private final HashMap<String, Set<String>> phoneBook = new HashMap<>();

    public void addContact(String name, String phoneNumber) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new HashSet<>());
        }
        phoneBook.get(name).add(phoneNumber);
    }

    public Set<String> getPhoneNumbers(String name) {
        Set<String> phoneNumbers = phoneBook.getOrDefault(name, new HashSet<>());
        TreeSet<String> sortedPhoneNumbers = new TreeSet<>(Collections.reverseOrder());
        sortedPhoneNumbers.addAll(phoneNumbers);
        return sortedPhoneNumbers;
    }

    public String getNameByPhoneNumber(String phoneNumber) {
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return "Номер телефона не найден";
    }


    public ArrayList<String> printSortedContacts() {
        Map<String, List<String>> sortedContacts = new TreeMap<>();

        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            List<String> sortedPhoneNumbers = new ArrayList<>(entry.getValue());
            sortedPhoneNumbers.sort(Collections.reverseOrder());
            sortedContacts.put(entry.getKey(), sortedPhoneNumbers);
        }

        List<Map.Entry<String, String>> contacts = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : sortedContacts.entrySet()) {
            contacts.add(new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue().get(0)));
        }

        contacts.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        ArrayList<String> allPhoneNumbers = new ArrayList<>();
        for (Map.Entry<String, String> contact : contacts) {
            System.out.println(contact.getKey() + ": " + sortedContacts.get(contact.getKey()));
            allPhoneNumbers.addAll(sortedContacts.get(contact.getKey()));
        }

        return allPhoneNumbers;
    }







}
