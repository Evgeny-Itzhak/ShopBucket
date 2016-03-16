package home.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import home.model.Item;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
	private JdbcTemplate jdbcTemplate;

	public ItemDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void save(Item item) {
		String sql = "INSERT INTO item (model, memory, color) VALUES (?, ?, ?)";
			jdbcTemplate.update(sql, item.getModel(), item.getMemory(),
					item.getColor());
	}

	public void update(Item item) {
		if (item.getId() > 0) {
			String sql = "UPDATE item SET model=?, memory=?, color=? WHERE item_id=?";
			jdbcTemplate.update(sql, item.getModel(), item.getMemory(),
					item.getColor(), item.getId());
		}
	}

	public void delete(int itemId) {
		String sql = "DELETE FROM item WHERE item_id=?";
		jdbcTemplate.update(sql, itemId);
	}

	public List<Item> list() {
		String sql = "SELECT * FROM item";
		List<Item> itemList = jdbcTemplate.query(sql, new RowMapper<Item>() {
			public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
				Item aItem = new Item();

				aItem.setId(rs.getInt("item_id"));
				aItem.setModel(rs.getString("model"));
				aItem.setMemory(rs.getString("memory"));
				aItem.setColor(rs.getString("color"));

				return aItem;
			}
		});
		return itemList;
	}

	public Item get(int itemId) {
		String sql = "SELECT * FROM item WHERE item_id=" + itemId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Item>() {
			public Item extractData(ResultSet rs) throws SQLException,DataAccessException {
				if (rs.next()) {
					Item item = new Item();

					item.setId(rs.getInt("item_id"));
					item.setModel(rs.getString("model"));
					item.setMemory(rs.getString("memory"));
					item.setColor(rs.getString("color"));

					return item;
				}
				return null;
			}
		});
	}
}