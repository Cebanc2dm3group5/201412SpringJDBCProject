package tests;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import repo.interfaces.ProvinciaDao;
import repo.objects.Provincia;

@SuppressWarnings("deprecation")
public class ProvinciaDaoTest extends
		AbstractTransactionalDataSourceSpringContextTests {

	private ProvinciaDao provinciaDao;

	public void setProvinciaDao(ProvinciaDao provinciaDao) {
		this.provinciaDao = provinciaDao;
	}

	protected String[] getConfigLocations() {
		this.setAutowireMode(AUTOWIRE_BY_NAME);
		return new String[] { "repo/context/Context-testProvincia.xml" };
	}

	public void testInsertItem() {
		// this.setDefaultRollback(false);
		Provincia item = new Provincia();
		item.setProvincia(55);
		item.setDescripcion("Item 1");
		item.setPrefijo(15);

		provinciaDao.insertItem(item);

		Provincia itemResult = provinciaDao.getItem(item.getProvincia());

		assertEquals(item.getProvincia(), itemResult.getProvincia());

	}

	public void testGetItem() {
		// this.setDefaultRollback(false);
		int setProvincia = 56;
		Provincia prov = new Provincia();
		prov.setProvincia(56);
		prov.setDescripcion("Prov 2");
		prov.setPrefijo(10);

		provinciaDao.insertItem(prov);

		Provincia itemResult = provinciaDao.getItem(setProvincia);
		assertNotNull(itemResult);
	}

	public void testUpdateItem() {
		// this.setDefaultRollback(false);
		Provincia prov = new Provincia();
		prov.setProvincia(66);
		prov.setDescripcion("Prov 3");
		prov.setPrefijo(12);

		provinciaDao.insertItem(prov);

		Provincia provNuevo = new Provincia();
		provNuevo.setProvincia(66);
		provNuevo.setDescripcion("Prov 3 Nuevo");
		provNuevo.setPrefijo(22);

		provinciaDao.updateItem(provNuevo);

		Provincia provResult = provinciaDao.getItem(provNuevo.getProvincia());
		assertEquals(provResult.getPrefijo(), 22);
	}

	public void testDeleteItem() {
		Provincia prov = new Provincia();
		prov.setProvincia(84);
		prov.setDescripcion("Prov 4");
		prov.setPrefijo(124);

		provinciaDao.insertItem(prov);

		int provincia = 84;
		provinciaDao.deleteItem(provincia);

		// si la ejecucion llega aqui significa que el delete se ha efectuado
		// correctamente
		assertTrue(true);

	}

}