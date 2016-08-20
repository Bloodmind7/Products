package md.convertit.products.dao;

import java.util.List;

import md.convertit.products.domain.Notebook;



public interface NotebookDao {
boolean save (Notebook notebook);
	
	List<Notebook> findAll();

}
