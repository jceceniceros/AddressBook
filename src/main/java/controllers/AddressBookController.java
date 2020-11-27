package controllers;

import helpers.Contacts;

import java.util.Scanner;

public class AddressBookController {

    private final Contacts contacts;

    public AddressBookController(Contacts contacts) {
        this.contacts = contacts;
    }

    public void listContacts() {
        System.out.println("\nLista de contactos:");

        contacts.toList().forEach(System.out::println);

        System.out.print("\n");
    }

    public void addContact(Scanner input) {
        System.out.println("\nAgregar nuevo contacto:");

        System.out.print("Nombre del contacto: ");
        String name = input.nextLine();

        System.out.print("Teléfono del contacto: ");
        String phone = input.next();
        input.nextLine();

        contacts.add(name, phone);

        System.out.println("\nContacto agregado\n");
    }

    public void removeContact(Scanner input) {
        System.out.print("\nTeléfono del contacto a eliminar: ");
        String phone = input.next();
        input.nextLine();

        contacts.remove(phone);

        System.out.println("\nContacto eliminado\n");
    }

}
