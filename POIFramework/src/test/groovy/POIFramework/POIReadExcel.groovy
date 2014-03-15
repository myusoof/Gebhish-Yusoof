package POIFramework

import ProductCatalogueClient.ProductCatalogueClient
import org.apache.poi.hssf.record.formula.functions.Cell
import org.apache.poi.hssf.record.formula.functions.Column
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.CreationHelper
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.testng.annotations.Test

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 22/02/14
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 */
class POIReadExcel {
    ProductCatalogueClient productCatalogueClient = new ProductCatalogueClient("http://localhost:8080/");
    Workbook wb = null
    CellStyle passed = null
    CellStyle failed = null
    public void setColorForCell(boolean isCorrect, XSSFCell cell){
        passed = wb.createCellStyle()
        failed = wb.createCellStyle();
        if(isCorrect){
            passed.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
            passed.setFillPattern(CellStyle.BIG_SPOTS);
            cell.setCellStyle(passed)
        }else{
            failed.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
            failed.setFillPattern(CellStyle.BIG_SPOTS);
            cell.setCellStyle(failed)
        }
    }
    public void readValueOfSheet(String path, String sheetName) {
        wb = new XSSFWorkbook (path);
        XSSFSheet refresh = wb.getSheet(sheetName);
        Iterator rows = refresh.rowIterator()
        while(rows.hasNext()){
            XSSFRow row = (XSSFRow)rows.next()
            Iterator cellIterator = row.cellIterator()
            while(cellIterator.hasNext()){
                XSSFCell cell =  cellIterator.next()
                try {
                    print cell.getNumericCellValue()
                } catch (Exception e) {
                    println cell.getStringCellValue()
                }
            }
            println ""
        }
    }
    public void writeValueToSheet(String path, String sheetName){
        wb = new XSSFWorkbook(path)
        XSSFSheet sheet = wb.getSheet(sheetName)
        Iterator rowIterator = sheet.rowIterator()
        while(rowIterator.hasNext()){
            XSSFRow row = rowIterator.next()
            XSSFCell cell = row.createCell(row.getLastCellNum())
            cell.setCellValue("1")
        }
        FileOutputStream fileOut = new FileOutputStream(path);
        wb.write(fileOut);
        fileOut.close();
    }
    public void createWorkBook(){
        //Workbook wb = new HSSFWorkbook();
        wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();

        XSSFSheet sheet = wb.createSheet("sheet1");
        // Create a row and put some cells in it. Rows are 0 based.
        for(int j in 0..30){
        XSSFRow row = sheet.createRow((short)j);
        for (int i in 0..30){
        // Create a cell and put a value in it.
        XSSFCell cell = row.createCell(i);
            if(i %2 == 0){
                setColorForCell(true, cell)
            }else{
                setColorForCell(false, cell)
            }

            cell.setCellValue(i);
        }
        }
        /*// Or do it on one line.
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(
                createHelper.createRichTextString("This is a string"));
        row.createCell(3).setCellValue(true);*/

        // Write the output to a file
 //       FileOutputStream fileOut = new FileOutputStream("/home/yusoof/yusoofExtend/excel2.xlsx");
        FileOutputStream fileOut = new FileOutputStream("/home/yusoof/yusoofExtend/excel2.xlsx");
        wb.write(fileOut);
        fileOut.close();

        def dataOne = productCatalogueClient.get(path: "productService/products/device").data
        println dataOne.id.last()
    }
    @Test
    public void readExcelOne(){
        createWorkBook()
        //readValueOfSheet("/media/yusoof/ubuntuextended/excel1.xlsx", "Refresh")
        //writeValueToSheet("/media/yusoof/ubuntuextended/excel1.xlsx", "Refresh")
        //readValueOfSheet("/media/yusoof/ubuntuextended/q1_tariffs_publish_6th_march_updated18thfebupdated.xlsx", "Refresh")
        //writeValueToSheet("/media/yusoof/ubuntuextended/q1_tariffs_publish_6th_march_updated18thfebupdated.xlsx", "Refresh")
    }
}