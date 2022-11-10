package com.fernandopaniagua.ejemploio;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class ClaseFile {

	public static void main(String[] args) {
		//Crear un fichero
		File fichero = new File("d:/ficherocreadoubuntu.log");
		try {
			boolean creado = fichero.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Eliminación de fichero
		boolean eliminado = fichero.delete();
		//Obtención del contenido de un directorio discriminado entre ficheros y directorios
		File carpeta = new File("d:/");
		File[] ficheros = carpeta.listFiles();
		for(File f : ficheros) {
			//if normal
			if (f.isDirectory()) {
				System.out.print("Directorio:");
			} else {
				System.out.print("Fichero:");
			}
			System.out.println(f.getName());
		}
		//Renombrar directorios o ficheros
		File directorioOriginal = new File("d:/NuevaCarpeta");
		directorioOriginal.renameTo(new File("d:/CarpetaNueva"));
		
		File ficheroLineas = new File("d:/lineas.txt");
		ficheroLineas.renameTo(new File("d:/lines.txt"));
		//Creación de ficheros temporales
		try {
			File ficheroTemporal = File.createTempFile("temporal",".txt",new File("d:/"));
			ficheroTemporal.deleteOnExit();
			Thread.sleep(3000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Obtención de nombres
		File otroFichero = new File("d:/lines.txt");
		System.out.println("Existe:" + otroFichero.exists());
		System.out.println("AbsolutePath:" + otroFichero.getAbsolutePath());
		System.out.println("Path:" + otroFichero.getPath());
		System.out.println("Name:" + otroFichero.getName());
		try {
			System.out.println("CanonicalPath:" + otroFichero.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Filtrado de ficheros
		File rutaLibros = new File("D:/CarpetaNueva");
		//Implementación con clase anónima
		/*String[] ficherosEncontrados = rutaLibros.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.contains("PHP");
			}
		});*/
		//Implementación con Lambda 
		String[] ficherosEncontrados = rutaLibros.list((dir, name)->name.contains("PHP"));
		for (String libro : ficherosEncontrados) {
			System.out.println(libro);
		}
		
	}
}
