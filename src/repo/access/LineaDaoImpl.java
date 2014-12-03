package repo.access;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import repo.interfaces.LineaDao;
import repo.objects.Linea;

public class LineaDaoImpl extends JdbcDaoSupport implements LineaDao{

	public Linea getLinea(int lin) {

		Linea linea = null;

		return linea;

	}

	public void updateLinea(Linea linea) {


	}

	public void insertLinea(Linea linea) {

	}

	public void deleteLinea(int linea) {


	}

	/*class ItemRowMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int index) throws SQLException {

			Provincia it = new Provincia();

			it.setProvincia(rs.getInt("provincia"));
			it.setDescripcion(rs.getString("descripcion"));
			it.setPrefijo(new Integer(rs.getInt("prefijo")));



			return it;
		}
	}*/
}
