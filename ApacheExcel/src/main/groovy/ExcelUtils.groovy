import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.CreationHelper

/**
 * Created by yusoof on 03/10/14.
 */
class ExcelUtils {

    static HSSFWorkbook workbook
    static HSSFSheet sheet
    static CreationHelper creationHelper

    static HSSFSheet createWorkBook(String sheetName){
        workbook = new HSSFWorkbook()
        creationHelper = workbook.getCreationHelper()
        sheet = workbook.createSheet(sheetName)

        sheet
    }

}
