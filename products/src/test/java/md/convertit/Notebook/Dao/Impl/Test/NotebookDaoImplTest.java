package md.convertit.Notebook.Dao.Impl.Test;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import md.convertit.products.dao.NotebookDao;
import md.convertit.products.dao.impl.NotebookDaoImpl;
import md.convertit.products.domain.Notebook;
import md.convertit.services.test.util.DemoData;



public class NotebookDaoImplTest {
	
	private NotebookDao dao = new NotebookDaoImpl();
	
	@Test
	public void testSave(){
		
		Notebook notebook = DemoData.getDemoData(1).get(0);
//		notebook.setType("Asus");
//		notebook.setStock(10);
//		notebook.setPrice(6500D);
//		notebook.setInfo("x550");
//		notebook.setOrdered(false);
//		notebook.setOrderedDate(new Date());
		
		boolean result = dao.save(notebook);
		Assert.assertTrue(result);
		
	}
	@Test
	public void testFindAll(){
		List<Notebook> allnotebooks = dao.findAll();
		Assert.assertNotNull(allnotebooks);
		Assert.assertFalse(allnotebooks.isEmpty());
		Assert.assertTrue(allnotebooks.size()>0);
		
		
	}
	
	
}
