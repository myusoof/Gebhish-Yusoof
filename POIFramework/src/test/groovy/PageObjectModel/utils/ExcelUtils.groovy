package PageObjectModel.utils

import org.apache.poi.hssf.record.formula.functions.Column
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 16/03/14
 * Time: 00:08
 * To change this template use File | Settings | File Templates.
 */
class ExcelUtils {
    XSSFWorkbook workbook = new XSSFWorkbook(("/home/yusoof/yusoofExtend/TestExitReport27022014.xlsx"))

    @Test
    void testMethod(){
        readValueFromCell()
    }

    void readValueFromCell(){
        XSSFSheet set1 = workbook.getSheet("Set1")
        Row header = set1.getRow(0);
        int n = header.getLastCellNum();
        //int j = set1.getPhysicalNumberOfRows()

        //get first row
        for(int i = 0; i <=header.getLastCellNum();i++){
            println header.getCell(i)
        }

        //get first column
        for(int j =0 ; j <=set1.getLastRowNum();j++){
            Row row = set1.getRow(j)
            println row.getCell(0)
        }

       /* println n
        println j
        for(int k = 0; k <=j;k++){
            for(int a = 0; a <=n ; a++){
                String row = set1.getRow(a).getCell(k)
                if(row != null)
                    println row
            }
        }*/
        /*
        for(int i = 0; i <=n;i++){
            for(int j =0; j <=set1.getPhysicalNumberOfRows();j++){
                println header.getCell(i)
            }

        }*/
    }

}
