import controllers.AddressBookController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddressBookMenu {

    private final Scanner input = new Scanner(System.in);

    private final AddressBookController controller;

    public AddressBookMenu(AddressBookController controller) {
        this.controller = controller;
    }

    private void showMenu() {
        System.out.println("\nSelecciona una opción:\n");
        System.out.println("1 - Ver contactos");
        System.out.println("2 - Agregar contacto");
        System.out.println("3 - Eliminar");
        System.out.println("0 - Guardar y salir");
        System.out.print("\nOpción < ");
    }

    public void mainLoop() {
        do {
            showMenu();
            try {
                var option = input.nextInt();
                if (option == 0) return;

                input.nextLine();
                switch (option) {
                    case 1:
                        controller.listContacts();
                        break;

                    case 2:
                        controller.addContact(input);
                        break;

                    case 3:
                        controller.removeContact(input);
                        break;

                    default:
                        throw new Exception("La opción no es válida");
                }
            } catch (InputMismatchException ime) {
                System.out.println("La opción no es válida");
                input.nextLine();
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }  while (true);
    }

}
