package repo.interfaces;

import repo.objects.Linea;

public interface LineaDao {

	Linea getLinea(int linea, int alb);

	void updateLinea(Linea linea);

	void insertLinea(Linea linea);

	void deleteLinea(int linea, int alb);


}
