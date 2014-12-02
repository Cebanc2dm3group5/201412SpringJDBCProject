package repo.interfaces;

import repo.objects.Provincia;

public interface ProvinciaDao {

	Provincia getItem(int provincia);

	void updateItem(Provincia provincia);

	void insertItem(Provincia provincia);

	void deleteItem(int provincia);
}
