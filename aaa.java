package pdf1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
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

public class aaa {

	public static void main(String[] args) throws FileNotFoundException {

		try {

			HSSFWorkbook myWorkBook = null;
			// conversion starts here....

			HSSFRow myRow = null;

			HSSFRow header = null;

			// HSSFCell myCell = null;
			myWorkBook = new HSSFWorkbook();
			CreationHelper helper = myWorkBook.getCreationHelper();
			HSSFSheet mySheet = myWorkBook.createSheet("result analysis");
			int pq = 0, q = 0;

			FileInputStream file = new FileInputStream("E://TUE.xls");
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			java.util.Iterator<Row> rowiterator = sheet.iterator();
			Cell cell;
			Row row;
			int del = 0, fl = 0;
			Student s[] = new Student[200];
			Subject sub[] = null;
			int k = 0;
			while (rowiterator.hasNext()) {

				int flag = 1;
				row = rowiterator.next();
				java.util.Iterator<Cell> celliterator = row.cellIterator();

				if (celliterator.hasNext()) {

					if (del == 0) {
						s[pq] = new Student();
						fl = 0;
						while (celliterator.hasNext()) {

							cell = celliterator.next();

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
						sub = new Subject[50];

						// q = 1;
					} else if (del == 1) {

						// System.out.println();

						if (celliterator.hasNext()) {

							fl = 0;
							while (celliterator.hasNext()) {

								cell = celliterator.next();
								if ((cell.getStringCellValue()).contains("----")) {
									s[pq].setS(sub);
									flag = 0;
									k = 0;
									del = 0;
									pq++;
									break;
								}
								// System.out.println();
								if (fl == 3) {
									if (sub[k].getInternal().equals("GRADE")) {
										// s[pq].setS(sub);
										k++;
										fl = 0;

									} else {

										k++;
										fl = 0;
										continue;
									}

								}

								if (fl == 0) {
									// if(!(k==0))
									// System.out.print(" "+sub[k-1]);
									sub[k] = new Subject();

									sub[k].setSubcode(cell.getStringCellValue());
									// System.out.print(cell.getStringCellValue());
									// System.out.print(" 0 k : " + k);
									fl++;
								} else if (fl == 1) {

									sub[k].setInternal(cell.getStringCellValue());
									fl++;
									// System.out.print(cell.getStringCellValue());
									// System.out.print(" 1 k : " + k);
								} else if (fl == 2) {
									sub[k].setExternal(cell.getStringCellValue());
									fl++;
									// System.out.print(cell.getStringCellValue());
									// System.out.print(" 2 k : " + k);
									// System.out.println();
								}

							}

							// if ((cell.getStringCellValue()).contains("----"))
							// {
							// flag = 0;
							// del = 0;

							// }
						}

					}

				}

				// System.out.println(cell.getStringCellValue());

			}
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
