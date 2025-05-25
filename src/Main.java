import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook agenda = new AddressBook();
        Scanner sc = new Scanner(System.in);
        int opcion;

        agenda.load();  // Carga contactos al iniciar

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Borrar contacto");
            System.out.println("4. Guardar y salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  // limpiar buffer

            switch (opcion) {
                case 1:
                    agenda.list();
                    break;
                case 2:
                    System.out.print("Ingresa el número: ");
                    String numero = sc.nextLine();
                    System.out.print("Ingresa el nombre: ");
                    String nombre = sc.nextLine();
                    agenda.create(numero, nombre);
                    break;
                case 3:
                    System.out.print("Ingresa el número a eliminar: ");
                    String numEliminar = sc.nextLine();
                    agenda.delete(numEliminar);
                    break;
                case 4:
                    agenda.save();
                    System.out.println("Contactos guardados. Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }
}
