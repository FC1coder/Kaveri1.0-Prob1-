package pdf1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.StringReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.commons.io.IOUtils;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;

//import com.itextpdf.text.pdf.PdfReader;
//import com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator;
//import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
//import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
//import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class PrintXCL {

	public  void studentData()  {

		try {

			HSSFWorkbook myWorkBook = null;
			// conversion starts here....

//			HSSFRow myRow = null;

//			HSSFRow header = null;

			// HSSFCell myCell = null;
			myWorkBook = new HSSFWorkbook();
//			CreationHelper helper = myWorkBook.getCreationHelper();
//			HSSFSheet mySheet = myWorkBook.createSheet("result analysis");
			int pq = 0;

			FileInputStream file = new FileInputStream("D://TUE.xls");
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			java.util.Iterator<Row> rowiterator = sheet.iterator();
			Cell cell;
			Row row;
			int del = 0, fl = 0;
			Student s[] = new Student[200];
			Subject sub[] = null;
			int k = 0;
			// ittrate the row
			while (rowiterator.hasNext()) {

				int flag = 1;
				row = rowiterator.next();
				java.util.Iterator<Cell> celliterator = row.cellIterator();
				// itterrate the column
				// for del=0 stud info
				// for del=1 subject info
				if (celliterator.hasNext()) {

					if (del == 0) {
						s[pq] = new Student();
						fl = 0;
						
						while (celliterator.hasNext()) {

							cell = celliterator.next();
							String s1=cell.getStringCellValue();
							if(s1.contains("-"))
							{	del--;
								
								break;
							
							}else

							if (fl == 0) {
								s[pq].setRoll(cell.getStringCellValue());
								fl++;
							} else if (fl == 1) {
								s[pq].setSurname(cell.getStringCellValue());
								fl++;
							} else if (fl == 2) {
								s[pq].setName(cell.getStringCellValue());
								fl++;
							} else if (fl == 3) {
								s[pq].setMiddle(cell.getStringCellValue());
								fl++;
							} else if (fl == 4) {
								s[pq].setMother_name(cell.getStringCellValue());
								fl++;
							} else if (fl == 5) {
								s[pq].setSex(cell.getStringCellValue());
								fl++;
							} else if (fl == 6) {
								s[pq].setPrn(cell.getStringCellValue());
								fl++;
							} else if (fl == 7) {
								s[pq].setYear(cell.getStringCellValue());
								fl++;
							} else if (fl == 8) {
								s[pq].setSem(cell.getStringCellValue());
								fl++;
							} else if (fl == 9) {
								s[pq].setRegular(cell.getStringCellValue());
								fl++;
							} else if (fl == 10) {
								fl = 0;
								break;
							}

						}
						del++;
						// assign new array of subject to each student object
						sub = new Subject[50];

						
					} else if (del == 1) {

						

						if (celliterator.hasNext()) {

							fl = 0;
							// subject cell iteration
							while (celliterator.hasNext()) {

								cell = celliterator.next();
								// delimiter ---- found break and read for the
								// next student
								if ((cell.getStringCellValue()).contains("----")) {
									s[pq].setS(sub);
									flag = 0;
									k = 0;
									del = 0;
									pq++;
									break;
								}
								// if subject is graded read the current cell
								// else skip the current cell
								if (fl == 3) {
									if (sub[k].getInternal().equals("GRADE")) {

										k++;
										fl = 0;

									} else {

										k++;
										fl = 0;
										continue;
									}

								}

								if (fl == 0) {
									//create new subject object only when f==0 i.e. read subject code
									sub[k] = new Subject();

									sub[k].setSubcode(cell.getStringCellValue());

									fl++;
								} else if (fl == 1) {

									sub[k].setInternal(cell.getStringCellValue());
									fl++;

								} else if (fl == 2) {
									sub[k].setExternal(cell.getStringCellValue());
									fl++;

								}

							}

						}

					}

				}

			}
			//print on consol the object data
			for (int in = 0; in < pq; in++) {
				s[in].display();
				System.out.println();
			}
			file.close();
		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

}
