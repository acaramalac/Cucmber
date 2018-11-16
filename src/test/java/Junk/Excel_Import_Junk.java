package Junk;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel_Import_Junk {

    public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite) throws IOException{

        File file = new File("D:\\Projects\\Cucumber\\src\\main\\resources\\ImportedResults.xlsx");

        FileInputStream inputStream = new FileInputStream(file);

        Workbook excel = null;

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        if (fileExtensionName.equals(".xls")) {
            excel = new HSSFWorkbook(inputStream);
        } else if ( fileExtensionName.equals(".xlsx") ){
            excel = new XSSFWorkbook(inputStream);
        }

        Sheet sheet = excel.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        Row row = sheet.getRow(0);
        Row newRow = sheet.createRow(rowCount + 1);

        for(int j = 0; j < row.getLastCellNum(); j++){

            //Fill data in row

            Cell cell = newRow.createCell(j);

            cell.setCellValue(dataToWrite[j]);

        }

        inputStream.close();
    }

    public static void main(String...strings) throws IOException{

        //Create an array with the data in the same order in which you expect to be filled in excel file

        String[] valueToWrite = {"Mr. E","Noida"};

        //Create an object of current class

        Excel_Import_Junk objExcelFile = new Excel_Import_Junk();

        //Write the file using file name, sheet name and the data to be filled

        objExcelFile.writeExcel("D:\\Projects\\Cucumber\\src\\main\\resources", "ImportedResults.xlsx","Sheet2",valueToWrite);

    }
}
