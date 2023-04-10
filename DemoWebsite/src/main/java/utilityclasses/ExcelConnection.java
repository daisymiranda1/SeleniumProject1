package utilityclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConnection {

	public static Map<String, Map<String, String>> readExcelFile() throws IOException {

		File file = new File("D:\\test1\\SurveyTestSuite\\src\\main\\testdata\\SurveyTestdata.xlsx");
		FileInputStream inputstream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		XSSFSheet testsheet = wb.getSheet("QA");
		/*
		 * int rowCount=testsheet.getLastRowNum()-testsheet.getFirstRowNum(); for(int
		 * i=1;i<=rowCount;i++) { Row row=testsheet.getRow(i); for(int
		 * j=0;j<row.getLastCellNum();j++) {
		 * System.out.println(row.getCell(j).getStringCellValue());
		 * 
		 * } }
		 */

		Map<String, Map<String, String>> Data = new HashMap<String, Map<String, String>>();
		// get column headers
		List<String> columnHeader = new ArrayList<String>();
		Row row = testsheet.getRow(0);
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			columnHeader.add(cellIterator.next().getStringCellValue());
		}
		// get rows for each column
		int rowCount = testsheet.getLastRowNum();
		// row has first row, so we will use it to find number of columns
		int columnCount = row.getLastCellNum();
		for (int i = 1; i <= rowCount; i++) {
			Map<String, String> singleRowData = new HashMap<String, String>();
			Row row1 = testsheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				Cell cell = row1.getCell(j);
				singleRowData.put(columnHeader.get(j), getCellValueAsString(cell));
			}
			// complete data
			Data.put(String.valueOf(i), singleRowData);
		}
		wb.close();
		return Data;

	}

	public static String getCellValueAsString(Cell cell) {
		String cellValue = null;
		switch (cell.getCellType()) {
		case NUMERIC:
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case FORMULA:
			cellValue = cell.getCellFormula();
		case BLANK:
			cellValue = "BLANK";
		default:
			cellValue = "DEFAULT";
		}
		return cellValue;
	}

}
