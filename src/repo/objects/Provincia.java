package repo.objects;

import java.io.Serializable;

public class Provincia implements Serializable {

	private static final long serialVersionUID = 1L;
	private int provincia;
	private String descripcion;
	private int prefijo;

	public int getProvincia() {
		return provincia;
	}

	public void setProvincia(int provincia) {
		this.provincia = provincia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(int prefijo) {
		this.prefijo = prefijo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
