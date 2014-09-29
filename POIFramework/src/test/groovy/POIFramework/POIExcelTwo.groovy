package POIFramework

import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 24/02/14
 * Time: 21:28
 * To change this template use File | Settings | File Templates.
 */
class POIExcelTwo {
    FileInputStream fileInputStream = new FileInputStream("/home/yusoof/yusoofExtend/q1_tariffs_publish_6th_march_updated18thfebupdated.xlsx")
    XSSFWorkbook workbook = new XSSFWorkbook(("/home/yusoof/yusoofExtend/q1_tariffs_publish_6th_march_updated18thfebupdated.xlsx"))
    @Test
    void testOneTwo(){

        XSSFSheet refreshSheet = workbook.getSheet("Refresh")
        println refreshSheet.getNumMergedRegions()
        println refreshSheet.getMergedRegion(3)
        XSSFRow tariffRow = refreshSheet.getRow(1)
        Iterator cells = tariffRow.cellIterator()

        while(cells.hasNext()){
            XSSFCell cell = cells.next()
            if(cell != ""){
                println cell
            }
        }
    }
}
