package md.convertit.services.test;

import java.io.File;
import java.util.List;

import org.junit.Test;

import md.convertit.products.domain.Notebook;
import md.convertit.products.services.ExcelFileServices;
import md.convertit.products.services.FileService;
import md.convertit.services.test.util.DemoData;


public class ExcelFileServiceTest {
	
	FileService fs = new ExcelFileServices();
	final String PATH = "notebooks.xls";
	final int TOTAL_DEMO_NOTEBOOKS =10;

	
	@Test
	public void prepare() throws Exception{
		List<Notebook> notebookList = DemoData.getDemoData(TOTAL_DEMO_NOTEBOOKS);
		fs.saveAll(notebookList, PATH);
	
}
}