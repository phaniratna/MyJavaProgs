package com.demo.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.atm.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
