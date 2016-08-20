package md.convertit.products.services;

import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

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
		
		cell = row.createCell(1);
		cell.setCellValue("Price");
		
		cell = row.createCell(2);
		cell.setCellValue("Stock");
		
		cell = row.createCell(3);
		cell.setCellValue("Info");
		
		Cell cell4 = row.createCell(4);
		cell.setCellValue("Ordered");
		

		cell = row.createCell(5);
		cell.setCellValue("OrderedDate");
		
		 int rowIndex =0;
		 for (int i = rowIndex; i  < notebooks.size(); i++) {
		 	 
			//Create a new row in current sheet
				Row row1 = sheet.createRow(i+1);
				//Create a new cell in current row
				cell = row1.createCell(0);
				//Set value to new value
				cell.setCellValue(notebooks.get(i).getType());
				cell = row1.createCell(1);
				cell.setCellValue(notebooks.get(i).getPrice());
				cell = row1.createCell(2);
				cell.setCellValue(notebooks.get(i).getStock());
				cell = row1.createCell(3);
				cell.setCellValue(notebooks.get(i).getInfo());
				cell = row1.createCell(4);
				cell.setCellValue(notebooks.get(i).isOrdered());
				cell = row1.createCell(5);
				cell.setCellValue(notebooks.get(i).getOrderedDate());
				
				
				
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
	
		    List<Notebook> listNotebook= new ArrayList<>();
		    FileInputStream inputStream = new FileInputStream(new File(path));
		 
		    Workbook workbook = new HSSFWorkbook(inputStream);
		    Sheet firstSheet = workbook.getSheetAt(0);
		    Iterator<Row> iterator = firstSheet.iterator();
		 
		    while (iterator.hasNext()) {
		        Row nextRow = iterator.next();
		        if (nextRow.getRowNum() == 0){
		        	continue;
		        }
		        Iterator<Cell> cellIterator = nextRow.cellIterator();
		        Notebook notebook = new Notebook();
		 
		        while (cellIterator.hasNext()) {
		            Cell nextCell = cellIterator.next();
		            int columnIndex = nextCell.getColumnIndex();
		 
		            switch (columnIndex) {
		            case 0:
		            	notebook.setType((String) getCellValue(nextCell));
		                break;
		            case 1:
		            	notebook.setPrice((double) getCellValue(nextCell));
		                break;
		            case 2: 
		            	Double d = new Double((double) getCellValue(nextCell));
		            	int i = d.intValue();
		            	System.out.println(getCellValue(nextCell));
		            	notebook.setStock(i);
		                break;
		            case 3:
		            	notebook.setInfo((String) getCellValue(nextCell));
		                break;
		            case 4:
		            	notebook.setOrdered((boolean) getCellValue(nextCell));
		                break;
		            case 5:
		            	 Date javaDate= DateUtil.getJavaDate((double) getCellValue(nextCell));
		            	System.out.println(getCellValue(nextCell));
		            	notebook.setOrderedDate(javaDate);
		                break;
		            }
		 
		 
		        }
		        listNotebook.add(notebook);
		    }
		 
		//workbook.close();
		    inputStream.close();
		 
		    return listNotebook;
		
		
		
		
	}

	private Object getCellValue(Cell nextCell) {
		 switch (nextCell.getCellType()) {
		    case Cell.CELL_TYPE_STRING:
		        return nextCell.getStringCellValue();
		 
		    case Cell.CELL_TYPE_BOOLEAN:
		        return nextCell.getBooleanCellValue();
		 
		    case Cell.CELL_TYPE_NUMERIC:
		        return nextCell.getNumericCellValue();
		    }
		 
		    return null;
	}
	
	
	

}
