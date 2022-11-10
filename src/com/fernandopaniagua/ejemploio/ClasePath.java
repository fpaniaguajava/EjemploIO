package com.fernandopaniagua.ejemploio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ClasePath {
	public static void main(String[] args) {
		//Creación de Path
		Path p1 = Paths.get("d:/CarpetaNueva/libros/");
		//Path p1 = Paths.get("/mnt/d/lines.txt");//Versión Unix/Linux
		System.out.println("Nombre del fichero:" + p1.getFileName());
		System.out.println("Nombre del padre:" + p1.getParent().getFileName());
		System.out.println("Número de elementos (carpetas) que forman parte del path:" + p1.getNameCount());
		
	}
}
