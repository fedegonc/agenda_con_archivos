package agenda;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class crearContacto {

    public static void main() throws IOException {
        Scanner input = new Scanner(System.in);
        Path arquivo = Paths.get("C:\\Users\\usuarios\\Documents\\NetBeansProjects\\agenda\\src\\agenda\\contactos");

        DirectoryStream<Path> conteudo = Files.newDirectoryStream(arquivo);

        String contacto;
        String nombre = "";
        List<String> nomes = new ArrayList<String>();

        boolean flag = true;

        for (Path linha : conteudo) {

            contacto = linha.getFileName().toString();

            contacto = contacto.replace(".txt", "").replace(" ", "_");

            nomes.add(contacto);

        }

        

        
        System.out.println("Ingrese los datos del contacto");
        while (flag) {

            System.out.println("Ingrese el nombre del contacto: ");

            nombre = input.nextLine();
            nombre = nombre.replace(" ", "_");
            for (String nom : nomes) {

                if (nombre.equals(nom)) {
                    flag = true;

                } else {
                    flag = false;
                }

            }
            if (flag == true) {
                System.out.println("Nombre ya existente");
            }

        }

        
        System.out.println("Telefono: ");
        String telefono = new Scanner(System.in).next();

        System.out.println("Email: ");
        String email = new Scanner(System.in).next();

        System.out.println("Contacto agregado correctamente");
        
        
        
        Formatter saida = new Formatter("C:\\Users\\usuarios\\Documents\\NetBeansProjects\\agenda\\src\\agenda\\contactos\\" + nombre + ".txt");

        if (nombre.contains("_")) {
            nombre = nombre.replace("_", " ");
        }
        saida.format("Nombre: %s%nTelefono: %s%nEmail: %s", nombre, telefono, email);

        saida.close();
    }

}
