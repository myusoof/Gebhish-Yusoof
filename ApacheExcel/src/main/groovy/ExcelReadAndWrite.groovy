import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFCellStyle
import org.apache.poi.hssf.usermodel.HSSFComment
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.Comment
import org.apache.poi.ss.usermodel.CreationHelper
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.util.WorkbookUtil

class ExcelReadAndWrite {
    public static void main(String[] args) {
        HSSFWorkbook workbook = new HSSFWorkbook()
        CreationHelper createHelper = workbook.getCreationHelper();

        HSSFSheet sheet1 = workbook.createSheet("sheet1")
        HSSFSheet sheet2 = workbook.createSheet("sheet2")
        HSSFSheet saveSheet = workbook.createSheet(WorkbookUtil.createSafeSheetName("['yusoof's]"))

        int i = 0
        (0..15).each {
            HSSFRow row = sheet1.createRow(it)
                (0..16).each {
                    HSSFCell cell = row.createCell(it)
                    cell.setCellValue(i)
                    if(i % 2 == 0){
                        HSSFCellStyle cellStyle = workbook.createCellStyle()
                        cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex())
                        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                        cell.setCellStyle(cellStyle)
                    }
                    i++
                }
        }

        FileOutputStream fileOutputStream = new FileOutputStream(new File("./workbook.xls"))
        workbook.write(fileOutputStream)
        fileOutputStream.close()
    }
}
