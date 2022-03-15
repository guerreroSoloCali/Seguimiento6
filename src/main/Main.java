package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import model.Hoarding;
import model.HoardingData;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		showMenu();
	}
	
	static HoardingData hData = new HoardingData();
	
	public static void showMenu(){
		
		System.out.println("Digite la opcion que desea ejecutar \n");
		
		System.out.println("Escriba 1 si desea importar un archivo ");
		System.out.println("Escriba 2 si desea agregar acaparamiento ");
		System.out.println("Escriba 3 si desea mostrar todas las vallas publicitarias ");
		System.out.println("Escriba 4 si desea exportar el informe ");
		
		int op = sc.nextInt();
		section(op);
	}
	
	public static void section(int op) {
		
		switch(op) {
		case 1:
			
			importarUnArchivo();
			break;
		case 2:
			
			agregar();
			break;
		case 3:
			
			mostrar();
			break;
		case 4:
			
			exportar();
			break;
		}
		showMenu();
	}
	
	public static void agregar() {
		
		System.out.println("Escriba la informacion con ++");
		String read = sc.next();
		sc.nextLine();
		String[] split = read.split("\\++");
		hData.add(new Hoarding(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Boolean.parseBoolean(split[2]),split[3]));
	}

	public static void mostrar() {
		
	for(Hoarding h : hData.getHoardings())
		System.out.println("\n"+h+"\n");
	}
	public static void exportar() {
		hData.guardar();
	}
	
	public static void importarUnArchivo() {
		System.out.println("Escriba la ubicacion del archivo");
		File file = new File(sc.next());
		try {
			
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object ob = ois.readObject();
			String data = (String) ob;
			String[] split = data.split("\\|");
			for(String s : split)
			System.out.println(s);
			
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}