package agenda;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class accederContacto {

    public static void main() throws IOException {
        Scanner input = new Scanner(System.in);
        Path arquivo = Paths.get("C:\\Users\\usuarios\\Documents\\NetBeansProjects\\agenda\\src\\agenda\\contactos");
        DirectoryStream<Path> conteudo = Files.newDirectoryStream(arquivo);

        String contacto;
        String nombre = "";
        List<String> nomes = new ArrayList<String>();

        boolean f = true;

        for (Path linha : conteudo) {

            contacto = linha.getFileName().toString();

            contacto = contacto.replace(".txt", "").replace(" ", "_");

            nomes.add(contacto);

        }

        while (f) {

            System.out.println("Ingrese el nombre del contacto: ");

            nombre = input.nextLine();
            nombre = nombre.replace(" ", "_");

            for (String nom : nomes) {

                if (nombre.equalsIgnoreCase(nom)) {
                    nombre = nom;
                    f = false;
                    break;
                }

            }
            if (f == true) {
                System.out.println("Nombre no encontrado");
            }

        }

        Scanner salida = new Scanner(Paths.get("C:\\Users\\usuarios\\Documents\\NetBeansProjects\\agenda\\src\\agenda\\contactos\\" + nombre + ".txt"));

        while (salida.hasNext()) {
            System.out.printf("%s%n", salida.next());
        }

    }
}
