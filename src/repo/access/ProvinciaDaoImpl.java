package repo.access;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import repo.interfaces.ProvinciaDao;
import repo.objects.Provincia;

public class ProvinciaDaoImpl extends JdbcDaoSupport implements ProvinciaDao{

	public Provincia getItem(int prov) {

		StringBuffer sql = new StringBuffer();

		sql
			.append(" SELECT provincia, descripcion, prefijo ")
			.append(" FROM ").append("provincias")
			.append(" WHERE provincia = ?");

		Object[] params = new Object[] { prov };

		Provincia it = (Provincia) getJdbcTemplate().queryForObject( sql.toString(), params, new ItemRowMapper());

		
		return it;
		
	}
	
public void updateItem(Provincia prov) {
		
	    StringBuffer sql = new StringBuffer();
		sql
		.append("UPDATE ").append("provincias")
		.append(" SET prefijo = ?")
		.append(" WHERE provincia = ?");
		
		Object[] params = new Object[] {
				
				prov.getPrefijo(),
				prov.getProvincia()
			};
		
		getJdbcTemplate().update(sql.toString(), params);
				
	}

public void insertItem(Provincia prov) {
	StringBuffer sql = new StringBuffer();
	
	sql
	.append("INSERT INTO ").append("provincias")
	.append(" (provincia, descripcion, prefijo) ")
	.append("VALUES(?,?,?)");
	
	Object[] params = new Object[] {
			prov.getProvincia(),
			prov.getDescripcion(),
			prov.getPrefijo()
		};
	
	getJdbcTemplate().update(sql.toString(), params);
		
}

public void deleteItem(int prov) {
	StringBuffer sql = new StringBuffer();
	
	sql
	.append("DELETE FROM ").append("provincias")
	.append(" WHERE provincia = ? ");
	
	Object[] params = new Object[] {prov};
	
	getJdbcTemplate().update(sql.toString(), params);
	
	
}

class ItemRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int index) throws SQLException {

		Provincia it = new Provincia();

		it.setProvincia(rs.getInt("provincia"));
		it.setDescripcion(rs.getString("descripcion"));
		it.setPrefijo(new Integer(rs.getInt("prefijo")));
	


		return it;
	}
}
}
