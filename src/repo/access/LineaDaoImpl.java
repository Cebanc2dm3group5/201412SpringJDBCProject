package repo.access;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import repo.interfaces.LineaDao;
import repo.objects.Linea;

public class LineaDaoImpl extends JdbcDaoSupport implements LineaDao {

	public Linea getLinea(int lin) {

		Linea linea = null;

		return linea;

	}

	public void updateLinea(Linea linea) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE ").append("lineas").append(" SET precio = ?, ")
				.append("articulo = ?, ").append("albaran = ?, ")
				.append("cantidad = ?, ").append("proveedor = ?")
				.append(" WHERE linea = ?");

		Object[] params = new Object[] {

		linea.getPrecio(), linea.getArticulo(), linea.getAlbaran(), linea.getCantidad(), linea.getProveedor(), linea.getLinea() };

		getJdbcTemplate().update(sql.toString(), params);
	}

	public void insertLinea(Linea linea) {
		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO ").append("lineas")
				.append(" (precio, articulo, albaran, cantidad, proveedor) ")
				.append("VALUES(?,?,?,?,?)");

		Object[] params = new Object[] { linea.getPrecio(),
				linea.getArticulo(), linea.getAlbaran(), linea.getCantidad(), linea.getProveedor()};

		getJdbcTemplate().update(sql.toString(), params);
	}

	public void deleteLinea(int linea) {

	}

	class ItemRowMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int index) throws SQLException {

			Linea li = new Linea();

			li.setLinea(rs.getInt("linea"));
			li.setArticulo(rs.getInt("articulo"));
			li.setAlbaran(new Integer(rs.getInt("albaran")));
			li.setCantidad(rs.getInt("cantidad"));
			li.setDescuento(rs.getInt("descuento"));
			li.setProveedor(rs.getInt("proveedor"));
			li.setPrecio(rs.getDouble("precio"));

			return li;
		}
	}
}
