import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellStyle

/**
 * Created by yusoof on 03/10/14.
 */
class ExcelDateFormatting {

    public static void main(String[] args) {
        HSSFSheet sheet= ExcelUtils.createWorkBook( "date1")

        HSSFRow row = sheet.createRow(0)
        HSSFCell cell = row.createCell(0)
        HSSFCell cell1 = row.createCell(1)

        row.createCell(2).setCellValue(Cell.CELL_TYPE_ERROR)
        cell.setCellValue(new Date().toString())
        cell1.setCellValue(new Date())
        CellStyle cellStyle = ExcelUtils.workbook.createCellStyle()
        cellStyle.setDataFormat(ExcelUtils.creationHelper.createDataFormat().getFormat("m/d/yy h:mm"))
        cellStyle.setHidden(true)
        cell1.setCellValue(new Date())
        cell1.setCellStyle(cellStyle)
        FileOutputStream outputStream = new FileOutputStream(new File("./date.xls"))
        ExcelUtils.workbook.write(outputStream)
    }


}
