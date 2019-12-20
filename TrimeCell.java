package pdf1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class TrimeCell {

	public  void trimeIt() {

		try {
			
			HSSFWorkbook myWorkBook = null;
			// conversion starts here....

			HSSFRow myRow = null;

			HSSFRow header = null;

			// HSSFCell myCell = null;
			myWorkBook = new HSSFWorkbook();
			CreationHelper helper = myWorkBook.getCreationHelper();
			HSSFSheet mySheet = myWorkBook.createSheet("result analysis");
			int pq = 1;

			FileInputStream file = new FileInputStream("D://AM.xls");
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			java.util.Iterator<Row> rowiterator = sheet.iterator();
			Cell cell;
			Row row;

			while (rowiterator.hasNext()) {
				myRow = mySheet.createRow(pq);
				pq++;
				row = rowiterator.next();
				java.util.Iterator<Cell> celliterator = row.cellIterator();
				int k = 0;
				while (celliterator.hasNext()) {
					cell = celliterator.next();

					////System.out.println(cell.getStringCellValue());
					//// ////System.out.println(cell.getStringCellValue());
					if ((cell.getStringCellValue() == null) || (cell.getStringCellValue().length() == 0) || cell.getStringCellValue().equals("FF")) {

						//////System.out.println("BLANK");
						
						continue;

					}
					else
					{
					myRow.createCell(k).setCellValue(helper.createRichTextString(cell.getStringCellValue()));
					k++;
					}
				}
			}

            FileOutputStream fileOut;
            try {
                fileOut = new FileOutputStream("D://TUE.xls");
                myWorkBook.write(fileOut);
                fileOut.close();
               
            } catch (FileNotFoundException e) {
               // ////System.out.println("FILE NOT FOUND");
            }
        catch (IOException e) {
        	////System.out.println(e);
        }


			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
