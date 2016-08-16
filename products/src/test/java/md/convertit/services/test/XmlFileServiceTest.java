package md.convertit.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import md.convertit.products.domain.Notebook;
import md.convertit.products.services.FileService;
import md.convertit.products.services.XmlFileServices;
import md.convertit.services.test.util.DemoData;


public class XmlFileServiceTest {
	FileService fs = new XmlFileServices();
	final String PATH = "notebooks.xml";
	final int TOTAL_DEMO_NOTEBOOKS =50;
	
	
	@Test
	public void prepare() throws Exception{
		List<Notebook> notebookList = DemoData.getDemoData(TOTAL_DEMO_NOTEBOOKS);
		fs.saveAll(notebookList, PATH);
		
	}
	
	@Test
	public void readAllTest() throws Exception{
		List<Notebook> notebookList = fs.readAll(PATH);
		//verificam sa fie not null
		assertNotNull(notebookList);
		assertFalse(notebookList.isEmpty());
	    assertEquals(TOTAL_DEMO_NOTEBOOKS, notebookList.size());
		
	}

}
