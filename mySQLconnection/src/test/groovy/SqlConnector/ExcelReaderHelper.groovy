package SqlConnector

import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook

/**
 * Created by ee on 29/09/14.
 */
class ExcelReaderHelper {
    public static void main(String[] args) {
       HSSFWorkbook  workbook = new HSSFWorkbook()
        HSSFSheet sheet = workbook.createSheet("sheet1")
        sheet.setZoom(5,4)
        FileOutputStream fileOutputStream = new FileOutputStream("./workbook.xls")
        workbook.write(fileOutputStream)
        fileOutputStream.close()
    }
}
