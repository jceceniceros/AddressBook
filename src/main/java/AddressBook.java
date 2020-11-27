import controllers.AddressBookController;
import helpers.Contacts;
import helpers.FileManager;

public class AddressBook {

    public static void main(String[] args) {

        FileManager fileManager;
        try {
            fileManager = new FileManager();
        } catch(Exception e) {
            System.out.println("Ocurrió un error al configurar la aplicación");
            return;
        }

        Contacts contacts;
        try {
            contacts = new Contacts(fileManager);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al cargar los contactos");
            return;
        }

        var controller = new AddressBookController(contacts);

        var menu = new AddressBookMenu(controller);
        menu.mainLoop();

        try {
            contacts.save();
        } catch (Exception e) {
            System.out.println("Ocurrió un problema al guardar los contactos");
            return;
        }

    }

}
