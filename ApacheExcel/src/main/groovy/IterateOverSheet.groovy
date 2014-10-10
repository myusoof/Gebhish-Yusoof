import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory

/**
 * Created by yusoof on 04/10/14.
 */
class IterateOverSheet {
    public static void main(String[] args) {
        HSSFWorkbook workbook = new HSSFWorkbook()
        HSSFSheet sheet = workbook.createSheet("Sheetone")
        (0..15).each {
            HSSFRow row = sheet.createRow(it)
            (0..15).each {
                row.setHeightInPoints(50)
                HSSFCell cell = row.createCell(it)

                cell.setCellValue("This is again a string")
                println cell.getCellType()
                println row.getCell(it,Row.RETURN_BLANK_AS_NULL)
            }
        }
        Sheet sheet1 = workbook.getSheetAt(0)
        for(Row row : sheet1){
            for(Cell cell: row){
                println cell.getStringCellValue()
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream(new File("./iterate.xls"))
        workbook.write(fileOutputStream)
        fileOutputStream.close()

        Workbook wb = WorkbookFactory.create(new FileInputStream("./iterate.xls"))

        Sheet sheetRead = wb.getSheetAt(0)
        println sheetRead.getLastRowNum()

    }
}
