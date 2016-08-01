package blueberry.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javafx.scene.control.Cell;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//




public class excelExport {
    
    public static void main(String[] args){

	
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet("Sample sheet");
	 
	HashMap<String, Object[]> data = new HashMap<String, Object[]>();
	data.put("1", new Object[] {"Emp No.", "Name", "Salary"});
	data.put("2", new Object[] {1d, "John", 1500000d});
	data.put("3", new Object[] {2d, "Sam", 800000d});
	data.put("4", new Object[] {3d, "Dean", 700000d});
	 
	Set<String> keyset = data.keySet();
	int rownum = 0;
	for (String key : keyset) {
	    HSSFRow row = sheet.createRow(rownum++);
	    Object [] objArr = data.get(key);
	    int cellnum = 0;
	    for (Object obj : objArr) {
	        HSSFCell cell = row.createCell((short) cellnum++);
	        if(obj instanceof Date) 
	            cell.setCellValue((Date)obj);
	        else if(obj instanceof Boolean)
	            cell.setCellValue((Boolean)obj);
	        else if(obj instanceof String)
	            cell.setCellValue((String)obj);
	        else if(obj instanceof Double)
	            cell.setCellValue((Double)obj);
	    }
	}
	 
	try {
	    FileOutputStream out = new FileOutputStream(new File("C:\\Cache\\new.xls"));
	    workbook.write(out);
	    out.close();
	    System.out.println("Excel written successfully..");
	     
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
}
