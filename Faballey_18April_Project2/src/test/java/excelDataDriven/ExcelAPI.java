package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAPI {
	public FileInputStream fis=null;
	public FileOutputStream fos=null;
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet=null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	String xfilePath;
	
	public ExcelAPI(String xfilePath) throws Exception {
		System.out.println("Excel Has Initilized.........");
		this.xfilePath=xfilePath;
		fis=new FileInputStream(xfilePath);
		workbook=new XSSFWorkbook(fis);
	}
	public int getRowCount(String sheetName) {
		sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum()+1;
		return rowCount;
	}
	public int getColumnCount(String sheetName) {
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(0);
		int colCount=row.getLastCellNum();
		return colCount;
		
	}
	//Reading Cell Data from Excel By Using Column Number
	public String getCellData(String sheetName,int colNum, int rowNum) {
		try {
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			if(cell.getCellTypeEnum()==CellType.STRING)
				return cell.getStringCellValue();
			else if(cell.getCellTypeEnum()==CellType.NUMERIC||cell.getCellTypeEnum()==CellType.BOOLEAN)
			{
				String cellValue=String.valueOf(cell.getBooleanCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat dt=new SimpleDateFormat("dd/mm//yyyy");
					Date date=cell.getDateCellValue();
					cellValue=dt.format(date);
				}
				return cellValue;
			}
			else if(cell.getCellTypeEnum()==CellType.BLANK)
				return " ";
			else
				return String.valueOf(cell.getBooleanCellValue());
			}
		catch(Exception e) {
			e.printStackTrace();
			return "No Matching Value";
		}
		
	}
	//Reading Cell Data From Excel By Using Column Name
	public String getCellData(String sheetName, String colName,int rowNum) {
		try
		{
		
			int colNum=-1;
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++) {
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			row=sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			if(cell.getCellTypeEnum()==CellType.STRING)
				return cell.getStringCellValue();
			else if(cell.getCellTypeEnum()==CellType.NUMERIC||cell.getCellTypeEnum()==CellType.BOOLEAN)
			{
				String cellValue=String.valueOf(cell.getBooleanCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat dt=new SimpleDateFormat("dd/mm//yyyy");
					Date date=cell.getDateCellValue();
					cellValue=dt.format(date);
				}
				return cellValue;
			}
			else if(cell.getCellTypeEnum()==CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
			}
		catch(Exception e) {
			e.printStackTrace();
			return "No Matching Value";
		}
		
	}
	
    //Writing Cell Data to Excel BY Using Column Number
	public boolean setCellData(String sheetName,int colNum, int rowNum, String value) {
		try {
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			cell.setCellValue(value);
			fos=new FileOutputStream(xfilePath);
			workbook.write(fos);
			fos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
		
	}
	 //Writing Cell Data to Excel BY Using Column Name
	public boolean setCellData(String sheetName,String colName, int rowNum, String value) {
		try {
			int colNum=-1;
		
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rowNum);
			
			for(int i=0;i<row.getLastCellNum();i++) {
				if(row.getCell(i).getStringCellValue().trim().equals("colName")) 
				   colNum=i;
			}
			row=sheet.getRow(rowNum+1);
			cell=row.getCell(colNum);
			cell.setCellValue(value);
			fos=new FileOutputStream(xfilePath);
			workbook.write(fos);
			fos.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
            return true;
	}

}








