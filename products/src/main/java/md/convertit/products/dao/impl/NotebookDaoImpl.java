package md.convertit.products.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.poifs.filesystem.DocumentInputStream;


import md.convertit.products.dao.NotebookDao;
import md.convertit.products.domain.Notebook;
import md.convertit.products.util.ConnectionUtil;

public class NotebookDaoImpl implements NotebookDao{
	
	private static final Logger log = Logger.getLogger(NotebookDaoImpl.class.getName());

	private PreparedStatement ps;
	private Connection conn;

	@Override
	public boolean save(Notebook notebook) {
		try {
			conn = ConnectionUtil.getConnection();
    
			String sql = "INSERT INTO `notebook` (`Stock`,`Type`, `Price`, `Info`, `Ordered`, `orderedDate`) VALUES (?,?, ?, ?, ?, ?);";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, notebook.getStock());
			ps.setString(2, notebook.getType());
			ps.setDouble(3, notebook.getPrice());
			ps.setString(4, notebook.getInfo());
			ps.setBoolean(5, notebook.isOrdered());
			ps.setDate(6, new Date(notebook.getOrderedDate().getTime()));
			



			int affectedRows = ps.executeUpdate();
			log.info(String.format("Saved object, total affcted rows: %d", affectedRows));
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.severe(String.format("Exception: %s", e.getMessage()));
		}
		return false;
	}

	@Override
	public List<Notebook> findAll() {
		List<Notebook> notebooksList = new ArrayList<>();
		try {
			conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM notebook";
			ps = conn.prepareStatement(sql);
			ResultSet set = ps.executeQuery();

			while (set.next()) {
				long id = set.getInt("id");
				String type = set.getString("type");
				int stock = set.getInt("stock");
				double price = set.getDouble("price");
				String info = set.getString("info");
				boolean ordered = set.getBoolean("ordered");
				Date orderedDate = set.getDate("orderedDate");

				Notebook notebook = new Notebook();
				notebook.setId(id);
				notebook.setType(type);
				notebook.setStock(stock);
				notebook.setPrice(price);
				notebook.setOrdered(ordered);
				notebook.setOrderedDate(orderedDate);
				notebooksList.add(notebook);
				log.info(String.format("Added new user to list: %s", notebook.toString()));

			}

		} catch (SQLException e) {
			log.severe(String.format("Fatal error: %s", e.getMessage()));
			// e.printStackTrace();
		}
		log.info(String.format("Retrived from database %d notebook", notebooksList.size()));
		System.out.println(notebooksList);
		return notebooksList;

	}

}
