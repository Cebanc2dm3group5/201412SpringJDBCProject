package app;

import java.util.Scanner;

import app.accesslayer.LineasAccess;
import repo.validate.InputRepo;

public class LineasApp {

	public static void main(String[] args) {
		
		int opt = -1;
		
		while (opt!=0){
			opt = menu();
			chooseWay(opt);
			
		}

	}

	private static void chooseWay(int opt) {
		switch (opt){
		case 0: LineasAccess.endProgram();
		break;
		case 1: LineasAccess.addLinea();
		break;
		case 2: LineasAccess.updateLinea();
		break;
		case 3: LineasAccess.deleteLinea();
		break;
		case 4: LineasAccess.consultLinea();
		break;
		}
	}

	private static int menu() {
		Scanner sc = new Scanner(System.in);
		int opt;
		System.out.println(":::: LINEAS ::::\n");
		System.out.println("1. Añadir una linea");
		System.out.println("2. Modificar una linea");
		System.out.println("3. Borrar una linea");
		System.out.println("4. Buscar una linea");
		System.out.println("0. Salir");
		opt = InputRepo.askInt("Elija una opción", 0, 4);
		
		return opt;
	}

}
