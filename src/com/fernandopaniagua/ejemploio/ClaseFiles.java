package com.fernandopaniagua.ejemploio;

import java.io.IOException;
import java.nio.file.CopyOption;
//Files ofrece métodos estáticos de manejo de archivos --> Funciona sobre instancias Path
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.function.Predicate;


public class ClaseFiles {
	public static void main(String[] args) {
		Path path1 = Paths.get("D:/CarpetaNueva/libros");
		//Permite saber si un Path existe
		System.out.println("Existe:" + Files.exists(path1));
		//Permite saber si un Path NO existe
		System.out.println("No Existe:" + Files.notExists(path1));
	
		
		Path path2 = Paths.get("D:/CarpetaNueva/lineas.txt");
		//Borrado SIN verificación de existencia
		try {
			System.out.println("Intento borrar, si no existe el fichero provoca error:");
			Files.delete(path2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Borrado CON verificación de existencia
		try {
			System.out.println("Intento borrar, si no existe el fichero no pasa nada:");
			Files.deleteIfExists(path2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Copia y Move (cortar+pegar) de fichero
		Path path3 = Paths.get("D:/CarpetaNueva/lines.txt");
		try {
			Files.copy(path3, Paths.get("D:/CarpetaNueva/copia.txt"), StandardCopyOption.REPLACE_EXISTING);
			Files.move(Paths.get("D:/CarpetaNueva/copia.txt"), Paths.get("D:/copiamovida.txt"), StandardCopyOption.REPLACE_EXISTING); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Lectura del contenido de un fichero
		try {
			Path path4 = Paths.get("D:/CarpetaNueva/lines.txt");
			Files.readAllLines(path4).forEach(linea -> {
				System.out.println("Linea:" + linea);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Creación de directorios
		try {
			Files.createDirectories(Paths.get("D:/CarpetaNueva/otraubicacion"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Lectura de contenidos de carpetas mediante Streams
		Path path5 = Paths.get("D:/CarpetaNueva/libros");
		try {
			Files.newDirectoryStream(path5).forEach(elemento -> {
				System.out.println(elemento.getFileName());
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Búsqueda de ficheros con Filter
		Path raiz = Paths.get("D:/CarpetaNueva/libros");
		//Con clase anónima
		try {
			Files.list(raiz)
			.filter(new Predicate<Path>() {
				@Override
				public boolean test(Path f) {
					return f.getFileName().toString().contains("PHP");
				}})
			.forEach(libro -> {
				System.out.println("LIBRO DE PHP:" + libro);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Con lambda
		try {
			Files.list(raiz)
			.filter(path->(path.getFileName().toString().contains("Perl")))
			.forEach(libro -> {
				System.out.println("LIBRO DE Perl:" + libro);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
