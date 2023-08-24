package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReadxlsFile {


  @DataProvider(name = "testData")
    public Object[] demoData(Method method) throws IOException {

      String Sheet1 =method.getName();

        File f = new File("C:\\Users\\NTS-Akshay Bokhare\\IdeaProjects\\SeleniumProject\\Framework_Mini\\src\\main\\resources\\testdata\\testData.xlsx");


        FileInputStream fis = new FileInputStream(f);

        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheetName = wb.getSheet(Sheet1);


        int totalRows = sheetName.getLastRowNum();

        System.out.println("Total Rows" + totalRows);


        Row rowCells = sheetName.getRow(0);

        int totalCols = rowCells.getLastCellNum();

        System.out.println("Total Columns" + totalCols);


        DataFormatter format = new DataFormatter();

        String testData[][] = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {

            int j;
            for (j = 0; j < totalCols; j++) {

                testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));

                //System.out.println(testData[i - 1][j]);


            }
            System.out.println("UserName And Password Is -> " + Arrays.toString(testData[i - 1]) + " ");

            System.out.println(" ");
        }

        return testData;

    }

}


//**** This Used To read Data From xlsx file //****

//    public static void main(String[] args) throws IOException {
//
//        File file = new File("C:\\Users\\NTS-Akshay Bokhare\\IdeaProjects\\SeleniumProject\\Framework_Mini\\src\\main\\resources\\testdata\\testData.xlsx");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Sheet sheetName = workbook.getSheet("Sheet1");
//
//
//        //TO Get Row Count
//        int rowCount = sheetName.getLastRowNum();
//        Row rowCells = sheetName.getRow(0);
//        //TO Get column Count
//        int columnCount = rowCells.getLastCellNum();
//
//
//        System.out.println("Column Count Is-->" + columnCount);
//        System.out.println("Row Count Is --> " + rowCount);
//        System.out.println(" ");
//
//
//        for (int i = 1; i <= rowCount; i++) {
//
//            Row cellData = sheetName.getRow(i);
//            String username = cellData.getCell(0).getStringCellValue();
//            String password = cellData.getCell(1).getStringCellValue();
//
//            System.out.println("UserName Is -> " + username + " ");
//            System.out.println("UserPassword Is -> " + password);
//            System.out.println(" ");
//        }
//
//    }
