import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.CellStyle


class ExcelBorderFormatting {

    public static void main(String[] args) {
        HSSFWorkbook workbook = new HSSFWorkbook()
        HSSFSheet sheet = workbook.createSheet("formatting")

        (0..15).each {

            HSSFRow row = sheet.createRow(it)
            (0..15).each {
                HSSFCell cell= row.createCell(it)
                cell.setCellValue("a")
                if(it == 0){
                    setBorderThick(workbook)
                }
            }
        }

        CellStyle borderCellStyle = workbook.createCellStyle()


        FileOutputStream fileOutputStream = new FileOutputStream(new File("./border.xls"))
        workbook.write(fileOutputStream)
        fileOutputStream.close()

    }

    void setBorderThick(HSSFWorkbook workbook) {
        if (workbook.getSheetAt(0).getFirstRowNum() == 0) {
            setCornerBorder(workbook)
        }
    }
    CellStyle setCornerBorder(HSSFWorkbook workbook){
        CellStyle cellStyle = workbook.createCellStyle()
        cellStyle.setBorderTop(CellStyle.BORDER_THICK)
        cellStyle
    }
}
