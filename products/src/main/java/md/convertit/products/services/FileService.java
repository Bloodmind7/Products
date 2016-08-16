package md.convertit.products.services;

import java.util.List;

import md.convertit.products.domain.Notebook;

public interface FileService {

	void saveAll(List<Notebook> notebooks, String path) throws Exception;

	List<Notebook> readAll(String path) throws Exception;

}
