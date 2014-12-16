package repo.validate;

import repo.objects.Linea;

public class OutputRepo {
	public static void printLinea(Linea l){
		System.out.println("\nLinea: "+l.getLinea());
		System.out.println("\nAlbaran: "+l.getAlbaran());
		System.out.println("\nArticulo: "+l.getArticulo());
		System.out.println("\nCantidad: "+l.getCantidad());
		System.out.println("\nPrecio: "+l.getPrecio());
		
	}
}
