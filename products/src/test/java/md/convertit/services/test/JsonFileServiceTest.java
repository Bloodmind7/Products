package md.convertit.services.test;



import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


import md.convertit.products.domain.Notebook;
import md.convertit.products.services.FileService;
import md.convertit.products.services.JsonFileServices;
import md.convertit.services.test.util.DemoData;

public class JsonFileServiceTest {
	
	FileService fs = new JsonFileServices();
	final String PATH = "notebooks.txt";
	final int TOTAL_DEMO_NOTEBOOKS =50;
	
	
	
	@Test
	public void saveAllTest() throws Exception{
		List<Notebook> notebookList = DemoData.getDemoData(50);
		assertNotNull(notebookList);
		fs.saveAll(notebookList, PATH);

}
	@Test
	public void readAllTest() throws Exception{
		List<Notebook> notebookList = fs.readAll(PATH);
		assertNotNull(notebookList);
		assertFalse(notebookList.isEmpty());
	    assertEquals(TOTAL_DEMO_NOTEBOOKS, notebookList.size());
		
	}
}