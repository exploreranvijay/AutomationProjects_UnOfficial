package excelDataDriven;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assignment1 {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Ranvijay\\Desktop\\data.xlsx");
		FileOutputStream fos;
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("People");
		XSSFRow row=sheet.getRow(0);
		
		int cellNum=0;
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals("Status"))
				cellNum=i;
		}
		for(int i=1;i<=10;i++) {
			row=sheet.getRow(i);
			XSSFCell cell=row.getCell(cellNum);
			
			if(row.getCell(cellNum-1).getNumericCellValue()<18) {
				cell.setCellValue("Minor");
			}
			else {
				cell.setCellValue("Major");;
			}
			
		}
		fos=new FileOutputStream("C:\\Users\\Ranvijay\\Desktop\\data.xlsx");
		wb.write(fos);	
		wb.close();
		fos.close();
			
			
			
			
			
		
		
		
		

	}

}
