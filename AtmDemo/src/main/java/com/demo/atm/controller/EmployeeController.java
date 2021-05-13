package com.demo.atm.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.atm.dto.EmployeeDTO;
import com.demo.atm.entity.Employee;
import com.demo.atm.service.EmployeeService;
import com.demo.atm.transformer.EmployeeTransformer;
import com.demo.atm.validation.DtoValidationUtils;

@Component
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDto) {
		DtoValidationUtils.validateEmployee(employeeDto);

		Employee employee = EmployeeTransformer.fromDtoToEntity(employeeDto);

		return ResponseEntity.created(URI.create("/employee/save")).body(employeeService.saveEmployee(employee));

	}

}
