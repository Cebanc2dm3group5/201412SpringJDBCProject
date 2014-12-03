package repo.interfaces;

import repo.objects.Linea;

public interface LineaDao {

	Linea getLinea(int linea);

	void updateLinea(Linea linea);

	void insertLinea(Linea linea);

	void deleteLinea(int linea);


}
