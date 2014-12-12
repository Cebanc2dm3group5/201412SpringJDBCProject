package repo.validate;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputRepo {

	public static int askInt(String msg, int min, int max) {
		Scanner sc = new Scanner(System.in);
		boolean correct = false;
		int res = 0;
		while (!correct) {
			System.out.print(msg + ": ");
			try{
				res = sc.nextInt();
				if ((res >= min) && (res<=max)){
					return res;
				}else{
					System.out.println("\nDebe introducir una opción correcta. Vuelva a intentarlo.|n");
					sc.nextLine();
				}
				
			}catch(InputMismatchException e){
				System.out.println("\nDebe introducir un número entero. Vuelva a intentarlo.\n");
				sc.nextLine();
			}
		}
		return res;

	}
	
	
	public static String askString(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + ": ");
		return sc.nextLine();
	}

	public static int askInt(String msg) {
		Scanner sc = new Scanner(System.in);
		boolean correct = false;
		int res = 0;
		while (!correct) {
			System.out.print(msg + ": ");
			try{
				res = sc.nextInt();
				return res;
			}catch(InputMismatchException e){
				System.out.println("\nDebe introducir un número entero. Vuelva a intentarlo.\n");
				sc.nextLine();
			}
		}
		return res;

	}
	
	
	public static double askDouble(String msg) {
		Scanner sc = new Scanner(System.in);
		boolean correct = false;
		double res = 0;
		while (!correct) {
			System.out.print(msg + ": ");
			try{
				res = sc.nextDouble();
				return res;
			}catch(InputMismatchException e){
				System.out.println("\nDebe introducir un número entero. Vuelva a intentarlo.\n");
				sc.nextLine();
			}
		}
		return res;

	}
	
	

}
