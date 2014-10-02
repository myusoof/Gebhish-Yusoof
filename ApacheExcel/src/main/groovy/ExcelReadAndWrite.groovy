import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFCellStyle
import org.apache.poi.hssf.usermodel.HSSFComment
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.Comment
import org.apache.poi.ss.usermodel.CreationHelper
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.util.WorkbookUtil

class ExcelReadAndWrite {
    public static void main(String[] args) {
        HSSFWorkbook workbook = new HSSFWorkbook()
        CreationHelper createHelper = workbook.getCreationHelper();

        HSSFSheet sheet1 = workbook.createSheet("sheet1")
        HSSFSheet sheet2 = workbook.createSheet("sheet2")
        HSSFSheet saveSheet = workbook.createSheet(WorkbookUtil.createSafeSheetName("['yusoof's]"))
        HSSFRow row0 = sheet1.createRow(0)
        HSSFCell cell0 = row0.createCell(0)
        HSSFCell cell1= row0.createCell(1)

        cell0.setCellValue("This is a string")
        cell1.setCellValue(createHelper.createRichTextString("This is a string's"))
        FileOutputStream fileOutputStream = new FileOutputStream(new File("./workbook.xls"))
        workbook.write(fileOutputStream)
        fileOutputStream.close()


    }
}
