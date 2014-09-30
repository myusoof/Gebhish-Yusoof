package SqlConnector

import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFCellStyle
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.hssf.util.HSSFColor
import org.apache.poi.ss.usermodel.CellStyle

/**
 * Created by ee on 29/09/14.
 */
class ExcelReaderHelper {
    public static void main(String[] args) {
        HSSFWorkbook workbook = new HSSFWorkbook()
        HSSFSheet sheet = workbook.createSheet("sheet1")
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        sheet.setZoom(5, 4)

        FileOutputStream fileOutputStream = new FileOutputStream("./workbook.xls")
        HSSFRow row = sheet.createRow(0)
        HSSFCell cell = row.createCell(0)

        [0: "Yusoof", 1: 2, 2: "This is a String"].each {
            cell = row.createCell(it.getKey())
            cell.setCellValue(it.value)
            cellStyle.setAlignment(CellStyle.ALIGN_CENTER)
            cellStyle.setFillPattern(HSSFCellStyle.FINE_DOTS );
            cellStyle.setFillPattern(new HSSFColor.BLACK().getIndex())
            cell.setCellStyle(cellStyle)

        }
        workbook.write(fileOutputStream)
        fileOutputStream.close()
    }
}
