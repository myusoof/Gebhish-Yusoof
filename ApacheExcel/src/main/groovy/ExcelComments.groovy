import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFClientAnchor
import org.apache.poi.hssf.usermodel.HSSFComment
import org.apache.poi.hssf.usermodel.HSSFPatriarch
import org.apache.poi.hssf.usermodel.HSSFRichTextString
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Comment

/**
 * Created by yusoof on 02/10/14.
 */
class ExcelComments {
    public static void main(String[] args) {
        HSSFWorkbook workbook = new HSSFWorkbook()
        HSSFSheet sheet = workbook.createSheet("sheet1")
        HSSFPatriarch patr = sheet.createDrawingPatriarch();
        HSSFComment comment1 = patr.createComment(new HSSFClientAnchor(0, 0, 10, 10, (short)4, 2, (short) 6, 5));
        comment1.setString(new HSSFRichTextString("String in less"))
        HSSFRow row = sheet.createRow(0)

        HSSFCell cell = row.createCell(0)

        comment1.setAuthor("Yusoof")
        comment1.setFillColor(204, 236, 255)
        cell.setCellComment(comment1)
        cell.setCellValue("This is the string")
        FileOutputStream outputStream = new FileOutputStream(new File("./workbook1.xls"))
        workbook.write(outputStream)
        outputStream.close()
    }
}
