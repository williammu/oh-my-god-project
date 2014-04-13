package com.projectK.utils;

import java.io.File;
import java.io.FileInputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelHelper{
	
	public static Workbook readExcel(File excelFile){
		try {
			FileInputStream is = new FileInputStream(excelFile);

			Workbook workbook = null;
			if (excelFile.getName().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(is);
			} else {
				workbook = new HSSFWorkbook(is);
			}
			return workbook;
		}catch(Throwable e){
			return null;
		}
	}
	public static List<String[]> readExcel(String excelPath){
		List<String[]> dataList = new ArrayList<String[]>();
		try {
			File excelFile = new File(excelPath);
			FileInputStream is = new FileInputStream(excelFile);

			Workbook workbook = null;
			if (excelFile.getName().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(is);
			} else {
				workbook = new HSSFWorkbook(is);
			}

			int sheetNum = workbook.getNumberOfSheets();

			// 不要小数
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(0);

			// 转换成保留两位小数
			NumberFormat nff = NumberFormat.getInstance();
			nff.setMaximumFractionDigits(2);

			for (int i = 0; i < sheetNum; i++) {
				Sheet childSheet = workbook.getSheetAt(i);
				int rowNum = childSheet.getLastRowNum();

				for (int j = 2; j < rowNum; j = j + 6) {
					Row row1 = childSheet.getRow(j);
					Row row6 = childSheet.getRow(j + 5);
					if (null == row1.getCell(0)) {
						System.out.println("这里已没有数据，在第" + i + "个Sheet,第" + j + "行");
						break;
					} else {
						String id = row1.getCell(0).toString();
						if (!id.equals("")) {
							id = nf.format(Float.valueOf(id));
							String[] arr_avg = new String[7];
							arr_avg[0] = id;
							arr_avg[6] = "resptime_avg";

							String[] arr = new String[7];
							arr[0] = id;
							arr[6] = "resptime_trend";

							for (int h = 0; h < 5; h++) {
								Cell cell = row6.getCell(9 + h);
								String value = cell.toString();
								String avg = "";
								// 单元格为公式
								if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
									try {
										value = String.valueOf(cell.getStringCellValue());
									} catch (IllegalStateException e) {
										value = String.valueOf(cell.getNumericCellValue());
									}
								}
								if (value.toUpperCase().equals("NA") || value.toUpperCase().equals("N/A") || value.isEmpty()) {
									avg = value;
								} else {
									avg = nff.format(Float.valueOf(value));
								}
								arr_avg[h + 1] = avg;

								//
								String testValue = "";
								for (int g = 0; g < 5; g++) {
									String tmpStr = childSheet.getRow(j + g).getCell(9 + h).toString();
									if (tmpStr.toUpperCase().equals("NA") || tmpStr.toUpperCase().equals("N/A") || tmpStr.isEmpty()) {
										testValue += tmpStr + ",";
									} else {
										testValue += nff.format(Float.valueOf(tmpStr)) + ",";
									}
								}
								arr[h + 1] = testValue;
							}
							dataList.add(arr);
							dataList.add(arr_avg);
						}
					}
				}
			}
			System.out.println("dataList.size(): " + dataList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataList;
	}

	public static HSSFCell createCell(HSSFRow row, int startIndex, Object value, HSSFCellStyle style){
		HSSFCell cell = row.createCell(startIndex);
		row.getSheet().autoSizeColumn(startIndex++);
		cell.setCellValue(value.toString());
		cell.setCellStyle(style);
		return cell;
	}
	
	public static void createCells(HSSFRow row, int startIndex, Object[] valueList, HSSFCellStyle style){
		for(Object value: valueList){
			HSSFCell cell = row.createCell(startIndex++);
			//row.getSheet().autoSizeColumn(startIndex++);
			if(value != null){
				cell.setCellValue(value.toString());
			}
			cell.setCellStyle(style);
		}
	}
	
	public static void doFormat(HSSFSheet sheet){
		sheet.setAutoFilter(new CellRangeAddress(sheet.getFirstRowNum(), sheet.getLastRowNum(), sheet.getRow(0).getFirstCellNum(), sheet.getRow(0).getLastCellNum() - 1));
		for(int i = sheet.getRow(0).getFirstCellNum(); i < sheet.getRow(0).getLastCellNum(); ++i){
			sheet.autoSizeColumn(i);
		}
	}
	
	public static String getCellValue(Cell cell) {
		String value = null;
		if (cell != null) {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_FORMULA:
				// cell.getCellFormula();
				try {
					value = String.valueOf(cell.getNumericCellValue());
				} catch (IllegalStateException e) {
					value = String.valueOf(cell.getRichStringCellValue());
				}
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				value = String.valueOf(cell.getNumericCellValue());
				break;
			case HSSFCell.CELL_TYPE_STRING:
				value = String.valueOf(cell.getRichStringCellValue());
				break;
			}
		}

		return value;
	}
}
