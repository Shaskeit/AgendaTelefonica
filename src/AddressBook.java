import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    private HashMap<String, String> contactos = new HashMap<>();
    private final String archivo = "contactos.txt";

    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    contactos.put(partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo.");
        }
    }

    public void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, String> entrada : contactos.entrySet()) {
                bw.write(entrada.getKey() + "," + entrada.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");
        }
    }

    public void list() {
        System.out.println("Contactos:");
        for (Map.Entry<String, String> entrada : contactos.entrySet()) {
            System.out.println(entrada.getKey() + " : " + entrada.getValue());
        }
    }

    public void create(String numero, String nombre) {
        contactos.put(numero, nombre);
        System.out.println("Contacto guardado.");
    }

    public void delete(String numero) {
        if (contactos.containsKey(numero)) {
            contactos.remove(numero);
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("No se encontró el número.");
        }
    }
}
