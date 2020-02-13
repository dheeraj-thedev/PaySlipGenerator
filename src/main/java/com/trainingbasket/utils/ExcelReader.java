package com.trainingbasket.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.trainingbasket.beans.*;

public class ExcelReader {
	public static List<Employee> getEmployeeFromExl(String path) throws IOException {

		List<Employee> employees = new ArrayList<Employee>();
		FileInputStream inputStream = new FileInputStream(new File(path));
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		int colctr = 0;
		int rowctr = 0;
		for (Row row : firstSheet) {
			Employee employee = new Employee();
			for (Cell cell : row) {
				if (rowctr > 0) {
					int colIdx = cell.getColumnIndex();
					switch (colIdx) {
					case 0:
						employee.setEmpId((int) cell.getNumericCellValue());
						// System.out.println(cell.getNumericCellValue());
						break;
					case 1:
						// System.out.println(cell.getStringCellValue());
						employee.setEmpName(cell.getStringCellValue());
						break;
					case 2:
						// System.out.println(cell.getStringCellValue());
						employee.setDepartment(cell.getStringCellValue());
						break;
					case 3:
						employee.setBasicSalary((float) cell.getNumericCellValue());
						// System.out.println(cell.getNumericCellValue());
						break;
					case 4:
						employee.setAllowances((float) cell.getNumericCellValue());
						/// System.out.println(cell.getNumericCellValue());
						break;

					case 5:
						// System.out.println(cell.getNumericCellValue());
						employee.setInsDed((float) cell.getNumericCellValue());
						break;
					case 6:
						// System.out.println(cell.getNumericCellValue());
						employee.setTaxDed((float) cell.getNumericCellValue());
						break;
					default:
						System.out.println("Issue");
						break;
					}

				}

			}
			if (rowctr > 0) {
				employees.add(employee);
			}
			System.out.println();
			rowctr++;
		}
		workbook.close();

		inputStream.close();

		return employees;
	}
}
