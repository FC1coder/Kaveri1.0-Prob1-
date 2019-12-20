package pdf1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;

public class CreateExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HSSFWorkbook myWorkBook = null ;
		HSSFRow myRow = null;
		HSSFRow header = null;
		myWorkBook = new HSSFWorkbook();
		CreationHelper helper = myWorkBook.getCreationHelper();
		HSSFSheet mySheet = myWorkBook.createSheet("result analysis");

		
		header = mySheet.createRow(0);
	    
	    header.createCell(0).setCellValue("Seat No");
	    header.createCell(1).setCellValue("Student Name");
	    header.createCell(2).setCellValue("Mother Name");
	    header.createCell(3).setCellValue("Sex");
	   
	    HSSFCell cell = header.getCell(0);
	    //cell.setC
	    
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("E://NewRA.xls");
            myWorkBook.write(fileOut);
            fileOut.close();
           
        } catch (Exception e) {
            System.out.println("FILE NOT FOUND");
        }

	}

}
