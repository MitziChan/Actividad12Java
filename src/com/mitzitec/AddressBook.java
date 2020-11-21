package main;

import java.util.HashMap;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Files;
import java.io.*;
import java.nio.file.FileSystems;


public class AddressBook {

    private HashMap<String,String> contacts = new HashMap<>();
    private String archivo = "C:\\Users\\marco\\IdeaProjects\\MitziAgenda\\src\\main\\agenda.csv";
    public void load() throws IOException {
        String separator = FileSystems.getDefault().getSeparator();

        String nombreDeArch = String.format("src%smain%sagenda.csv",separator,separator,separator,separator);
        Path path = Paths.get(nombreDeArch);

        ArrayList<String> lines = new ArrayList<>();

        if(!Files.exists(path)){
            File archivo = new File(String.valueOf(path));
            archivo.createNewFile();
        }

        lines = (ArrayList<String>) Files.readAllLines(path);
        for (var contact : lines){
            var infoContact = contact.split(",");
            contacts.put(infoContact[0].trim(),infoContact[1].trim());
        }
    }

    public void save() throws IOException {
        String separator = FileSystems.getDefault().getSeparator();
        String fileName = String.format("src%smain%sagenda.csv",separator,separator,separator,separator);
        Path path = Paths.get(fileName);

        ArrayList<String> saveContacts = new ArrayList<>();
        for (var contact : contacts.entrySet()){
            saveContacts.add(contact.getKey()+", "+ contact.getValue());
        }

        Files.write(path,saveContacts);
    }

    public void list() throws IOException {
        try{
            load();
            FileReader showContacts = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(showContacts);
            if (contacts.isEmpty()){
                System.out.println("No hay contactos");
            }else{
                for(var contact : contacts.entrySet()){
                    System.out.println(String.format("Contacto: %s %s",
                            contact.getKey(),contact.getValue()));
                }
            }
            buffer.close();
        } catch (FileNotFoundException e){
            System.out.println("Archivo no existe");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public void create(String nombre, String telefono) throws IOException {
        if (contacts.containsKey(telefono)){
            System.out.println("Este contacto ya existe");
        }else {
            contacts.put(telefono.trim(),nombre.trim());
            save();
            load();
            System.out.println("Contacto Creado");
        }
    }

    public void delete(String telefono) throws IOException {
        if (contacts.containsKey(telefono)){
            System.out.println("Contacto inexistente");
        }else{
            var p = contacts.remove(telefono);
            save();
            load();
            System.out.println("Contacto Eliminado");
        }

    }

}