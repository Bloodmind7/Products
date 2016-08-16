package md.convertit.products.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import md.convertit.products.domain.Notebook;

public class ExcelFileServices implements FileService {
	


	public void saveAll(List<Notebook> notebooks, String path) throws Exception {
		
		File file=new File(path);
		
		FileOutputStream fos = new FileOutputStream(file);
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("sample sheet");
		//Create a new row in current sheet
		Row row = sheet.createRow(0);
		//Create a new cell in current row
		Cell cell = row.createCell(0);
		//Set value to new value
		cell.setCellValue("Type");
		
		Cell cell1 = row.createCell(1);
		cell1.setCellValue("Price");
		
		Cell cell2 = row.createCell(2);
		cell2.setCellValue("Stock");
		
		Cell cell3 = row.createCell(3);
		cell3.setCellValue("Info");
		
		Cell cell4 = row.createCell(4);
		cell4.setCellValue("Ordered");
		

		Cell cell5 = row.createCell(5);
		cell5.setCellValue("OrderedDate");
		
		 int rowIndex =1;
		 for (int i = rowIndex; i  < notebooks.size(); i++) {
		 	 
			//Create a new row in current sheet
				Row row1 = sheet.createRow(i);
				//Create a new cell in current row
				Cell celll = row1.createCell(0);
				//Set value to new value
				celll.setCellValue(notebooks.get(i).getType());
				celll = row1.createCell(1);
				celll.setCellValue(notebooks.get(i).getPrice());
				celll = row1.createCell(2);
				celll.setCellValue(notebooks.get(i).getStock());
				celll = row1.createCell(3);
				celll.setCellValue(notebooks.get(i).getInfo());
				celll = row1.createCell(4);
				celll.setCellValue(notebooks.get(i).isOrdered());
				celll = row1.createCell(5);
				celll.setCellValue(notebooks.get(i).getOrderedDate());
				
				
				
		}
			 
			
		
		
		autoSizeColumns(sheet);
		workbook.write(fos);
		fos.close();
		
		
		
	}

	private void autoSizeColumns(HSSFSheet sheet) {
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		
	}

	public List<Notebook> readAll(String path) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
