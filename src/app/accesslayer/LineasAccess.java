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
		
		int artNum = InputRepo.askInt("N�mero de art�culo");
		int provNum = InputRepo.askInt("N�mero de proveedor");
		int cantidad = InputRepo.askInt("Cantidad");
		int descuento = InputRepo.askInt("Descuento");
		double precio = InputRepo.askDouble("Precio");
		
		Linea line = new Linea();
		line.setAlbaran(albNum);
		line.setArticulo(artNum);
		line.setCantidad(cantidad);
		line.setDescuento(descuento);
		line.setLinea(lineNum);
		line.setPrecio(precio);
		line.setProveedor(provNum);
		
		
		LineaDaoImpl dbLineas = new LineaDaoImpl();

		dbLineas.insertLinea(line);
		
		
	}

	public static void updateLinea() {
		// TODO update linea layer
		
	}

}
