
package agenda;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class listarContactos {
    public static void main() throws IOException {
		
        String contacto;
        
		Path arquivo = Paths.get("C:\\Users\\usuarios\\Documents\\NetBeansProjects\\agenda\\src\\agenda\\contactos");
		
		if(Files.exists(arquivo)) {
			DirectoryStream<Path> conteudo = Files.newDirectoryStream(arquivo);
			
			for(Path linha:conteudo) {
                            contacto = linha.getFileName().toString();
                            contacto = contacto.replace(".txt", "").replace("_", " ");
                            System.out.println(contacto);
                        }
                        
                                
                            
		}else {
			System.out.println("Diretorio no encontrado");
		}
		
	}
}
