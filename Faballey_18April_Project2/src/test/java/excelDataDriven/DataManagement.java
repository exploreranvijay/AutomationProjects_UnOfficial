package excelDataDriven;

public class DataManagement {

	public static void main(String[] args) throws Exception {
		
		ExcelAPI e=new ExcelAPI("C:\\Users\\Ranvijay\\Desktop\\suitex.xlsx");
		String sheetName="data";
		String testcaseName="TestB";
		
		//To Find the Matching Test Case Row Number
		int testStartRowNum=0;
		while(!e.getCellData(sheetName, 0,testStartRowNum).equals(testcaseName))
		{
			testStartRowNum++;
		}
        System.out.println("Test Start Row Number...:"+ testStartRowNum);
        
        //Calculate the Rows Of Data
        int colStartRowNum=testStartRowNum+1;
        int dataStartRowNum=testStartRowNum+2;
        
        int rows=0;
        while(!e.getCellData(sheetName, 0,dataStartRowNum+rows ).equals("")) {
        	rows++;
        }
        	System.out.println("Total Rows Are..:"+ rows);
        	
        //Calculate the Column Of Data
        	int cols=0;
            while(!e.getCellData(sheetName,cols,colStartRowNum ).equals(" ")) {
            	cols++;
            }
            	System.out.println("Total Column Are..:"+ cols);
            	//Read The Test Data Logic 
             for(int rNum=dataStartRowNum;rNum<dataStartRowNum;rNum++) {
            	 for(int cNum=0;cNum<cols;cNum++) {
            		 System.out.println(e.getCellData(sheetName, cNum, rNum));
            	 }
             }
            	
	}

}
