package com.mitzitec;

import java.util.Map;
import java.io.IOException;
import java.io.BufferedWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;


public class AddressBook {
    HashMap<String, String> agenda = new HashMap<>();
    public void Create(String numero, String nombre){

        if(!agenda.containsKey(numero)){ agenda.put(numero, nombre);
            System.out.println("Se agregó el contacto");
        }
        else{ System.out.println("Contacto ya existe");
        }
    }

    public void list(){
        if(agenda.entrySet().isEmpty()){
            System.out.println("Lista vacía, no hay contactos aún");
        }else{ for (Map.Entry<String, String> entry: agenda.entrySet()){
            System.out.println("\nTelefono: "+entry.getKey()+"      Nombre: "+entry.getValue()); }
        }
    }

    public void delete(String telefono){
        if(agenda.containsKey(telefono)){ agenda.remove(telefono);
        }

    }

    public void load() throws IOException {
        List fileLines = new ArrayList();

        String separator = FileSystems.getDefault().getSeparator();
        String filename = String.format( "src%main%agenda.csv", separator, separator);

        Path path = Paths.get(filename);
        fileLines = Files.readAllLines(path, Charset.defaultCharset());
        for (var li:fileLines) { var cont = li.toString().split(",");agenda.put(cont[0],cont[1]); }
    }

    public void save(){
        String separator = FileSystems.getDefault().getSeparator();
        String filename = String.format(
                "src%main%sagenda.csv",
                separator, separator
        );
        Path path = Paths.get(filename);

        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.defaultCharset())) {
            String line = null;
            for (var ag:agenda.entrySet()) { line = ag.getKey() + "," + ag.getValue();
                writer.write(line + System.lineSeparator());
            }
        }catch(Exception e){ }
    }
}
