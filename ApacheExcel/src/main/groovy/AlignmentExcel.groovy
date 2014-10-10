import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.util.HSSFColor
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.Workbook

/**
 * Created by yusoof on 04/10/14.
 */
class AlignmentExcel {
    public static void main(String[] args) {
        HSSFSheet sheet = ExcelUtils.createWorkBook("cellAlignment")
        HSSFRow row = sheet.createRow(0)
        row.setHeightInPoints(12)
        HSSFCell cell = row.createCell(0)

        CellStyle cellStyle = ExcelUtils.workbook.createCellStyle()
        cellStyle.setBorderRight(CellStyle.BORDER_DOUBLE)
        cellStyle.setBorderBottom(CellStyle.BORDER_DOUBLE)
        cellStyle.setAlignment(CellStyle.ALIGN_RIGHT)
        cellStyle.setVerticalAlignment(CellStyle.ALIGN_LEFT)

        cell.setCellStyle(cellStyle)
        cellStyle.setWrapText(true)
        cell.setCellValue("This is the string in the cell")
        FileOutputStream outputStream = new FileOutputStream(new File("./cellAlignment.xls"))
        ExcelUtils.workbook.write(outputStream)
        outputStream.close()
    }

}
