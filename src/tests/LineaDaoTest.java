package tests;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import repo.interfaces.LineaDao;

public class LineaDaoTest extends
		AbstractTransactionalDataSourceSpringContextTests {

	
	private LineaDao lineaDao;
	
	public void setLineaDao(LineaDao lineaDao) {
		this.lineaDao = lineaDao;
	}
	
}
