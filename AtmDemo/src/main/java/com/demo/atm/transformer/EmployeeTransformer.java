package com.demo.atm.transformer;

import javax.validation.Valid;

import com.demo.atm.dto.EmployeeDTO;
import com.demo.atm.entity.Employee;

public class EmployeeTransformer {

	public static Employee fromDtoToEntity(@Valid EmployeeDTO employeeDto) {
		return Employee.builder().id(employeeDto.getId()).name(employeeDto.getName()).build();

	}

}
