package Utilities;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	static FileInputStream f;
 	static XSSFWorkbook w;
    static XSSFSheet s;
	public static String getStringData(int a, int b, String filePathName, String sheetName) throws IOException

			{
		f = new FileInputStream(System.getProperty("user.dir")+filePathName);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheetName);

    	XSSFRow r = s.getRow(a);

		XSSFCell c = r.getCell(b);

		return c.getStringCellValue();		

			}

			

			public static String getIntegerData(int a, int b,String filePathName, String sheetName ) throws IOException

			{

		f = new FileInputStream(System.getProperty("user.dir")+filePathName);

    	w = new XSSFWorkbook(f);

		s = w.getSheet("Sheet1");

		XSSFRow r = s.getRow(a);

		XSSFCell c = r.getCell(b);

				//to convert integer to string

    	int y = (int)c.getNumericCellValue();		

		return String.valueOf(y); //to return the value of y
	

			}
		}




