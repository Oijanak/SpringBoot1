package com.broadway.springproject.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.broadway.springproject.model.Employee;

public class EmployeeExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {

		//1. define your own excel file name
		response.addHeader("Content-Disposition", "attachment;filename=SPECS.xls");
		
		//2. read data given by Controller
		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>) model.get("list");
		
		//3. create one sheet
		Sheet sheet = workbook.createSheet("EmployeeSheet");
		
		//4. create row#0 as header
		setHead(sheet);
		
		//5. create row#1 onwards rom List<T> 
		setBody(sheet,list);
	}


	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("First Name");
		row.createCell(2).setCellValue("Last Name");
		row.createCell(3).setCellValue("Gender");
	}
	
	private void setBody(Sheet sheet, List<Employee> list) {
		int rowNum = 1;
		for(Employee spec : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(spec.getId());
			row.createCell(1).setCellValue(spec.getFname());
			row.createCell(2).setCellValue(spec.getLname());
			row.createCell(3).setCellValue(spec.getGender());
		}
	}

}
