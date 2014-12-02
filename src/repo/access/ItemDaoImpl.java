package repo.access;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import repo.interfaces.ItemDao;
import repo.objects.Item;


public class ItemDaoImpl extends JdbcDaoSupport implements ItemDao {
	
	public Item getItem(String itemId) {

		StringBuffer sql = new StringBuffer();

		sql
			.append(" SELECT itemid, nombre, precio ")
			.append(" FROM ").append("ITEM")
			.append(" WHERE itemid = ?");

		Object[] params = new Object[] { itemId };

		Item it = (Item) getJdbcTemplate().queryForObject( sql.toString(), params, new ItemRowMapper());

		
		return it;
		
	}
	
	public void updateItem(Item item) {
		
	    StringBuffer sql = new StringBuffer();
		sql
		.append("UPDATE ").append("ITEM")
		.append(" SET nombre = ?, precio = ?")
		.append(" WHERE itemId = ?");
		
		Object[] params = new Object[] {
				item.getNombre(),
				item.getPrecio(),
				item.getItemId()
			};
		
		getJdbcTemplate().update(sql.toString(), params);
				
	}
	
	public void insertItem(Item item) {
		StringBuffer sql = new StringBuffer();
		
		sql
		.append("INSERT INTO ").append("ITEM")
		.append(" (itemid, nombre, precio) ")
		.append("VALUES(?,?,?)");
		
		Object[] params = new Object[] {
				item.getItemId(),
				item.getNombre(),
				item.getPrecio()
			};
		
		getJdbcTemplate().update(sql.toString(), params);
		
		
	}
	
	public void deleteItem(String itemId) {
		StringBuffer sql = new StringBuffer();
		
		sql
		.append("DELETE FROM ").append("ITEM")
		.append(" WHERE itemid = ? ");
		
		Object[] params = new Object[] {itemId};
		
		getJdbcTemplate().update(sql.toString(), params);
		
		
	}
	
	class ItemRowMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int index) throws SQLException {

			Item it = new Item();

			it.setItemId(rs.getString("itemid"));
			it.setNombre(rs.getString("nombre"));
			it.setPrecio(new Double(rs.getDouble("precio")));
		


			return it;
		}
	}
}
