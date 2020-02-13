package com.trainingbasket.PaySlipGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.trainingbasket.beans.Employee;
import com.trainingbasket.services.PaySlipService;
import com.trainingbasket.utils.ExcelReader;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		PaySlipService service = new PaySlipService();
		List<Employee> employees = ExcelReader.getEmployeeFromExl("D:\\Emp_data.xlsx");
		// employees.forEach(x -> System.out.println(x));
		// service.generateSalarySlips(employees, "d:\\out.txt");
		String data = "";

		for (Employee employee : employees) {
			data += employee.printableSalarySlip();
		}

		Files.write(Paths.get("d:\\salarySlip.txt"), data.getBytes());
	}
}
