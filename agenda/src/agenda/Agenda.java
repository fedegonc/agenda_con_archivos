package agenda;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Agenda {

    public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
        int varmenu = 0;
        while (varmenu != 4) {

           
            System.out.println("1 - Nuevo contacto");
            System.out.println("2 - Listar contactos");
            System.out.println("3 - Accesar contacto");
            System.out.println("4 - Salir");

            while (true) {
                try {
                    input = new Scanner(System.in);
                    varmenu = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Informe um numero");
                }
            }

            switch (varmenu) {
                case 1:
                    agenda.crearContacto.main();
                    break;

                case 2:
                    agenda.listarContactos.main();
                    break;

                case 3:
                    agenda.accederContacto.main();
                    break;

            }

        }
    }
}
