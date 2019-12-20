package pdf1;

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

import org.apache.poi.ss.usermodel.CreationHelper;


import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class Convertpdf {

	public  void convertPDF() {
		// TODO Auto-generated method stub
		PdfReader reader;
		 HSSFWorkbook myWorkBook = null ;
		 //conversion starts here....

		   HSSFRow myRow = null;
		   
		   HSSFRow header = null;
		   
		   
		   // HSSFCell myCell = null;
		     myWorkBook = new HSSFWorkbook();
		    CreationHelper helper = myWorkBook.getCreationHelper();
		    HSSFSheet mySheet = myWorkBook.createSheet("result analysis");
		    int pq=1;
		  /*  header = mySheet.createRow(0);
		    
		    header.createCell(0).setCellValue("Seat No");
		    header.createCell(1).setCellValue("Student Name");
		    header.createCell(2).setCellValue("Mother Name");
		    header.createCell(3).setCellValue("Sex");
		    */
		 try {
		    reader = new PdfReader("D://result.pdf");
		    
		    
		    PdfReaderContentParser parser = new PdfReaderContentParser(reader);
		   // final Pattern DATE_PATTERN=Pattern.compile("[0-9]{1,2} ? [/] ? [0-9]{1,2}?[/] ? [0-9]{2,4}",Pattern.CASE_INSENSITIVE);
		    //System.out.println("Is the PDF Encrypted "+reader.isEncrypted());
		    
		    TextExtractionStrategy strategy;
		   
		   // System.out.println("Pages = " + reader.getNumberOfPages());
		    String line = null;

		    for (int i = 1; i <= reader.getNumberOfPages(); i++) 
		    {
		        strategy = parser.processContent(i,new SimpleTextExtractionStrategy());
		        line = strategy.getResultantText();
		       //// System.out.println("line --- "+line);
		    
		        // replace all ':' with spaces
		        line =line.replace(':', ' ' );
		        List <String> lines = IOUtils.readLines(new StringReader(line)); 

		    
		        //System.out.println(lines.size());
		    
		        for (int j = 0; j < lines.size(); j++) 
		        {
		        	// read line
		        	String s =  lines.get(j);
		      /*  	Matcher match=DATE_PATTERN.matcher(s); // tried to remove date
				    
		        if(match.matches())
		        	{
		        	continue;
		        	} */
		        	if(s.contains("MARKS")||s.contains("NO.OF")||s.contains("GRAND TOTAL")||s.contains("SEAT NO.")||s.contains("SAVATRIBAI")||s.contains("UNIVERSITY")||s.contains("RESULT OF ")||s.contains("CLASS WITH DISTINCTION")||s.contains("ABOVE=SECOND")||s.contains("SIR PARASHURAMBHAU"))
		        	{
		        	if(s.contains("SEAT NO.")||s.contains("ABOVE=SECOND")||s.contains("SIR PARASHURAMBHAU"))
		        	{
		        		j++;
		        	}
		        		continue;
		        	}
		        	// if line contains "---" then donot process that line and continue 
		        	/*if(s.contains("----"))
		        	{
		        		continue;
		        	}
		      */  	
		        	// supress all extra spaces
		        	s = s.trim();

		        	// split string, delimiter is space
		        	String str[] = s.split(" ");
		        	
		        	
		        	// create row for each line
		            myRow = mySheet.createRow(pq);
		            pq++;
		            for (int k = 0; k < str.length; k++) 
		            {
		               	str[k] = str[k].replace(':',  ' ');
		               	str[k] = str[k].replace('*',  ' ');
		       		 //if (str[k].equals("NO.OF"))
		       			 
		           	if(str[k]=="\n"|| str[k]==" ")
		           			{
		           		continue;
		                  }
		            	
		            	str[k] = str[k].trim();
		            	//System.out.println(str[k]);
		            	/*if(str[k].isEmpty())
		            		continue;*/
		            	//if(str[k].equals(" "))
		            		//continue;
		            	if(!(str[k].equals("   "))||!(str[k].equals("\t"))||!(str[k].equals("\n")))
		            	myRow.createCell(k).setCellValue(helper.createRichTextString(str[k]));
		            }
		    }

		    }

		            FileOutputStream fileOut;
		            try {
		                fileOut = new FileOutputStream("D://AM.xls");
		                myWorkBook.write(fileOut);
		                fileOut.close();
		               
		            } catch (FileNotFoundException e) {
		               // System.out.println("FILE NOT FOUND");
		            }
		        
				        reader.close();
		        
		        
		        } catch (IOException e) {
		    }
		
		
		
		
	}

}
