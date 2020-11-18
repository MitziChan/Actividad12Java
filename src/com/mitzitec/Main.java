package com.mitzitec;

import java.util.Scanner;
import java.io.IOException;


public class Main {  Scanner entrada = new Scanner(System.in);

    int menu;
    String caso1, caso2, caso3;
    boolean continue_software = true; AddressBook m = new AddressBook();

    public static void main(String[] args) throws IOException {
        Main d1 = new Main(); d1.Menu();
    }

    public void Menu() throws IOException{

        do{
            System.out.println("");
            System.out.println("¡Bienvenido a la agenda" + "\n ¿Qué desea hacer?:" + "\n 1. Ver lista de contactos" + "\n 2. Crear nuevo contacto" + "\n 3. Eliminar contacto existente");
            System.out.println("");
            System.out.print("Digite la opción: ");
            menu = entrada.nextInt();
            switch (menu){
                case 1:
                    System.out.println("Contactos: ");
                    m.list();
                    break;

                case 2:
                    System.out.println("");
                    System.out.println("Digite el número: ");
                    caso1= entrada.next();
                    System.out.println("");
                    System.out.println("Digite el nombre: ");
                    caso2= entrada.next();
                    m.Create(caso1,caso2);
                    m.load();
                    m.save();
                    break;

                case 3:
                    System.out.println("");
                    System.out.println("Digite el numero para eliminar: ");
                    caso3=entrada.next();
                    m.delete(caso3);
                    m.save();
                    m.load();
                    break;

                default:
                    System.out.println("");
                    System.out.println("Opción no valida");
                    continue_software = false;
                    break;

            }

        }while (continue_software);

    }

}