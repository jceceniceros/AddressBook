package helpers;

import beans.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contacts {
    private final FileManager fileManager;
    private final Map<String, Contact> contacts;

    public Contacts(FileManager fileManager) throws Exception {
        this.fileManager = fileManager;
        this.contacts = new HashMap<>();
        fileManager.readFile().forEach(contact -> this.contacts.put(contact.getPhone(), contact));
    }

    public void add(String name, String phone) {
        if (contacts.containsKey(phone)) return;
        contacts.put(phone, new Contact(name, phone));
    }

    public void remove(String phone) {
        contacts.remove(phone);
    }

    public List<Contact> toList() {
        var contactList = new ArrayList<Contact>();
        contacts.entrySet().forEach((entry) -> contactList.add(entry.getValue()));
        return contactList;
    }

    public void save() throws Exception {
        fileManager.writeFile(toList());
    }

}
