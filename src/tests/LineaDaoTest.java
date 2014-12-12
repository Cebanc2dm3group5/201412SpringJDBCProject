package tests;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import repo.interfaces.LineaDao;
import repo.objects.Linea;

@SuppressWarnings("deprecation")
public class LineaDaoTest extends
		AbstractTransactionalDataSourceSpringContextTests {

	private LineaDao lineaDao;

	public void setLineaDao(LineaDao lineaDao) {
		this.lineaDao = lineaDao;
	}
	
	protected String[] getConfigLocations() {
		this.setAutowireMode(AUTOWIRE_BY_NAME);
		return new String[] { "repo/context/Context-testLinea.xml" };
	}

	public void testInsertLinea() {
		// this.setDefaultRollback(false);
		Linea linea = new Linea();
		linea.setAlbaran(1);
		linea.setLinea(9999);
		linea.setArticulo(133);
		linea.setCantidad(5);
		linea.setDescuento(3);
		linea.setPrecio(300);
		linea.setProveedor(68);

		lineaDao.insertLinea(linea);

		Linea lineaResult = lineaDao.getLinea(linea.getLinea(), linea.getAlbaran());

		assertEquals(linea.getLinea(), lineaResult.getLinea());

	}

	public void testGetLinea() {
		Linea linea = new Linea();
		linea.setAlbaran(1);
		linea.setLinea(9999);
		linea.setArticulo(133);
		linea.setCantidad(5);
		linea.setDescuento(3);
		linea.setPrecio(300);
		linea.setProveedor(68);

		lineaDao.insertLinea(linea);

		Linea lineaResult = lineaDao.getLinea(linea.getLinea(), linea.getAlbaran());
		assertNotNull(lineaResult);
	}
	
	
	public void testUpdateLinea() {
		Linea linea = new Linea();
		linea.setAlbaran(1);
		linea.setLinea(9999);
		linea.setArticulo(133);
		linea.setCantidad(5);
		linea.setDescuento(3);
		linea.setPrecio(300);
		linea.setProveedor(68);

		lineaDao.insertLinea(linea);

		Linea linea2 = new Linea();
		linea2.setAlbaran(1);
		linea2.setLinea(9999);
		linea2.setArticulo(133);
		linea2.setCantidad(50);
		linea2.setDescuento(3);
		linea2.setPrecio(300);
		linea2.setProveedor(68);

		lineaDao.updateLinea(linea2);

		Linea lineaResult = lineaDao.getLinea(linea2.getLinea(), linea.getAlbaran());
		assertEquals(lineaResult.getCantidad(), 50);
	}
	
	public void testDeleteItem() {
		Linea linea = new Linea();
		linea.setAlbaran(1);
		linea.setLinea(9999);
		linea.setArticulo(133);
		linea.setCantidad(5);
		linea.setDescuento(3);
		linea.setPrecio(300);
		linea.setProveedor(68);

		lineaDao.insertLinea(linea);

		int lineaToDelete = 9999;
		int albaranToDelete = 1;
		lineaDao.deleteLinea(lineaToDelete, albaranToDelete);

		// si la ejecucion llega aqui significa que el delete se ha efectuado
		// correctamente
		assertTrue(true);

	}
	
	
	

}
