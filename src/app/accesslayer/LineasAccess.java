package app.accesslayer;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import repo.access.LineaDaoImpl;
import repo.objects.Linea;
import repo.validate.InputRepo;

public class LineasAccess {

	public static void endProgram() {
		System.out.println(":::: FIN DEL PROGRAMA ::::");

	}

	private static boolean validLineaNums(int lineNum, int albNum){
		LineaDaoImpl dbLineas = new LineaDaoImpl();

		Linea l = dbLineas.getLinea(lineNum, albNum);
		if (l==null){
			return true;
		}else{
			return false;
		}
	}

	public static void addLinea() {

		Linea line = new Linea();
		
		System.out.println(":: Introduzca la nueva l�nea ::");
		boolean lineaValid = false;
		int lineNum = 0;
		int albNum = 0;
		while(!lineaValid){
			lineNum = InputRepo.askInt("N�mero de l�nea");
			albNum = InputRepo.askInt("N�mero de albaran");
			if (validLineaNums(lineNum, albNum)){
				lineaValid = true;
			}else{
				System.out.println("Los datos introducidos no son v�lidos porque esa linea ya existe. Int�ntalo de nuevo.");
			}
		}

		line = askLineData();

		line.setAlbaran(albNum);
		line.setLinea(lineNum);

		LineaDaoImpl dbLineas = new LineaDaoImpl();

		dbLineas.insertLinea(line);

	}

	public static void updateLinea() {

		LineaDaoImpl dbLineas = new LineaDaoImpl();
		Linea line = new Linea();
		
		System.out.println(":: Introduzca la l�nea a borrar ::");
		boolean lineaValid = true;
		int lineNum = 0;
		int albNum = 0;
		while(lineaValid){
			lineNum = InputRepo.askInt("N�mero de l�nea");
			albNum = InputRepo.askInt("N�mero de albaran");
			if (!validLineaNums(lineNum, albNum)){
				lineaValid = false;
			}else{
				System.out.println("Los datos introducidos no son v�lidos porque esa linea no existe. Int�ntalo de nuevo.");
			}
		}

		showLinea(lineNum,albNum);
		
		line = askLineData();
		
		line.setLinea(lineNum);
		line.setAlbaran(albNum);
		
		dbLineas.updateLinea(line);
		
	}

	public static void deleteLinea(){

		System.out.println(":: Introduzca la l�nea a borrar ::");
		boolean lineaValid = true;
		int lineNum = 0;
		int albNum = 0;
		while(lineaValid){
			lineNum = InputRepo.askInt("N�mero de l�nea");
			albNum = InputRepo.askInt("N�mero de albaran");
			if (!validLineaNums(lineNum, albNum)){
				lineaValid = false;
			}else{
				System.out.println("Los datos introducidos no son v�lidos porque esa linea no existe. Int�ntalo de nuevo.");
			}
		}

		showLinea(lineNum,albNum);

		if (InputRepo.askBoolean("�Borrar Linea?")){

			LineaDaoImpl dbLineas = new LineaDaoImpl();

			dbLineas.deleteLinea(lineNum,albNum);

		}else{

			System.out.println("Operaci�n cancelada");

		}

	}

	public static void consultLinea(){

		System.out.println(":: Introduzca la l�nea a consultar ::");
		boolean lineaValid = true;
		int lineNum = 0;
		int albNum = 0;
		while(lineaValid){
			lineNum = InputRepo.askInt("N�mero de l�nea");
			albNum = InputRepo.askInt("N�mero de albaran");
			if (!validLineaNums(lineNum, albNum)){
				lineaValid = false;
			}else{
				System.out.println("Los datos introducidos no son v�lidos porque esa linea no existe. Int�ntalo de nuevo.");
			}
		}

		showLinea(lineNum,albNum);

	}

	public static void showLinea(int linea, int albaran){

		Linea line = new Linea();
		LineaDaoImpl dbLineas = new LineaDaoImpl();

		line = dbLineas.getLinea(linea, albaran);

		int artNum = line.getArticulo();
		int provNum = line.getProveedor();
		int cantidad = line.getCantidad();
		int descuento = line.getDescuento();
		double precio = line.getPrecio();

		System.out.println("Linea: " + linea);
		System.out.println("Albaran: " + albaran);
		System.out.println("Art�culo: " + artNum);
		System.out.println("Proveedor: " + provNum);
		System.out.println("Cantidad: " + cantidad);
		System.out.println("Descuento: " + descuento);
		System.out.println("Precio: " + precio);

	}
	
	public static Linea askLineData(){

		Linea line = new Linea();
		
		int artNum = InputRepo.askInt("N�mero de art�culo");
		int provNum = InputRepo.askInt("N�mero de proveedor");
		int cantidad = InputRepo.askInt("Cantidad");
		int descuento = InputRepo.askInt("Descuento");
		double precio = InputRepo.askDouble("Precio");

		line.setArticulo(artNum);
		line.setCantidad(cantidad);
		line.setDescuento(descuento);
		line.setPrecio(precio);
		line.setProveedor(provNum);
		
		return line;
		
	}

}
