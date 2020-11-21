package main;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Main p = new Main();
        p.opcion();
    }

    Scanner sc = new Scanner(System.in);
    int op;
    boolean continue_software = true;
    AddressBook contact = new AddressBook();

    public void showMenu(){
        System.out.println("¡Bienvenido a la agenda! ¿Qué desea hacer?:\n 1. Ver lista de contactos\n 2. Crear nuevo contacto\n 3. Eliminar contacto existente");
    }

    public void opcion() throws IOException {

        do{
            showMenu();
            System.out.print("Digite la opción que desea: ");
            op = sc.nextInt();
            switch (op){
                case 1:
                    showContact();
                    break;

                case 2:
                    addContact();
                    break;

                case 3:
                    removeContact();
                    break;

                default:
                    System.out.println("Opción no valida");
                    continue_software = false;
                    break;
            }

        }while (continue_software);

    }

    private void showContact() throws IOException {
        contact.list();
    }

    private void addContact() throws IOException {
        System.out.print("¿Cuál es el nombre?: ");
        var name_person = sc.next();
        System.out.print("¿Cuál es el numero?: ");
        var phone_person = sc.next();
        contact.create(name_person,phone_person);
    }

    private void removeContact() throws IOException {
        System.out.print("Digíte el numero para eliminar: ");
        var remove_person = sc.next();
        contact.delete(remove_person);
    }


}