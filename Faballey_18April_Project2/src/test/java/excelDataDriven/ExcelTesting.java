package excelDataDriven;

public class ExcelTesting {

	public static void main(String[] args) throws Exception {
		ExcelAPI e=new ExcelAPI("C:\\Users\\Ranvijay\\Desktop\\testdata1.xlsx");
		System.out.println(e.getRowCount("login"));
		System.out.println(e.getColumnCount("login"));
		System.out.println(e.getCellData("login", 1, 2));
        System.out.println(e.getCellData("login", "UserName", 2));
        e.setCellData("login", 4, 4, "Skipped");
	}

}
